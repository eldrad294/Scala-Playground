package com.demo.HelloWorld
package Basics.Problem2

object App {

  def main(args:Array[String]):Unit = {
    val donutName = args(0)
    val quantityPurchased = args(1)
    val price = args(2)

    val json =
      s"""
      {
      "donut_name":"$donutName",
      "quantity_purchased":"$quantityPurchased",
      "price":$price
      }
      """.stripMargin

    print(json)
  }

}
