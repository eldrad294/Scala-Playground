package com.demo.HelloWorld
package Class_Functions_Traits.Problem15

class Pastry[P <: Donut](donutPastry: P){
  def name():Unit = donutPastry.printName()
}
