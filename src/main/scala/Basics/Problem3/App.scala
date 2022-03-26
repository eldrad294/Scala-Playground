package com.demo.HelloWorld
package Basics.Problem3

import scala.io.StdIn._

object App {

  def main(args:Array[String]):Unit = {

    print("Enter name:")
    val name = readLine()

    print("Enter age:")
    val age = readLine()

    println(Console.BOLD)
    print("Name: ")
    print(Console.RESET)
    print(Console.UNDERLINED)
    print(name)
    print(Console.RESET)
    println(Console.BOLD)
    print("Age: ")
    print(Console.RESET)
    print(age)

  }

}
