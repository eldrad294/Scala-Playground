package com.demo.HelloWorld
package Class_Functions_Traits.Problem21

object App {
  trait Vehicle{
    def printName():Unit
  }
  class Car(name:String) extends Vehicle {
    override def printName(): Unit = println(name)
  }
  class Bike(name:String) extends Vehicle{
    override def printName(): Unit = println(name)
  }
  final class BmwCar(name:String) extends Car(name:String){
    override def printName(): Unit = println(name)
  }
  final class MazdaCar(name:String) extends Car(name:String){
    override def printName(): Unit = println(name)
  }
  final class HondaBike(name:String) extends Bike(name:String){
    override def printName(): Unit = println(name)
  }
  final class BmwBike(name:String) extends Bike(name:String){
    override def printName(): Unit = println(name)
  }
  final class VehicleMaker[V<:Vehicle](vehicle:Option[V]=None){
    def make():Option[V] = {
      vehicle
    }
    def makeSimilarCars[A<:Vehicle, B<:Vehicle](v1:A, v2:B)(implicit ev: A =:= B):Unit = {
      v1.printName()
      v2.printName()
    }
    def makeBikes[A<:Vehicle, B<:Vehicle](v1:A, v2:B)(implicit ev: A <:< V):Unit = {
      v1.printName()
      v2.printName()
    }
  }
  def main(args:Array[String]):Unit = {
    val bmw5Car = new BmwCar("bmw car 5 series")
    val bmw3Car = new BmwCar("bmw car 3 series")
    val hondaBike = new HondaBike("honda bike firestorm")
    val bmwBike = new BmwBike("bmw bike r 2000")

    //new VehicleMaker[Vehicle]().makeSimilarCars(bmw5Car, hondaBike) //this will not compile
    new VehicleMaker[Vehicle]().makeSimilarCars(bmw3Car, bmw5Car)


    // new VehicleMaker[Vehicle]().makeBikes(hondaBike, mazdaCar) // this will not compile
    new VehicleMaker[Vehicle]().makeBikes(hondaBike, bmwBike)
  }

}
