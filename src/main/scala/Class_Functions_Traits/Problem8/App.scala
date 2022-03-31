package com.demo.HelloWorld
package Class_Functions_Traits.Problem8

object App {

  abstract class Student(name:String, age:Int){
    def printName:Unit = println(name)
  }
  class PrimaryStudent(name:String, age:Int) extends Student(name:String, age:Int){
    override def printName: Unit = println(f"Primary Student Name -> $name")
  }
  class SecondaryStudent(name:String, age:Int) extends Student(name:String, age:Int){
    override def printName: Unit = println(f"Secondary Student Name -> $name")
  }
  def main(args:Array[String]):Unit = {
    val student1 = new PrimaryStudent("John", 8)
    val student2 = new PrimaryStudent("Jill", 10)
    val student3 = new SecondaryStudent("James ", 13)
    val student4 = new SecondaryStudent("Joe ", 14)
    val student5 = new SecondaryStudent("Jack", 11)

    val students = List[Student](
      student1,
      student2,
      student3,
      student4,
      student5
    )

    def listStudents(students:List[Student]) = students.foreach(_.printName)
    listStudents(students)
  }

}
