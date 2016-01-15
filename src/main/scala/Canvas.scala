import scala.swing.{Graphics2D, Component}
import scala.swing.event.{MouseClicked, KeyReleased, Key, KeyPressed}

/**
 * Created by Kasia on 2016-01-11.
 */
class Canvas extends Component{

  val evader = new Evader
  val thread = new Thread()
 // val droppers = new Set[]
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
    {evader.moveRight()
      repaint()}
    case KeyPressed(_, Key.Left, _, _) =>
    {evader.moveLeft()
      repaint()}
  }
  override def paintComponent(g : Graphics2D): Unit = {
    super.paintComponent(g)
    evader.paint(g, this)
  }

}
