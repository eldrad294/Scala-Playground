package com.demo.HelloWorld
package Hearthstone

class Utils {

  def loadFile(filePath:String):Iterator[Array[String]] = io.Source.fromFile(filePath).getLines().map(_.split(",").toArray)

}
