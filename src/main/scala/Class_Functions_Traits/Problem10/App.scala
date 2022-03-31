package com.demo.HelloWorld
package Class_Functions_Traits.Problem10

object App {

  case class Car(name:String, price:Double)
  def main(args:Array[String]):Unit = {
    val stockInventory1 = Tuple2(Car("VW passat", 10000), 100)
    val stockInventory2 = Tuple2(Car("VW golf", 12000), 50)
    val stockInventory3 = Tuple2(Car("bmw 3 series", 20000), 200)
    val stockInventory4 = Tuple2(Car("bmw 5 series", 50000), 75)
    val stockInventory5 = Tuple2(Car("mazda 3 series", 15000), 49)
    val stockInventory = List(stockInventory1, stockInventory2, stockInventory3, stockInventory4, stockInventory5)
    def orderByLowestStock(stockInventory:List[(Car, Int)]):Unit = stockInventory.sortBy(_._2).foreach(x => println(f"A ${x._1.name} with price of ${x._1.price} and stock of ${x._2}"))
    orderByLowestStock(stockInventory)
  }

}
