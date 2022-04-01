package com.demo.HelloWorld
package Class_Functions_Traits.Problem13

object App {

  abstract class Student(name:String, age:Int){
    def studentId():Unit
  }
  case class PrimarySchoolStudent(name:String, age:Int) extends Student(name:String, age:Int) {
    override def studentId(): Unit = println(s"[${this.getClass.getSimpleName}] - name: $name - age: $age")
  }
  case class SecondarySchoolStudent(name:String, age:Int) extends Student(name:String, age:Int) {
    override def studentId(): Unit = println(s"[${this.getClass.getSimpleName}] - name: $name - age: $age")
  }
  class School[+S <: Student](studentsList:List[S]){
    def printStudents():Unit = studentsList.foreach(_.studentId())
  }

  def main(args:Array[String]):Unit = {
    val jill = PrimarySchoolStudent("Jill", 8)
    val joe = PrimarySchoolStudent("Joe",7)
    val jack = SecondarySchoolStudent("Jack", 15)
    val james = SecondarySchoolStudent("James", 10)
    val john = SecondarySchoolStudent("John", 11)
    val studentsList = List(jill,joe,jack,james,john)
    new School(studentsList).printStudents()
  }

}
