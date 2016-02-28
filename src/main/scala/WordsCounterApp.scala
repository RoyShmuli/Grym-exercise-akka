import actors.ReadFromFileActor
import akka.actor.{ActorRef, ActorSystem, Props}

object WordsCounterApp extends App {

  val system = ActorSystem("WordsCounter")

  val readFromFileActor = system.actorOf(Props[ReadFromFileActor], "ReadFromFileActor")

  readFromFileActor.tell("E:\\Program Files (x86)\\Roy\\Projects\\Grymco\\data.txt", ActorRef.noSender)
}
