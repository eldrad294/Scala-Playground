package com.demo.HelloWorld
package Class_Functions_Traits.Problem7

import scala.annotation.tailrec

object App {

  def main(args:Array[String]):Unit = {
    case class Student(name:String, age:Int)
    val students = Iterator(
      Student("John",7),
      Student("Jack",13),
      Student("Joe",15),
      Student("Jill",15),
      Student("James",11)
    )

    @tailrec
    def recursiveFind(students:Iterator[Student]):Any = {
      val student = students.next()
      if (student.age == 15) println(f"${student.toString} -> ${true}")
      else println(f"${student.toString}")
      if (students.hasNext) recursiveFind(students)
      else println(false)
    }

    recursiveFind(students)
  }
}
