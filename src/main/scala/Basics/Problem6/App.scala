package com.demo.HelloWorld
package Basics.Problem6

import scala.io.StdIn.readLine

object App {

  def main(args:Array[String]):Unit = {
    print("Enter your favourite movie:")
    val movie = readLine()
    print(f"$movie is totally awesome!")
  }

}
