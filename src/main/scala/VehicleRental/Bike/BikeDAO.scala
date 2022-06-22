package com.demo.HelloWorld
package VehicleRental.Bike

import slick.jdbc.H2Profile.api._
import slick.lifted.TableQuery
import VehicleRental.Templates.VehicleDAO
import VehicleRental.Bike.dto.{Bike,BikeTable}
import scala.concurrent.Future

class BikeDAO(override val db:Database) extends VehicleDAO[Bike](db) {

  val bikeTable = TableQuery[BikeTable]

  override def insert(bike: Bike): Future[Int] = {
    val bikeTableDML = bikeTable += bike
    db.run(bikeTableDML)
  }

  override def updateByNumberPlate(bike: Bike, numberPlate: String): Future[Int] = {
    val bikeTableDML = bikeTable.filter(_.numberPlate === numberPlate).map(bike => bike).update(bike)
    db.run(bikeTableDML)
  }

  override def deleteByNumberPlate(numberPlate: String): Future[Int] = {
    val bikeTableDML = bikeTable.filter(_.numberPlate === numberPlate).delete
    db.run(bikeTableDML)
  }

  override def findByNumberPlate(numberPlate: String): Future[Seq[Bike]] = {
    db.run(bikeTable.result)
  }

  override def createTable(): Future[Unit] = {
    db.run(bikeTable.schema.createIfNotExists)
  }
}