package com.demo.HelloWorld
package Hearthstone

import scala.collection.immutable.ListMap

class Utils {

  def loadFile(filePath:String):Array[Array[String]] = io.Source.fromFile(filePath).getLines().map(_.split(",").toArray).toArray

  def wordCounter(fileContent:Array[Array[String]], filterMather:String):Integer =
  {
    var counter = 0
    fileContent
        .foreach(
          line => line.foreach(word => if (word.trim().equalsIgnoreCase(filterMather)) counter += 1))
    counter
  }

  def wordStatistics(fileContent:Array[Array[String]]):List[(String, Integer)] = {
    var statisticsStore = Map[String, Integer]()
    for (line <- fileContent){
      for (word <- line){
        if (!word.isBlank)
          statisticsStore += word -> (statisticsStore.getOrElse(word, 0).asInstanceOf[Int]+1)
      }
    }
    statisticsStore.toList.sortBy(_._2).reverse
  }
}