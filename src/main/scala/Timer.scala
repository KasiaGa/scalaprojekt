/**
  * Created by Kamil on 2016-01-14.
  */
class Timer( interval: Int, op: => Unit) {


    val timeOut = new javax.swing.AbstractAction() {
      def actionPerformed(e: java.awt.event.ActionEvent) = op
    }
    val t = new javax.swing.Timer(interval, timeOut)
    t.setRepeats(true)
    t.start()

}
