package grymco.com

import _root_.actors.ReadFromFileActor
import akka.actor.{ActorRef, ActorSystem, Props}

object WordsCounterApp extends App {
  val system = ActorSystem("WordsCounter")

  val textFileFullPath:String = System.getProperty("textFileFullPath")
  if (textFileFullPath == null) {
    system.log.error("Missing the parameter 'textFileFullPath'")
    stopApp()
  }

  val readFromFileActor = system.actorOf(Props[ReadFromFileActor], "ReadFromFileActor")

  readFromFileActor.tell(textFileFullPath, ActorRef.noSender)

  stopApp()

  def stopApp() = {
    system.terminate()
  }
}
