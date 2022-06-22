package com.demo.HelloWorld
package VehicleRental.Car

import slick.jdbc.H2Profile.api._

import scala.concurrent.Future
import VehicleRental.Templates.VehicleDAO
import VehicleRental.Car.dto.{Car,CarTable}

class CarDAO(override val db:Database) extends VehicleDAO[Car](db) {

  val carTable = TableQuery[CarTable]

  override def insert(car: Car):Future[Int] = {
    val carTableDML = carTable += car
    db.run(carTableDML)
  }

  override def updateByNumberPlate(car: Car, numberPlate: String):Future[Int] = {
    val carTableDML = carTable.filter(_.numberPlate === numberPlate).map(car => car).update(car)
    db.run(carTableDML)
  }

  override def deleteByNumberPlate(numberPlate: String):Future[Int] = {
    val carTableDML = carTable.filter(_.numberPlate === numberPlate).delete
    db.run(carTableDML)
  }

  override def findByNumberPlate(numberPlate: String): Future[Seq[Car]] = {
    val carTableQuery = carTable.filter(_.numberPlate === numberPlate).result
    db.run(carTableQuery)
  }

  override def createTable(): Future[Unit] = {
    db.run(carTable.schema.createIfNotExists)
  }
}