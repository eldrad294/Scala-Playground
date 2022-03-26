package com.demo.HelloWorld
package com.demo.HelloWorld.Custom.Inheritence

class Truck (
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
