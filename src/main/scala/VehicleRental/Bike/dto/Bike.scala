package com.demo.HelloWorld
package VehicleRental.Bike.dto

import java.time.LocalDate
import VehicleRental.Templates.Vehicle
import VehicleRental.Enums.FuelType.FuelType

case class Bike(
                 override val name: String,
                 override val company: String,
                 override val mileage: Int,
                 override val wheels: Int = 2,
                 override val fuel: FuelType,
                 override val doorCount: Int = 0,
                 override val passengerOccupancy: Int,
                 override val yearOfMake: LocalDate,
                 override val numberPlate: String,
                 override val id: Int = 1
               ) extends Vehicle(
  name,
  company,
  mileage,
  wheels,
  fuel,
  doorCount,
  passengerOccupancy,
  yearOfMake,
  numberPlate,
  id
)
