import scala.collection.mutable
import scala.swing._

/**
  * Created by Kamil on 2016-01-14.
  */
class dropControl {
  val droppers = new mutable.HashSet[Dropper]()
  var i =1
  var delay = 7000

  val adding = new javax.swing.AbstractAction() {
    def actionPerformed(e: java.awt.event.ActionEvent) = {
      addDropper()
    }
  }

  val moveDown = new javax.swing.AbstractAction() {
    def actionPerformed(e: java.awt.event.ActionEvent) = {
      for(d <- droppers) {
        d.moveDown()
      }
    }
  }

  val changeDelay = new javax.swing.AbstractAction() {
    def actionPerformed(e: java.awt.event.ActionEvent) = {
      if(delay>1000) delay -= 100
      t.setDelay(delay)
    }
  }

  val t = new javax.swing.Timer(delay, adding)
  t.setRepeats(true)
  t.start()

  val t2 = new javax.swing.Timer(50, moveDown)
  t2.setRepeats(true)
  t2.start()

  val t3 = new javax.swing.Timer(1000, changeDelay)
  t3.setRepeats(true)
  t3.start()

  def addDropper(): Unit ={
    droppers.add(new Dropper())
  }

  def paint(g: Graphics2D, c: Canvas): Unit = {
    for(d <- droppers) {
      d.paint(g, c)
    }
  }

  def stopTimers(): Unit = {
    t.stop()
    t2.stop()
    t3.stop()
  }

  def startTimers(): Unit = {
    t.start()
    t2.start()
    t3.start()
  }

  def clearDroppers(): Unit = {
    droppers.clear()
  }


}
