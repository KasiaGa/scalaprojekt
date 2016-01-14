
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
  val i = ImageIO.read(new File("evader.jpg"))

  def moveLeft(): Unit = {
    if(x>0) x-=1
  }

  def moveRight(): Unit = {
    if(x<1000) x+=1
  }

  def paint(g: Graphics2D, c: Canvas): Unit = {
    g.drawImage(i, null, x, y)
  }

}
