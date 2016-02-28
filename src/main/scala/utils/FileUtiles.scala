package utils

import java.io.{BufferedWriter, File, FileWriter}

import scala.io.Source

/**
  * Created by Owner on 28/02/2016.
  */
object FileUtiles {

  def readFile(fullPath:String) :String = {
    Source.fromFile(fullPath).getLines()
    val source = scala.io.Source.fromFile(fullPath)

    try {
      source.mkString
    }finally {
      source.close()
    }
  }

  def writeToFile(fullPath:String, writeFunc:BufferedWriter => Unit) = {
    val file = new File(fullPath)

    val bw = new BufferedWriter(new FileWriter(file))
    writeFunc(bw)
    bw.close()
  }
}
