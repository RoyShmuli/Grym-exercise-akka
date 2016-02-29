package actors

import akka.actor.Actor
import akka.event.Logging
import dataTire.file.WordsCountFile
import enteties.WordsCount
import utils.FileUtiles

import scala.collection.immutable.ListMap

/**
  * Created by Owner on 28/02/2016.
  */
class StoreWordsCountsOrderedActor extends Actor {
  val log = Logging(context.system, this)

  def receive = {
    case countWords:WordsCount =>
      log.info(s"Executing actor StoreWordsCountsOrderedActor")
      val countWordsOrdered:ListMap[String, Integer] = ListMap(countWords.data.toList.sortBy{-_._2}:_*)
      FileUtiles.writeToFile(s"${countWords.fileFullPath}.wordsCounter", WordsCountFile.storeWordsCount(countWordsOrdered))

    case any =>
      log.error(s"Handle not found for the actor: StoreWordsCountsOrderedActor, data: $any")
  }
}
