package com.demo.HelloWorld
package Numbers.Problem6

object App {

  def magicNumberEvaluator(magicNumber:Int, numbersSeq:Seq[Int]):Boolean = if (numbersSeq.contains(magicNumber)) true else false

  def main(args:Array[String]):Unit = {
    val numbers = Seq(10, 77, 90, 50, 100, 110)
    val magicNumber = 77
    print(f"Does magic number $magicNumber exist within the numerical value of ${numbers.mkString(",")}? ${magicNumberEvaluator(magicNumber, numbers)}")
  }

}
