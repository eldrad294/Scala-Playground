package com.demo.HelloWorld
package Inheritence

class Car (
            override val weight:Double,
            override val occupancy:Long,
            override val name:String,
            override val tyreCount:Long,
            override val engineHorsePower: Long,
            override val topSpeedKmH: Float,
            override val breakCoefficient: Float
          ) extends Vehicle (
  weight,
  occupancy,
  name,
  tyreCount,
  engineHorsePower,
  topSpeedKmH,
  breakCoefficient
){
}