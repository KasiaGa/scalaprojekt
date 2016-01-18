
import java.awt.Polygon
import java.io.File
import javax.imageio.ImageIO

import scala.swing._
import scala.swing.event.{KeyReleased, Key, KeyPressed}

/**
 * Created by Kasia on 2016-01-11.
 */
class Evader extends Component{

  val y = 500
  var x = 475
  var dead = false
  var counter = 0
  var speed  = 5
  var images = Array(ImageIO.read(new File("evader1.png")), ImageIO.read(new File("evader2.png")),
    ImageIO.read(new File("evader3.png")), ImageIO.read(new File("evader4.png")))
  val iDead = ImageIO.read(new File("evader1.png"))
  val polygon = new Polygon(Array[Int](x, x+50, x+100), Array[Int](y+70, y+10, y+70), 3)

  def moveLeft(): Unit = {
    if(x>0) {x-=speed
    polygon.translate(-speed, 0)}
    if (speed < 12) {speed = speed + 1}
    }

  def moveRight(): Unit = {
    if(x<900) {x+=speed
    polygon.translate(speed, 0)}
    if (speed < 12) {speed = speed + 1}
    }


  def paint(g: Graphics2D, c: Canvas): Unit = {
    if (!dead) {
      g.drawImage(images(counter), null, x, y)
    }
    if(dead) {
      g.drawImage(iDead, null, x, y)
    }
  }

  val changeImage = new javax.swing.AbstractAction() {
    def actionPerformed(e: java.awt.event.ActionEvent) = {
      counter = (counter+1)%4
    }
  }

  val t = new javax.swing.Timer(150, changeImage)
  t.setRepeats(true)
  t.start()



}
