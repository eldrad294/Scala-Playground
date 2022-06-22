package com.demo.HelloWorld
package VehicleRental.Templates

import java.time.LocalDate
import VehicleRental.Enums.FuelType

abstract class Vehicle(
  val name: String,
  val company: String,
  val mileage: Int,
  val wheels: Int,
  val fuel: FuelType.FuelType,
  val doorCount: Int,
  val passengerOccupancy: Int,
  val yearOfMake: LocalDate,
  val numberPlate: String,
  val id: Int = 1){

  def verifyNumberPlate:Boolean = {
    if (numberPlate.length != 7)
      return false

    val prefix = numberPlate.split('-')(0)
    val postfix = numberPlate.split('-')(1)
    if (prefix.forall(x => Character.isDigit(x)))
      return false
    if (postfix.forall(x => !Character.isDigit(x)))
      return false

    true
  }
}
