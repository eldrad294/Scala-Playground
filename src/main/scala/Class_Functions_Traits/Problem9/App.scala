package com.demo.HelloWorld
package Class_Functions_Traits.Problem9

object App {

  case class Student(name:String, age:Int, var snack:Option[String]){
    override def toString: String = f"$name who is $age years old and whose favorite snack is ${snack.getOrElse("")}."
  }

  def main(args:Array[String]):Unit = {
    val jack = Student("Jack", 15, Some("Cupcake"))
    val jill = Student("Jill", 10, Some("Ice Cream"))
    val joe = Student("Joe", 7, None)
    val james = Student("James", 10, Some("Chocolate"))
    val john = Student("John", 11, None)
    joe.snack = Some("Cupcake")

    val studentList = List[Student](
      jack, jill, joe, james, john
    )

    def printList(studentList:List[Student]):Unit = studentList.foreach(println)
    printList(studentList)
  }

}
