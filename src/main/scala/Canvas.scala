import java.io.File
import javax.imageio.ImageIO

import scala.swing.{Graphics2D, Component}
import scala.swing.event.{MouseClicked, KeyReleased, Key, KeyPressed}

/**
 * Created by Kasia on 2016-01-11.
 */
class Canvas extends Component{

  val evader = new Evader
  val dc = new dropControl
  var gameOver = false
  val i = ImageIO.read(new File("gameover1.png"))
  val bg = ImageIO.read(new File("bg.jpg"))
  focusable = true
  requestFocus()

  listenTo(mouse.clicks)
  reactions +={
    case e: MouseClicked =>{
      this.requestFocus()
    }
  }

  listenTo(keys)
  reactions += {
    case KeyPressed(_, Key.Right, _, _) =>
      if(!gameOver) evader.moveRight()
    case KeyPressed(_, Key.Left, _, _) =>
      if(!gameOver) evader.moveLeft()
  }

  override def paintComponent(g : Graphics2D): Unit = {
    checkCollision()
    super.paintComponent(g)
    g.drawImage(bg, null, 0, 0)
    evader.paint(g, this)
    dc.paint(g, this)
    if(gameOver) {
      evader.dead = true
      g.drawImage(i, null, 250, 200)
      dc.stopTimers()
    }
  }

  def checkCollision(): Unit = {
    for(d <- dc.droppers) {
      if(evader.polygon.intersects(d.rectangle)) {
        gameOver = true
      }
    }
  }

  def nullify(): Unit = {
    dc.clearDroppers()
    gameOver = false
    dc.startTimers()
    dc.delay = 7000
    evader.dead = false
  }

}
