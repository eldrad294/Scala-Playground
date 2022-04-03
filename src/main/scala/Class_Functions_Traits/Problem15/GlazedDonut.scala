package com.demo.HelloWorld
package Class_Functions_Traits.Problem15

class GlazedDonut(override val name:String) extends Donut(name:String) {
  override def printName(): Unit = println(s"Glazed Donut Name -> ${name}")
}
