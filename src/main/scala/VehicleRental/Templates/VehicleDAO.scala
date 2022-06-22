package com.demo.HelloWorld
package VehicleRental.Templates

import slick.jdbc.H2Profile.api._

import scala.concurrent.Future

abstract class VehicleDAO[V <: Vehicle](val db:Database) extends VehicleDAOTemplate[V]{

  def connect(): Session = db.createSession()

  def close(): Unit = db.close()

  def insert(vehicle: V): Future[Int]

  def updateByNumberPlate(vehicle: V, numberPlate: String): Future[Int]

  def deleteByNumberPlate(numberPlate: String): Future[Int]

  def findByNumberPlate(numberPlate: String): Future[Seq[V]]

  def createTable():Future[Unit]

}