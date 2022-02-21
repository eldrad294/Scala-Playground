package com.demo.HelloWorld
package Inheritence

class TruckBuilder extends Builder {

  private var weight:Double = _
  private var occupancy:Long = 0L
  private var name:String = ""
  private var tyreCount:Long = 0L
  private var engineHorsePower: Long = 0L
  private var topSpeedKmH: Float = .0F
  private var breakCoefficient: Float = .0F

  def setWeight(weight:Double):TruckBuilder = {
    this.weight = weight
    this
  }

  def setOccupancy(occupancy:Long):TruckBuilder = {
    this.occupancy = occupancy
    this
  }

  def setName(name:String):TruckBuilder = {
    this.name = name
    this
  }

  def setTyreCount(tyreCount:Long):TruckBuilder  = {
    this.tyreCount = tyreCount
    this
  }

  def setEngineHorsePower(engineHorsePower:Long):TruckBuilder  = {
    this.engineHorsePower = engineHorsePower
    this
  }

  def setTopSpeedKmH(topSpeedKmH:Float):TruckBuilder = {
    this.topSpeedKmH = topSpeedKmH
    this
  }

  def setBreakCoefficient(breakCoefficient:Float):TruckBuilder = {
    this.breakCoefficient = breakCoefficient
    this
  }

  override def build(): Truck =
    new Truck(this.weight, this.occupancy, this.name, this.tyreCount, this.engineHorsePower, this.topSpeedKmH, this.breakCoefficient)
}
