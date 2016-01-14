import scala.swing.{Graphics2D, Component}
import scala.swing.event.{KeyReleased, Key, KeyPressed}

/**
 * Created by Kasia on 2016-01-11.
 */
class Canvas extends Component{

  val evader = new Evader
  val thread = new Thread()
 // val droppers = new Set[]

  override def paintComponent(g : Graphics2D): Unit = {
    super.paintComponent(g)
    evader.paint(g, this)
  }

}
