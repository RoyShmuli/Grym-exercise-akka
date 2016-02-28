package enteties

/**
  * Created by Owner on 28/02/2016.
  */
case class FileData(fileFullPath:String, data:String)
case class WordsCount(fileFullPath:String, data:Map[String, Integer])