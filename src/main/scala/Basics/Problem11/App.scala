package com.demo.HelloWorld
package Basics.Problem11


object App {

  def main(args:Array[String]):Unit = {
    case class Item(name:String, category:String)
    val shoppingBasket = Array[Item](
      Item("Milk","NonFruit"),
      Item("Cheese","NonFruit"),
      Item("Donuts","NonFruit"),
      Item("Apples","Fruit"),
      Item("Bananas","Fruit")
    )
    val fruitItems = shoppingBasket
      .filterNot(item => item.category.equals("Fruit"))
      .map(item => item.name)
      .mkString("|")
    print(f"<items values=\"$fruitItems\"></items>")
  }

}
