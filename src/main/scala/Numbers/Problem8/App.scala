package com.demo.HelloWorld
package Numbers.Problem8

object App {

  def main(args:Array[String]):Unit = {
    val items = Seq(
      Tuple2("James", 7),
      Tuple2("Andy", 8),
      Tuple2("Tommy", 10),
      Tuple2("Bob", 13),
      Tuple2("Sam", 10)
    )
    val total = items.foldLeft(0){(prev, curr) => prev + curr._2}
    print(total)
  }
}
