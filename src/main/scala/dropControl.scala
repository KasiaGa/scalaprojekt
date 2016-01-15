import scala.collection.mutable

/**
  * Created by Kamil on 2016-01-14.
  */
class dropControl {
  val droppers = new mutable.HashSet[Dropper]()

  val adding = new javax.swing.AbstractAction() {
    def actionPerformed(e: java.awt.event.ActionEvent) = {
      addDropper()

    }
  }
  val t = new javax.swing.Timer(7000, adding )
  t.setRepeats(true)
  t.start()




  def addDropper(): Unit ={
    droppers.add(new Dropper())
  }




}
