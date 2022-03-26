package com.demo.HelloWorld
package com.demo.HelloWorld.Custom.Inheritence

class CarBuilder extends Builder{

  private var weight:Double = _
  private var occupancy:Long = 0L
  private var name:String = ""
  private var tyreCount:Long = 0L
  private var engineHorsePower: Long = 0L
  private var topSpeedKmH: Float = .0F
  private var breakCoefficient: Float = .0F

  def setWeight(weight:Double):CarBuilder  = {
    this.weight = weight
    this
  }

  def setOccupancy(occupancy:Long):CarBuilder = {
    this.occupancy = occupancy
    this
  }

  def setName(name:String):CarBuilder = {
    this.name = name
    this
  }

  def setTyreCount(tyreCount:Long):CarBuilder = {
    this.tyreCount = tyreCount
    this
  }

  def setEngineHorsePower(engineHorsePower:Long):CarBuilder = {
    this.engineHorsePower = engineHorsePower
    this
  }

  def setTopSpeedKmH(topSpeedKmH:Float):CarBuilder = {
    this.topSpeedKmH = topSpeedKmH
    this
  }

  def setBreakCoefficient(breakCoefficient:Float):CarBuilder = {
    this.breakCoefficient = breakCoefficient
    this
  }

  override def build(): Car =
    new Car(this.weight, this.occupancy, this.name, this.tyreCount, this.engineHorsePower, this.topSpeedKmH, this.breakCoefficient)

}