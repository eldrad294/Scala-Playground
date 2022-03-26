package com.demo.HelloWorld
package Basics.Problem9

object App {

  def main(args:Array[String]):Unit = {
    val childrenAges = Map(
      "Bill" -> 9,
      "Jonny" -> 8,
      "Tommy" -> 11,
      "Cindy" -> 13
    )
    childrenAges.toSeq.sortBy(_._1).reverse.foreach(println)
  }

}
