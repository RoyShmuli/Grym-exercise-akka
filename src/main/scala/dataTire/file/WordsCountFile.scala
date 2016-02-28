package dataTire.file

import java.io.BufferedWriter

import scala.collection.immutable.ListMap

/**
  * Created by Owner on 28/02/2016.
  */
object WordsCountFile {
  def storeWordsCount(data:ListMap[String, Integer])(bw:BufferedWriter) = {
    for (element <- data) {
      bw.write(s"${element._1} ${element._2}\n")
    }
  }
}
