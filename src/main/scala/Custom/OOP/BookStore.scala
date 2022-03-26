package com.demo.HelloWorld
package com.demo.HelloWorld.Custom.OOP

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Book Entity
 * */
class Book(
  val name:String,
  val author:String,
  val publishedDate:LocalDate,
  val isHardBoundAvailable:Boolean,
  val pageSize:Long
){

}

/**
 * Store Entity. A single Store entity can have multiple Book entities.
 * */
class Store (
  val name:String,
  var address:String,
  val sizeSquareFeet:Float,
  val openedDate:LocalDate,
  val booksInventory:Array[Book]
){
}

object BookStore {

  def main(args:Array[String]):Unit = {
    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val book1 = new Book("Moby Dick", "Herman Melville", LocalDate.parse("1995-04-29", dateTimeFormatter), false, 864)
    val book2 = new Book("Dune", "Frank Herbert", LocalDate.parse("1960-04-29", dateTimeFormatter), true, 864)
    val book3 = new Book("Dune Messiah", "Herman Melville", LocalDate.parse("1965-04-29", dateTimeFormatter), true, 864)
    val booksArray = Array(book1, book2, book3)

    val store = new Store("MqabbaStore","Triq il-Lellux, 36 Plot B", 20.4F, LocalDate.now().minusYears(11), booksArray)

    for (book <- store.booksInventory)
      println(book.name + " published in [" + book.publishedDate + "]")
  }

}