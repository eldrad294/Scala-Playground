package com.demo.HelloWorld
package Class_Functions_Traits.Problem22
abstract class Vehicle(name:String)
class Bike(name:String) extends Vehicle(name:String)
class Car(name:String) extends Vehicle(name:String)
trait VehicleDatabaseService[V<:Vehicle]{
  def addOrUpdate(vehicle:V):Unit = println(f"addOrUpdate $vehicle")
  def get(vehicle:V):Unit = println(f"get $vehicle")
  def remove(vehicle:V):Unit = println(f"remove $vehicle")
}
trait VehicleInventory[V<:Vehicle]{
  def create(vehicle: V):Unit
  def read(vehicle: V):Unit
  def update(vehicle: V):Unit
  def delete(vehicle: V):Unit
}
class VehicleInventorySystem[V <: Vehicle] extends VehicleDatabaseService[V] with VehicleInventory[V]{
  override def create(vehicle: V): Unit = addOrUpdate(vehicle)

  override def read(vehicle: V): Unit = get(vehicle)

  override def update(vehicle: V): Unit = addOrUpdate(vehicle)

  override def delete(vehicle: V): Unit = remove(vehicle)
}
object App {


  def main(args:Array[String]):Unit = {
    val vehicleInventorSystem = new VehicleInventorySystem[Vehicle]()
    vehicleInventorSystem.create(new Car("bmw 3 series"))
    vehicleInventorSystem.read(new Car("mazda 3 series"))
    vehicleInventorSystem.read(new Bike("honda bike firestorm"))
    vehicleInventorSystem.read(new Bike("bmw bike r 2000"))
  }
}
