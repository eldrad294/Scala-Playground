package com.demo.HelloWorld
package Numbers.Problem4

object App {

  def main(args:Array[String]):Unit = {
    val firstSet = Set(1, 3, 5, 10, 20)
    val secondSet = Set(20, 17, 18, 99, 0)

    println(f"Missing numbers from first ${firstSet.diff(secondSet)}")
    println(f"Missing numbers from second ${secondSet.diff(firstSet)}")
  }

}
