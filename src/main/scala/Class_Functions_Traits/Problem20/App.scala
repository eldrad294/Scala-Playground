package com.demo.HelloWorld
package Class_Functions_Traits.Problem20

object App {

  trait Vehicle{
    def printName():Unit
  }
  class Car(name:String) extends Vehicle {
    override def printName(): Unit = println(name)
  }
  final class BmwCar(name:String) extends Car(name:String){
    override def printName(): Unit = println(name)
  }
  final class MazdaCar(name:String) extends Car(name:String){
    override def printName(): Unit = println(name)
  }
  class Bike(name:String) extends Vehicle{
    override def printName(): Unit = println(name)
  }
  final class HondaBike(name:String) extends Bike(name:String){
    override def printName(): Unit = println(name)
  }
  final class BmwBike(name:String) extends Bike(name:String){
    override def printName(): Unit = println(name)
  }
  final class VehicleMaker[V<:Vehicle](vehicle:V){
    def make():V = {
      vehicle.printName()
      vehicle
    }
  }
  def main(args:Array[String]):Unit = {
    val carList = List(
      new BmwCar("bmw car 5 series"),
      new MazdaCar("mazda car 3 series")
    )
    val bikeList = List(
      new BmwCar("honda bike firestorm"),
      new MazdaCar("bmw bike r 2000")
    )
    val vehicleList = carList ++ bikeList
    vehicleList.map(x => new VehicleMaker(x).make())
  }

}
