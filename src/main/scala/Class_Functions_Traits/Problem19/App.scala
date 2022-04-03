package com.demo.HelloWorld
package Class_Functions_Traits.Problem19

object App {

  abstract class Vehicle(name:String)
  final case class Car(name:String) extends Vehicle(name:String)
  final case class Bike(name:String) extends Vehicle(name:String)
  trait VehicleInventory[V]{
    def create(v:V): Unit
    def read(v:V): Unit
    def update(v:V): Unit
    def delete(v:V): Unit
  }
  class VehicleInventorySystem extends VehicleInventory[Vehicle] {
    override def create(v: Vehicle): Unit = println(f"Created ${v}")

    override def read(v: Vehicle): Unit = println(f"Read ${v}")

    override def update(v: Vehicle): Unit = println(f"Updated ${v}")

    override def delete(v: Vehicle): Unit = println(f"Deleted ${v}")
  }
  def main(args:Array[String]):Unit = {
    val car1 = Car("bmw car 5 series")
    val car2 = Car("mazda car 3 series")
    val bike1 = Bike("honda bike firestorm")
    val bike2 = Bike("bmw bike r 2000")
    val vis = new VehicleInventorySystem
    vis.create(car1)
    vis.read(car2)
    vis.update(bike1)
    vis.delete(bike2)
  }

}
