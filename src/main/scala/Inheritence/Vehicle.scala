package com.demo.HelloWorld
package Inheritence

abstract class Vehicle (
              val weight:Double,
              val occupancy:Long,
              val name:String,
              val tyreCount:Long,
              val engineHorsePower: Long,
              override val topSpeedKmH: Float,
              override val breakCoefficient: Float
              ) extends VehiclePhysics (topSpeedKmH, breakCoefficient){

  override def accelerate(velocity:Float):Unit = {
    if (velocity * engineHorsePower + currentSpeedKmH < topSpeedKmH)
      currentSpeedKmH += velocity * engineHorsePower
    else
      currentSpeedKmH = topSpeedKmH
  }

  def describe():Unit =
    println(s"Name [$name]\nWeight [$weight]\nOccupancy [$occupancy]\nTyre Count [$tyreCount]\nEngine Horse Power [$engineHorsePower]")
}
