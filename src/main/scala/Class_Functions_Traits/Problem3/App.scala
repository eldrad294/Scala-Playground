package com.demo.HelloWorld
package Class_Functions_Traits.Problem3

object App {
  def integerInputLiteral(param:Int):Unit = println(f"${param} as String literal = ${param}")
  def integerInputLiteral2(params:List[Int]):Unit = println(f"${params.mkString(", ")} as String literal = ${params.mkString(" :: ")}")
  def integerInputLiteral3(params:Int*):Unit = println(f"${params.mkString(", ")} as String literal = ${params.mkString(" :: ")}")
  def main(args:Array[String]):Unit = {
    integerInputLiteral(10)
    integerInputLiteral2(List(10,11,12))
    integerInputLiteral3(10,11,12)
  }

}
