package actors

import akka.actor.{Actor, Props}
import akka.event.Logging
import enteties.FileData
import utils.FileUtiles

/**
  * Created by Owner on 28/02/2016.
  */
class ReadFromFileActor extends Actor {
  val log = Logging(context.system, this)
  val countWordsActor = context.actorOf(Props[CountWordsActor], name = "CountWordsActor")

  def receive = {
    case fileFullPath:String =>
      log.info(s"Executing actor ReadFromFileActor")
      countWordsActor ! FileData(fileFullPath, FileUtiles.readFile(fileFullPath))
    case any =>
      log.error(s"Handle not found for the actor: ReadFromFileActor, data: $any")
  }
}