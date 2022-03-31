package com.demo.HelloWorld
package Class_Functions_Traits.Problem5

object App {

  def nameIsJohn:PartialFunction[String, Boolean] = {
    case "John" => true
  }
  def nameIsJoe:PartialFunction[String, Boolean] = {
    case "Joe" => true
  }
  def nameIsJackOrJill:PartialFunction[String, Boolean] = {
    case "Jack" => true
    case "Jill" => true
  }
  def default:PartialFunction[String, Boolean] = {
    case _ => false
  }
  def validator:PartialFunction[String, Boolean] = nameIsJohn orElse nameIsJoe orElse nameIsJackOrJill orElse default

  def main(args:Array[String]):Unit = {
    println(f"${validator("John")}")
    println(f"${validator("Jack")}")
    println(f"${validator("Bob")}")
    //println(f"${nameIsJackOrJill("Bob")}")  // Fails!
  }

}
