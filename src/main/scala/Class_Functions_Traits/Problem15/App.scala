package com.demo.HelloWorld
package Class_Functions_Traits.Problem15

object App {
  def main(args:Array[String]):Unit = {
    val vanillaPastry = new Pastry[VanillaDonut](new VanillaDonut("Vanilla Donut"))
    vanillaPastry.name()
    val glazedPastry = new Pastry[Donut](new GlazedDonut("Glazed Donut"))
    glazedPastry.name()
  }

}
