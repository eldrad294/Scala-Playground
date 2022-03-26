package com.demo.HelloWorld
package com.demo.HelloWorld.Custom.Inheritence

abstract class VehiclePhysics (
                     val topSpeedKmH: Float,
                     val breakCoefficient: Float
                     ) extends IVehiclePhysics {
  var currentSpeedKmH: Float = 0.0F

  def accelerate(velocity:Float):Unit = {
    if (velocity + currentSpeedKmH < topSpeedKmH)
      currentSpeedKmH += velocity
    else
      currentSpeedKmH = topSpeedKmH
  }

  def decelerate(velocity:Float):Unit = {
    if (currentSpeedKmH - velocity * breakCoefficient < 0)
      currentSpeedKmH = 0
    else
      currentSpeedKmH -= velocity * breakCoefficient
  }

  def isMoving:Boolean = {
    if (currentSpeedKmH > 0)
      true
    else false
  }

}
