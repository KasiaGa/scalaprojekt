import java.io.File
import javax.imageio.ImageIO

import scala.swing._
import scala.util.Random

/**
 * Created by Kasia on 2016-01-13.
 */
class Dropper {

  val r = Random
  var y = 0
  val x = r.nextInt(951)
  val i = ImageIO.read(new File("dropper.png"))
  val rectangle = new Rectangle(x, y+60, 60, 60)

  def moveDown(): Unit = {
    if(y<=700) y += 5
    rectangle.setBounds(x, y+60, 60, 60)
  }

  def paint(g: Graphics2D, c: Canvas): Unit = {
    g.drawImage(i, null, x, y)
  }

}
