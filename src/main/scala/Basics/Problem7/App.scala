package com.demo.HelloWorld
package Basics.Problem7

import scala.io.StdIn.readLine

object App {

  def main(args:Array[String]):Unit = {
    print("Enter firstname:")
    val firstName = readLine()
    print("Enter lastname:")
    val lastName = readLine()
    print("Enter favourite movie:")
    val movie = readLine()

    print(f"$firstName $lastName's favourite movie is $movie")
  }

}
