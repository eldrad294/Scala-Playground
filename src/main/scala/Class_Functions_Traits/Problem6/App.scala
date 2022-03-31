package com.demo.HelloWorld
package Class_Functions_Traits.Problem6

object App {

  def toUpper(param:String):String = param.toUpperCase

  def toLower(param:String):String = param.toLowerCase

  def formatNames(name:String)(f:String => String):Unit = {
    println(f(name))
  }

  def formatNames2(name:String, f:String => String):Unit = {
    println(f(name))
  }

  def main(args:Array[String]):Unit = {
    formatNames("Bob")(toUpper)
    formatNames("Joe")(toLower)
    formatNames("Jack")(toUpper)
    formatNames2("Bob",toUpper)
    formatNames2("Joe",toLower)
    formatNames2("Jack",toUpper)
  }

}
