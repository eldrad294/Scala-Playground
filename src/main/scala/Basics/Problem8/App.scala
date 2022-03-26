package com.demo.HelloWorld
package Basics.Problem8

object App {

  def main(args:Array[String]):Unit = {
    val rawString = "Vanilla Donut 10 2.25"
    val productName = rawString.substring(0,13)
    val productQuantity = rawString.substring(14,16).toInt
    val productAmount = rawString.substring(17,21).toFloat
    println(productName)
    println(productQuantity)
    println(productAmount)
  }

}
