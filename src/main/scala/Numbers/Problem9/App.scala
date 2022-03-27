package com.demo.HelloWorld
package Numbers.Problem9

object App {

  def main(args:Array[String]):Unit = {
    val numericRange = 300 to 350
    val output = numericRange.filter(x => x % 2 != 0).mkString("||")
    print(output)
  }

}
