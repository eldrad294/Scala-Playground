package com.demo.HelloWorld
package Numbers.Problem7

object App {

  def calcModulus(number:Int):Boolean = if (number % 2 == 0) true else false

  def main(args:Array[String]):Unit = {

    val numberArray = Array(2, 8, 19, 20, 25, 50, 100, 10)
    numberArray.dropWhile(x => calcModulus(x)).foreach(println)
  }

}
