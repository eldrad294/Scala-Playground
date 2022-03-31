package com.demo.HelloWorld
package Class_Functions_Traits.Problem1


object App {
  final case class ShoppingCartTuple(tuple3: (String, Double, Int)){
    override def toString:String = f"A packet of ${tuple3._1} is currently priced at $$${tuple3._2}, and the customer bought ${tuple3._3}."
  }
  final case class ShoppingCart(name:String, price:Double, quantity:Int){
    override def toString:String = f"A packet of ${name} is currently priced at $$${price}, and the customer bought ${quantity}."
  }

  def main(args:Array[String]):Unit = {
    val shoppingCartTupleItem: ShoppingCartTuple = ShoppingCartTuple("Rice", 10.99, 5)
    println(shoppingCartTupleItem.toString)
    val shoppingCart = ShoppingCart("Rice", 10.99, 5)
    print(shoppingCart.toString)
  }
}
