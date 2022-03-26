package com.demo.HelloWorld
package com.demo.HelloWorld.Custom.HelloWorld

object HelloWorld {

  def main(args: Array[String]): Unit = {
    val x = followUpMethod("Gabriel!")
    val age = 26l
    println("Hello World! It's " + x + "!")
    println("He is " + age + " years old.")
  }

  def followUpMethod(name: String): String = {
    name
  }

}
