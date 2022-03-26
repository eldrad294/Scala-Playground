package com.demo.HelloWorld
package Basics.Problem12

object App {

  def main(args:Array[String]):Unit = {
    val couponCodes = Array[String](
      "A",
          "BB",
          "CCC",
          "DDDD",
          "EEEEE")
    couponCodes.foreach(line => println(f"$line - " + line.length))
  }

}