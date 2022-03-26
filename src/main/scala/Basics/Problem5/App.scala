package com.demo.HelloWorld
package Basics.Problem5

object App {

  def main(args:Array[String]):Unit = {
    val donutCost = 2.50F
    val donutQuantity = args(0).toFloat
    val total = donutCost * donutQuantity
    print(f"Total $$$total%2.2f")
  }

}
