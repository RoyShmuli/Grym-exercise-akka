package actors

import akka.actor.{Actor, Props}
import akka.event.Logging
import enteties.{FileData, WordsCount}
import utils.{EnglishWordsUtils, MapUtils}

import scala.collection.mutable

/**
  * Created by Owner on 28/02/2016.
  */
class CountWordsActor extends Actor {
  val log = Logging(context.system, this)
  val storeWordsCountsOrderedActor = context.actorOf(Props[StoreWordsCountsOrderedActor], name = "StoreWordsCountsOrderedActor")

  def receive = {
    case fileData:FileData =>
      log.info(s"Executing actor CountWordsActor")
      val wordCounter:mutable.Map[String, Integer] = mutable.Map()
      val words:Array[String] = fileData.data.split("\\s+")

      for (word <- words) {
        val filteredWordOpt:Option[String] = EnglishWordsUtils.getWordLowerCase(word)
        if (filteredWordOpt.isDefined) {
          MapUtils.countMap(wordCounter, filteredWordOpt.get)
        }
      }

      storeWordsCountsOrderedActor ! WordsCount(fileData.fileFullPath, wordCounter.toMap)
    case any =>
      log.error(s"Handle not found for the actor: CountWordsActor, data: $any")
  }
}
