package com.demo.HelloWorld
package Hearthstone

object Main {

  def main(args:Array[String]):Unit = {

    val fileContent = new Utils().loadFile("src/main/resources/hearthstone.csv")

    println("Sample Text")
    fileContent
      .map(
        x => x.map(
          y => if (y.isBlank) "EMPTY" else y
        ))
      .take(5)
      .foreach(
        x => println(
          x.mkString(" ")
        )
      )

    var counter = 0
    fileContent.foreach(x => counter += x.length)
    println("Total Cell Count [" + counter + "]")

  }
}