package com.demo.HelloWorld
package Class_Functions_Traits.Problem23

import Class_Functions_Traits.Problem22._

object App {

  trait VehicleSystem[vehicle <: Vehicle]{
    val vehicleInventorySystem:VehicleInventorySystem[vehicle]
    def checkVehicleStock(vehicle: vehicle): Unit = {
      println(s"Checking vehicle stock for vehicle = $vehicle")
      vehicleInventorySystem.read(vehicle)
    }
  }

  def main(args:Array[String]):Unit = {
    val vehicleSystem = new VehicleSystem[Vehicle] {
      override val vehicleInventorySystem: VehicleInventorySystem[Vehicle] = new VehicleInventorySystem[Vehicle]
    }

    vehicleSystem.checkVehicleStock(new Car("mazda 3 series"))
    vehicleSystem.checkVehicleStock(new Bike("honda bike firestorm"))
  }

}
