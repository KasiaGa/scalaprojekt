/**
 * Created by Kasia on 2016-01-11.
 */

import java.awt.Color


//import scala.swing.Component.mouse
import scala.swing._
import scala.swing.event.{MouseClicked, KeyReleased, Key, KeyPressed}

class GameUI extends MainFrame {

  val canvas = new Canvas
  val score = new Label("Score: 0")
  var counter = 0
  val evader = new Evader
  visible = true


  contents = new BorderPanel {
    preferredSize = new Dimension(1000, 700)
    resizable = false

    listenTo(mouse.clicks)
    reactions +={
      case e: MouseClicked =>{
       this.requestFocus()
      }
    }
    val buttons = new BoxPanel(Orientation.Horizontal) {
      contents += Button("New Game") { newGame() }
      contents += Swing.HGlue
      contents += score
      border = Swing.MatteBorder(5, 5, 5, 5, Color.gray)
    }

    add(canvas, BorderPanel.Position.Center)
    add(buttons, BorderPanel.Position.North)
  }

  private def setScore(): Unit = {
    counter+=1
    score.text = "Score: %d".format(counter)
  }

  def newGame() {
    if (Dialog.showConfirmation(canvas, "Do you want to start a new game?",
      optionType=Dialog.Options.YesNo, title="New Game") == Dialog.Result.Ok) {
      canvas.nullify()
      counter = 0
      score.text = "Score: %d".format(0)
      t.start()
      this.canvas.requestFocus()
    }
  }

  def rePaintMe(): Unit ={

  }

  val changeScore = new javax.swing.AbstractAction() {
    def actionPerformed(e: java.awt.event.ActionEvent) = {
      if(!canvas.gameOver) setScore()
    }
  }

  val t = new javax.swing.Timer(1000, changeScore )
  t.setRepeats(true)
  t.start()


}
