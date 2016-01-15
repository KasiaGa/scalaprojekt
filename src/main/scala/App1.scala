/**
 * Created by Kasia on 2016-01-11.
 */
import scala.swing._

object App1 {
  def main(args: Array[String]) {
    val ui = new GameUI
    while(true){
      ui.logic()
      ui.canvas.repaint()

    }
  }


}