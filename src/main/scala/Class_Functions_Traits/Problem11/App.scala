package com.demo.HelloWorld
package Class_Functions_Traits.Problem11

import scala.language.implicitConversions

object App {

  case class Car(name:String, price:Double)
  class CarUUID(car:Car){
    def uuid:Integer = car.hashCode()
  }
  object CarExtension{
    implicit def uuid(car:Car):CarUUID = new CarUUID(car)
  }
  def main(args:Array[String]):Unit = {
    val carInventory = List(
      Car("BMW 3 series", 20000),
      Car("BMW 5 series", 50000),
      Car("VW PASSAT", 10000),
      Car("VW GOLF", 12000),
      Car("MAZDA 3", 15000)
    )
    import CarExtension.uuid
    carInventory.foreach(x => println(f"car uuid = ${x.name} - ${x.uuid}"))
  }

}
