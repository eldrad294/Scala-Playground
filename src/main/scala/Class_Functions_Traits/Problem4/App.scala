package com.demo.HelloWorld
package Class_Functions_Traits.Problem4

object App {

  final class BasketValidator{
    def validate(item:Any):Unit = {
      item.getClass.getName match {
        case "java.lang.String" => println(f"Found a valid item = [$item]")
        case "java.lang.Double" => println(f"Item [$item] of type Double is not valid")
        case "java.lang.Long" => println(f"Item [$item] should be removed from the basket.")
        case "java.lang.Integer" => println(f"Item [$item] of type Int is not valid")
      }
    }
  }

  def main(args:Array[String]):Unit = {
    val bv = new BasketValidator
    val items = List("Cupcake", 2.99, 100L, 7, "Ice Cream")
    items.foreach(bv.validate)
  }

}