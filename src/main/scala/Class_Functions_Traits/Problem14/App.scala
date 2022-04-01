package com.demo.HelloWorld
package Class_Functions_Traits.Problem14

object App {
  abstract class Vehicle(val make:String)
  case class Car(override val make:String) extends Vehicle(make:String)
  case class Bike(override val make:String) extends Vehicle(make:String)
  object VehicleReport{
    def printVehicles(vehiclesList:List[Vehicle]): Unit ={
      vehiclesList.foreach(x => println(x.make))
    }
  }
  def main(args:Array[String]):Unit = {
    val vehiclesList:List[Vehicle] = List(
      Car("bmw 3 series"),
      Car("vw golf"),
      Bike("bmw g 310 r bike"),
      Bike("fire storm bike")
    )
    VehicleReport.printVehicles(vehiclesList=vehiclesList)
  }

}
