package com.demo.HelloWorld
package Class_Functions_Traits.Problem24

import Class_Functions_Traits.Problem22.Vehicle
import Class_Functions_Traits.Problem22.Car
import Class_Functions_Traits.Problem22.Bike


object App {

  class VehicleInventorService[V<:Vehicle]{
    def checkStock(vehicle:V):Unit = println(s"Check Stock of $vehicle")
  }
  class VehiclePricingService[V<:Vehicle]{
    def checkPrice(vehicle:V):Unit  = println(s"Check Price of $vehicle")
  }
  trait VehicleServices[V<:Vehicle]{
    lazy val vis = new VehicleInventorService[V]
    lazy val vps = new VehiclePricingService[V]
  }
  trait VehicleSystem[V<:Vehicle]{
    this: VehicleServices[V] =>
      def buyVehicle(vehicle:V):Unit = {
        println(s"buying vehicle $vehicle")
        vis.checkStock(vehicle)
        vps.checkPrice(vehicle)
      }
  }
  object VehicleApp extends VehicleSystem[Vehicle] with VehicleServices[Vehicle]

  def main(args:Array[String]):Unit = {
    VehicleApp.buyVehicle(new Car("mazda 3 series"))
    VehicleApp.buyVehicle(new Bike("honda bike firestorm"))
  }

}
