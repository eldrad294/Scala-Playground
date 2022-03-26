package com.demo.HelloWorld
package Basics.Problem13

object App {

  def main(args:Array[String]):Unit = {
    val shoppingBasket = Array(
      Tuple3("T-Shirt","Medium",10.99),
      Tuple3("Polo-Shirt","Large",4.99),
      Tuple3("Vest","Small",5.99),
      Tuple3("T-Shirt","Small",4.99),
      Tuple3("T-Shirt","Small",4.99)
    )

    shoppingBasket
      .foreach(element => if(element._1.equals("T-Shirt")) println(f"${element._1.toUpperCase()}, ${element._2}, ${element._3}") else println(f"${element._1.toLowerCase()}, ${element._2}, ${element._3}"))
  }

}
