package com.demo.HelloWorld
package Inheritence

trait IVehiclePhysics {
  def accelerate(velocity:Float):Unit
  def decelerate(velocity:Float):Unit
  def isMoving:Boolean
}
