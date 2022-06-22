package com.demo.HelloWorld
package VehicleRental.Templates

import slick.jdbc.H2Profile.api._

import scala.concurrent.Future

trait VehicleDAOTemplate[V <: Vehicle] {

  def connect(): Session

  def close(): Unit

  def insert(vehicle: V): Future[Int]

  def updateByNumberPlate(vehicle: V, numberPlate: String): Future[Int]

  def deleteByNumberPlate(numberPlate: String): Future[Int]

  def findByNumberPlate(numberPlate: String): Future[Seq[V]]

  def createTable():Future[Unit]

}
