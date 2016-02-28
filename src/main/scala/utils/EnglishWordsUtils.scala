package utils

/**
  * Created by Owner on 28/02/2016.
  */
object EnglishWordsUtils {
  private val wordRegexPattern = "^[^a-zA-Z]*([a-zA-Z]+)[^a-zA-Z]*$".r

  def getWordLowerCase(data:String) :Option[String] = {
    val matched = wordRegexPattern.findFirstMatchIn(data)
    matched match {
      case Some(m) =>
       Some(m.group(1).toLowerCase())
      case None =>
        None
    }
  }
}
