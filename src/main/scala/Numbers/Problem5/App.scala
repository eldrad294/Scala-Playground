package com.demo.HelloWorld
package Numbers.Problem5

object App {

  def main(args:Array[String]):Unit = {
    val firstArray = Array(99.5,100.0,50.0,55.0,70.0,100.0,-1.0)
    val secondArray = Array(10.0, 20.0, 30.0, 40.0, 50.0)
    val combinedArray = firstArray++secondArray
    println(f"Lowest: ${combinedArray.min} Highest: ${combinedArray.max}")
  }

}
