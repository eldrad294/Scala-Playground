package com.demo.HelloWorld
package Inheritence

object App {

  def main(args:Array[String]):Unit = {
    val carBuilder = new CarBuilder()
    val truckBuilder = new TruckBuilder()

    val honda = carBuilder.setName("Honda").setWeight(900.3).setOccupancy(5).setTopSpeedKmH(99).setBreakCoefficient(0.5F).setEngineHorsePower(13).setTyreCount(4).build()
    val readyMix = truckBuilder.setName("Concrete Truck").setWeight(2500.58).setOccupancy(3).setTopSpeedKmH(60).setBreakCoefficient(0.1F).setEngineHorsePower(56).setTyreCount(10).build()

    val vehicleList = List(honda, readyMix)

    for(vehicle <- vehicleList)
      println(vehicle.describe())
  }

}
