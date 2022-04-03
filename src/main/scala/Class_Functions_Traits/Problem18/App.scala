package com.demo.HelloWorld
package Class_Functions_Traits.Problem18

object App {

  final case class Vehicle(name:String)
  trait VehicleInventory{
    def create(vehicle:Vehicle):Unit
    def read(vehicle: Vehicle):Unit
    def update(vehicle: Vehicle):Unit
    def delete(vehicle: Vehicle):Unit
  }
  class VehicleInventorySystem extends VehicleInventory{
    override def create(vehicle: Vehicle): Unit = println(f"Created vehicle [$vehicle]")

    override def read(vehicle: Vehicle): Unit = println(f"Read vehicle [$vehicle]")

    override def update(vehicle: Vehicle): Unit = println(f"Updated vehicle [$vehicle]")

    override def delete(vehicle: Vehicle): Unit = println(f"Deleted vehicle [$vehicle]")
  }

  def main(args:Array[String]):Unit = {
    val vehicle = Vehicle("bmw car 5 series")
    val vehicleInventorySystem = new VehicleInventorySystem()
    vehicleInventorySystem.create(vehicle)
    vehicleInventorySystem.read(vehicle)
    vehicleInventorySystem.update(vehicle)
    vehicleInventorySystem.delete(vehicle)
  }

}
