package com.demo.HelloWorld
package Class_Functions_Traits.Problem12

object App {

  case class Car(name:String, price:Double)
  object CarExtension{
    implicit class CarUUID(car:Car){
      def uuid:Int = car.hashCode()
    }
  }

  def main(args:Array[String]):Unit = {
    val carInventory = List(
      Car("BMW 3 series", 20000),
      Car("BMW 5 series", 50000),
      Car("VW PASSAT", 10000),
      Car("VW GOLF", 12000),
      Car("MAZDA 3", 15000)
    )
    import CarExtension._
    carInventory.foreach(x => println(f"car uuid = ${x.name} - ${x.uuid}"))
  }

}
