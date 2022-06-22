package com.demo.HelloWorld
package VehicleRental.Enums

import slick.ast.BaseTypedType
import slick.jdbc.H2Profile.MappedColumnType
import slick.jdbc.JdbcType
import slick.jdbc.H2Profile.api.stringColumnType

object FuelType extends Enumeration {

  type FuelType = Value
  val Petrol, Diesel, Electrical = Value

  trait JdbcFuelImplicit {
    implicit val fuelType: JdbcType[FuelType.FuelType] with BaseTypedType[FuelType.FuelType] = MappedColumnType.base[FuelType.FuelType, String](
      e => e.toString,
      s => FuelType.withName(s)
    )
  }
}
