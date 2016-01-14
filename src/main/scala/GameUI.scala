/**
 * Created by Kasia on 2016-01-11.
 */

import java.awt.Color

import scala.swing._
import scala.swing.event.{KeyReleased, Key, KeyPressed}

class GameUI extends MainFrame {

  val canvas = new Canvas
  val score = new Label("Score: 0")
  var counter = 0

  val evader = new Evader

  contents = new BorderPanel {
    preferredSize = new Dimension(1000, 700)
    resizable = false

    val buttons = new BoxPanel(Orientation.Horizontal) {
      contents += Button("New Game") { newGame() }
      contents += Swing.HGlue
      contents += score
      border = Swing.MatteBorder(5, 5, 5, 5, Color.gray)
    }

    focusable = true

    listenTo(keys)
    reactions += {
      case KeyPressed(_, Key.Right, _, _) =>
        {evader.moveRight()
        repaint()}
      case KeyPressed(_, Key.Left, _, _) =>
        {evader.moveLeft()
        repaint()}
    }

    add(canvas, BorderPanel.Position.Center)
    add(buttons, BorderPanel.Position.North)
  }

  private def setScore(): Unit = {
    counter+=1
    score.text = "Score: %d".format(counter)
  }
  setScore()
  def newGame() {
    if (Dialog.showConfirmation(canvas, "Do you want to start a new game",
      optionType=Dialog.Options.YesNo, title="new game") == Dialog.Result.Ok) {
      counter = 0
      score.text = "Score: %d".format(0)
      this.contents.head.requestFocus()
    }
  }

}
