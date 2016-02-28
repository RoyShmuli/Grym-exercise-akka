package utils

import scala.collection.mutable

/**
  * Created by Owner on 28/02/2016.
  */
object MapUtils {
  def countMap[T](map:mutable.Map[T, Integer], key:T) = {
    val currKeyCounter:Option[Integer] = map.get(key)

    if (currKeyCounter.isDefined) {
      map.put(key, currKeyCounter.get + 1)
    } else {
      map.put(key, 1)
    }
  }
}
