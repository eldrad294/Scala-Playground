package com.demo.HelloWorld
package Class_Functions_Traits.Problem15

class VanillaDonut(override val name:String) extends Donut(name:String) {
  override def printName(): Unit = println(s"Vanilla Donut Name -> ${name}")
}
