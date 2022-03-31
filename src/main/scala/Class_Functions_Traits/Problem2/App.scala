package com.demo.HelloWorld
package Class_Functions_Traits.Problem2

object App {

  final case class ShoppingCartItem(name:String, price:Double, quantity:Integer){
    override def toString: String = f"$quantity $name at $$$price each"
  }

  def itemPrinter(itemArray:Array[ShoppingCartItem]):Unit = itemArray.foreach(x => println(x.toString))

  def iceCreamPrinter(itemArray:Array[ShoppingCartItem]):Unit = itemArray
    .foreach(x =>
      if(x.name.toLowerCase.contains("ice cream") || x.name.toLowerCase.contains("icecream")) println(x.toString)
      else println("Found another item")
    )

  def main(args:Array[String]):Unit = {
    val item1 = ShoppingCartItem("Vanilla Ice Cream", 2.99, 10)
    val item2 = ShoppingCartItem("Chocolate Biscuits", 3.99, 3)
    val item3 = ShoppingCartItem("Cupcakes", 4.99, 5)
    val itemArray = Array(item1, item2, item3)
    itemPrinter(itemArray)
    iceCreamPrinter(itemArray)
  }

}
