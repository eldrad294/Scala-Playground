ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaHelloWorld",
    idePackagePrefix := Some("com.demo.HelloWorld")
  )
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.1"
// https://mvnrepository.com/artifact/org.scalatest/scalatest-flatspec
libraryDependencies += "org.scalatest" %% "scalatest-flatspec" % "3.3.0-SNAP3" % Test
// https://mvnrepository.com/artifact/com.typesafe.slick/slick
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.4.0-M1"
libraryDependencies += "com.h2database" % "h2" % "1.4.200"
// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test




