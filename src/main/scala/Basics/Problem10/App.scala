package com.demo.HelloWorld
package Basics.Problem10

object App {

  def main(args:Array[String]):Unit = {
    val basket1 = Array("Cake","Milk","Cheese","Toilet Paper")
    val basket2 = Array("Bread","Water","Juice","Milk","Cheese")
    var commonBasket = Array[String]()
    for (item <- basket1){
      if (basket2.contains(item))
        commonBasket = commonBasket:+item
    }
    commonBasket.foreach(println)
  }

}
