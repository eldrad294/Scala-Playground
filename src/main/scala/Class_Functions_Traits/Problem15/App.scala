package com.demo.HelloWorld
package Class_Functions_Traits.Problem15

object App {

  abstract class DonutPastry(val name:String){
    def printName():Unit
  }
  class VanillaDonut(override val name:String) extends DonutPastry(name:String) {
    override def printName(): Unit = println(s"Vanilla Donut Name -> ${name}")
  }
  class GlazedDonut(override val name:String) extends DonutPastry(name:String) {
    override def printName(): Unit = println(s"Glazed Donut Name -> ${name}")
  }
  class Pastry[P <: DonutPastry](donutPastry: P){
    def name():Unit = donutPastry.printName()
  }
  def main(args:Array[String]):Unit = {
    val vanillaPastry = new Pastry[VanillaDonut](new VanillaDonut("Vanilla Donut"))
    vanillaPastry.name()
    val glazedPastry = new Pastry[DonutPastry](new GlazedDonut("Glazed Donut"))
    glazedPastry.name()
  }

}
