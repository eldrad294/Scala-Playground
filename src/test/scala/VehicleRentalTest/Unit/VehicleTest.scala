package com.demo.HelloWorld
package VehicleRentalTest.Unit

import org.scalatest.flatspec.AnyFlatSpec
import VehicleRental.Enums.FuelType
import VehicleRental.Bike.dto.Bike
import VehicleRental.Car.dto.Car
import java.time.LocalDate


class VehicleTest extends AnyFlatSpec{

  "A car number plate" must "be provided in the following format LLL-NNN"

  it should "succeed when a valid number plate is given" in {
    val car = Car("Demio",
      "Mazda",
        41000,
        4,
        FuelType.Petrol,
        4,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393")
    assert(car.verifyNumberPlate)
  }

  it should "fail when a number plate with 2 digits is given" in {
    val car = Car("Demio",
      "Mazda",
      41000,
      4,
      FuelType.Petrol,
      4,
      5,
      LocalDate.of(2012, 1, 1),
      "ACR-39")
    assert(!car.verifyNumberPlate)
  }

  it should "fail when a number plate with 4 digits is given" in {
    val car = Car("Demio",
      "Mazda",
      41000,
      4,
      FuelType.Petrol,
      4,
      5,
      LocalDate.of(2012, 1, 1),
      "ACR-3933")
    assert(!car.verifyNumberPlate)
  }

  it should "fail when a number plate with 2 characters is given" in {
    val car = Car("Demio",
      "Mazda",
      41000,
      4,
      FuelType.Petrol,
      4,
      5,
      LocalDate.of(2012, 1, 1),
      "AC-393")
    assert(!car.verifyNumberPlate)
  }

  it should "fail when a number plate with 4 characters is given" in {
    val car = Car("Demio",
      "Mazda",
      41000,
      4,
      FuelType.Petrol,
      4,
      5,
      LocalDate.of(2012, 1, 1),
      "ACRR-393")
    assert(!car.verifyNumberPlate)
  }

  it should "fail when a number plate with no '-' is provided" in {
    val car = Car("Demio",
      "Mazda",
      41000,
      4,
      FuelType.Petrol,
      4,
      5,
      LocalDate.of(2012, 1, 1),
      "ACR393")
    assert(!car.verifyNumberPlate)
  }

  "A bike number plate" must "be provided in the following format LLL-NNN"

  it should "succeed when a valid number plate is given" in {
    val bike = Bike("Demio",
      "Mazda",
      41000,
      4,
      FuelType.Petrol,
      4,
      5,
      LocalDate.of(2012, 1, 1),
      "ACR-393")
    assert(bike.verifyNumberPlate)
  }

  it should "fail when a number plate with 2 digits is given" in {
    val bike = Bike("Demio",
      "Mazda",
      41000,
      4,
      FuelType.Petrol,
      4,
      5,
      LocalDate.of(2012, 1, 1),
      "ACR-39")
    assert(!bike.verifyNumberPlate)
  }

  it should "fail when a number plate with 4 digits is given" in {
    val bike = Bike("Demio",
      "Mazda",
      41000,
      4,
      FuelType.Petrol,
      4,
      5,
      LocalDate.of(2012, 1, 1),
      "ACR-3933")
    assert(!bike.verifyNumberPlate)
  }

  it should "fail when a number plate with 2 characters is given" in {
    val bike = Bike("Demio",
      "Mazda",
      41000,
      4,
      FuelType.Petrol,
      4,
      5,
      LocalDate.of(2012, 1, 1),
      "AC-393")
    assert(!bike.verifyNumberPlate)
  }

  it should "fail when a number plate with 4 characters is given" in {
    val bike = Bike("Demio",
      "Mazda",
      41000,
      4,
      FuelType.Petrol,
      4,
      5,
      LocalDate.of(2012, 1, 1),
      "ACRR-393")
    assert(!bike.verifyNumberPlate)
  }

  it should "fail when a number plate with no '-' is provided" in {
    val bike = Bike("Demio",
      "Mazda",
      41000,
      4,
      FuelType.Petrol,
      4,
      5,
      LocalDate.of(2012, 1, 1),
      "ACR393")
    assert(!bike.verifyNumberPlate)
  }
}