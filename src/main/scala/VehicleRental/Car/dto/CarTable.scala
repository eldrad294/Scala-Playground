package com.demo.HelloWorld
package VehicleRental.Car.dto

import VehicleRental.Enums.FuelType.{FuelType, JdbcFuelImplicit}

import slick.jdbc.H2Profile.api._
import slick.lifted.ProvenShape

import java.time.LocalDate

class CarTable (tag:Tag) extends Table[Car](tag,None,"CAR")
  with JdbcFuelImplicit{

  val id : Rep[Int] = column[Int]("ID",O.PrimaryKey, O.AutoInc)
  val name : Rep[String] = column[String]("NAME")
  val company : Rep[String] = column[String]("COMPANY")
  val mileage : Rep[Int] = column[Int]("MILEAGE")
  val wheels : Rep[Int] = column[Int]("WHEELS")
  val fuel : Rep[FuelType] = column[FuelType]("FUEL")
  val doorCount : Rep[Int] = column[Int]("DOOR_COUNT")
  val passengerOccupancy : Rep[Int] = column[Int]("PASSENGER_OCCUPANCY")
  val yearOfMake : Rep[LocalDate] = column[LocalDate]("YEAR_OF_MAKE")
  val numberPlate : Rep[String] = column[String]("NUMBER_PLATE",O.Unique)

  override def * : ProvenShape[Car] = (name,
    company,
    mileage,
    wheels,
    fuel,
    doorCount,
    passengerOccupancy,
    yearOfMake,
    numberPlate,
    id) <> (Car.tupled, Car.unapply)
}