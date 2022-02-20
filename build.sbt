ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaHelloWorld",
    idePackagePrefix := Some("com.demo.HelloWorld")
  )

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.30.0"