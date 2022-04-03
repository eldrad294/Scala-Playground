package com.demo.HelloWorld
package Class_Functions_Traits.Problem16

import Class_Functions_Traits.Problem15._

object App {

  final case class Lollipop(name:String)
  class ShoppingCart(){
    def addCartItem[T>:Donut](item:T):Unit ={
      println(item.getClass.getSimpleName)
    }
  }
  def main(args:Array[String]):Unit = {
    val lollipop = Lollipop("Chuppa Chups")

    // Compile time error because a Lollipop type does not match the P <: Donut constraint
    // val lollipopPastry = new Pastry[Lollipop](lollipop)

    val shoppingCart = new ShoppingCart()
    shoppingCart.addCartItem(new VanillaDonut("Vanilla"))
    shoppingCart.addCartItem(new GlazedDonut("Glazed"))
    shoppingCart.addCartItem(lollipop)
    shoppingCart.addCartItem("Test")
  }

}
