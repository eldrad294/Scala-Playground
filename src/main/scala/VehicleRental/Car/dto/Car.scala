package com.demo.HelloWorld
package VehicleRental.Car.dto

import java.time.LocalDate
import VehicleRental.Templates.Vehicle
import VehicleRental.Enums.FuelType.FuelType

case class Car(
                override val name: String,
                override val company: String,
                override val mileage: Int,
                override val wheels: Int = 4,
                override val fuel: FuelType,
                override val doorCount: Int,
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
