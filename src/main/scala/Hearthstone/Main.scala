package com.demo.HelloWorld
package Hearthstone

object Main {

  def main(args:Array[String]):Unit = {

    val utils = new Utils()
    val fileContent = utils.loadFile("src/main/resources/hearthstone.csv")

    println("Sample Text")
    fileContent
      .map(
        x => x.map(
          y => if (y.isBlank) "EMPTY" else y
        ))
      .take(5)
      .foreach(
        x => println(
          x.mkString(",")
        )
      )

    var counter = 0
    fileContent.foreach(x => counter += x.length)
    println("Total Cell Count [" + counter + "]")

    var filterCounter = 0
    val filterMather = "shaman"
    for (line <- fileContent){
      for (word <- line){
        if (word.trim().toLowerCase().contains(filterMather)){
          filterCounter += 1
        }
      }
    }
    println("Number of [" + filterMather + "] occurrences [" + filterCounter + "]")
    println("Shorthand number of [" + filterMather + "] occurrences [" + filterCounter + "]")

    val x = utils.wordStatistics(fileContent)
    val topN = 5
    println("Top " + topN + " words [" + x.take(topN) + "]")

  }
}