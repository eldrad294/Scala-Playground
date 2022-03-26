package com.demo.HelloWorld
package Basics.Problem14

object App {

  def main(args:Array[String]):Unit = {
    val items1 = List("pencil", "pen", "sharpener")
    val items2 = List("math book", "french book", "english book")
    val combinedItems = List(items1, items2)
    combinedItems.flatten.foreach(item => println(item + " is required in the classroom"))
  }

}
