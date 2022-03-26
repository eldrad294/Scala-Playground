package com.demo.HelloWorld
package com.demo.HelloWorld.Custom.Inheritence

trait IVehiclePhysics {
  def accelerate(velocity:Float):Unit
  def decelerate(velocity:Float):Unit
  def isMoving:Boolean
}
