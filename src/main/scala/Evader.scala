
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
  var direction = false
  var dead = false
  val iDeadRight = ImageIO.read(new File("flappy02_2.png"))
  val iDeadLeft = ImageIO.read(new File("flappy03_2.png"))
  val iRight = ImageIO.read(new File("flappy00_2.png"))
  val iLeft = ImageIO.read(new File("flappy01_2.png"))
  val rectangle = new Rectangle(x+10, y+10, 130, 58)

  def moveLeft(): Unit = {
    if(x>0) x-=5
    rectangle.setBounds(x+10, y+10, 130, 58)
    direction = true
  }

  def moveRight(): Unit = {
    if(x<850) x+=5
    rectangle.setBounds(x+10, y+10, 130, 58)
    direction = false
  }

  def paint(g: Graphics2D, c: Canvas): Unit = {
    if (!dead) {
      if (!direction) g.drawImage(iRight, null, x, y)
      if (direction) g.drawImage(iLeft, null, x, y)
    }
    if(dead) {
      if (!direction) g.drawImage(iDeadRight, null, x, y)
      if (direction) g.drawImage(iDeadLeft, null, x, y)
    }
  }

}
