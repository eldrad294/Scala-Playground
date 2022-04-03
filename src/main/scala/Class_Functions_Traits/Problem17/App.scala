package com.demo.HelloWorld
package Class_Functions_Traits.Problem17

object App {

  final case class CartItem(name:String, quantity:Int, price:Double)
  final object ShoppingCart{
    def totalCost(cartItem:CartItem, couponCode:Option[String]):Double = {
      couponCode.getOrElse("") match{
        case "COUPON_1234" => (cartItem.quantity * cartItem.price) - (cartItem.quantity * cartItem.price)*0.1
        case _ => cartItem.quantity * cartItem.price
      }
    }
  }
  def main(args:Array[String]):Unit = {
    val chocolateItem = CartItem("Chocolate", 10, 2.5)
    val costWithoutDiscount = ShoppingCart.totalCost(chocolateItem, None)
    println(costWithoutDiscount)
    val costWithDiscount = ShoppingCart.totalCost(chocolateItem, Option("COUPON_1234"))
    println(costWithDiscount)
  }

}
