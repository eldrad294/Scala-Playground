package com.demo.HelloWorld
package VehicleRentalTest.Integration

import VehicleRental.Bike.BikeDAO
import VehicleRental.Enums.FuelType
import VehicleRental.Bike.dto.Bike
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatest.{BeforeAndAfterEach, GivenWhenThen}
import slick.jdbc.JdbcBackend.Database

import java.time.LocalDate
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

class BikeDAOTest extends AnyWordSpecLike
  with GivenWhenThen
  with Matchers
  with BeforeAndAfterEach{

  var db:Database = _
  var objectUnderTest:BikeDAO = _

  override def beforeEach(): Unit = {
    db = Database.forConfig("h2mem")
    objectUnderTest = new BikeDAO(db)
    objectUnderTest.connect()
    objectUnderTest.createTable()
  }

  override def afterEach():Unit = {
    objectUnderTest.close()
    val result = db.shutdown
    result.onComplete{
      case Success(s) => s
      case Failure(e) =>
        println(s"An error occurred $e")
    }
  }

  "A Bike Vehicle Repository" should {

    "Create a new bike" in {
      Given("A brand new bike")
      val bike:Bike = Bike("Demio",
        "Mazda",
        20000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393"
      )

      And("it is inserted into the database")
      val createResult = objectUnderTest.insert(bike)
      createResult.onComplete{
        case Success(_) => createResult.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      Then("it is expected to be retrieved from the database")
      val readResult = objectUnderTest.findByNumberPlate("ACR-393")
      readResult.onComplete{
        case Success(_) => readResult.value.get should be(Success(Vector(bike)))
        case Failure(e) =>
          println(s"An error occurred $e")
      }
    }

    "Create multiple bikes" in {
      Given("Two brand new bikes")
      val bike1:Bike = Bike("Demio",
        "Mazda",
        20000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393"
      )

      val bike2:Bike = Bike("206 Hatchback",
        "Peugeot",
        160000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2001, 1, 1),
        "FBW-182",
        2
      )

      And("they are inserted into the database")
      val createBike1Result = objectUnderTest.insert(bike1)
      createBike1Result.onComplete{
        case Success(_) => createBike1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      val createBike2Result = objectUnderTest.insert(bike2)
      createBike2Result.onComplete{
        case Success(_) => createBike2Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      Then("they are expected to be retrieved from the database")
      val readBike1Result = objectUnderTest.findByNumberPlate("ACR-393")
      readBike1Result.onComplete{
        case Success(_) => readBike1Result.value.get should be(Success(Vector(bike1)))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      val readBike2Result = objectUnderTest.findByNumberPlate("FBW-182")
      readBike2Result.onComplete{
        case Success(_) => readBike2Result.value.get should be(Success(Vector(bike2)))
        case Failure(e) =>
          println(s"An error occurred $e")
      }
    }

    "Create multiple bikes with the same number plates should fail" in {
      Given("Two brand new bikes")
      val bike1:Bike = Bike("Demio",
        "Mazda",
        20000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393"
      )

      val bike2:Bike = Bike("206 Hatchback",
        "Peugeot",
        160000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2001, 1, 1),
        "ACR-393"
      )

      And("the first is inserted into the database")
      val createBike1Result = objectUnderTest.insert(bike1)
      createBike1Result.onComplete{
        case Success(_) =>
          createBike1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      Then("the second should fail")
      val createBike2Result = objectUnderTest.insert(bike2)
      createBike2Result.onComplete{
        case Success(_) =>
          println("This should have failed")
        case Failure(_) =>
          createBike2Result.value.get should be(Failure)
      }
    }

    "Retrieved bike data should conform to the same structure as it was originally inserted" in {
      Given("A brand new bike")
      val bike1:Bike = Bike("Demio",
        "Mazda",
        20000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393"
      )

      And("The bike is inserted")
      val createBike1Result = objectUnderTest.insert(bike1)
      createBike1Result.onComplete{
        case Success(_) =>
          createBike1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      Then("The bike retrieved should conform to the expected data properties")
      val readBike1Result = objectUnderTest.findByNumberPlate("ACR-393")
      readBike1Result.onComplete{
        case Success(result) =>
          val bikeList = result.toList
          bikeList.length shouldEqual 1
          val bike:Bike = bikeList.head
          bike shouldEqual bike1
        case Failure(e) =>
          println(s"An error occurred $e")
      }
    }

    "A deleted bike will be removed from the database" in {
      Given("A brand new bike")
      val bike1:Bike = Bike("Demio",
        "Mazda",
        20000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393"
      )

      And("The bike is inserted")
      val createBike1Result = objectUnderTest.insert(bike1)
      createBike1Result.onComplete{
        case Success(_) =>
          createBike1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      And("The same bike is deleted")
      val deleteBike1Result = objectUnderTest.deleteByNumberPlate("ACR-393")
      deleteBike1Result.onComplete{
        case Success(_) =>
          deleteBike1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      And("Then the same bike no longer exists")
      val readBike1Result = objectUnderTest.findByNumberPlate("ACR-393")
      readBike1Result.onComplete{
        case Success(result) =>
          val bikeList = result.toList
          bikeList.length shouldEqual 0
        case Failure(e) =>
          println(s"An error occurred $e")
      }
    }

    "An existing bike is updated correctly" in {
      Given("A brand new bike")
      val bike1:Bike = Bike("Demio",
        "Mazda",
        20000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393"
      )

      And("The bike is inserted")
      val createBike1Result = objectUnderTest.insert(bike1)
      createBike1Result.onComplete{
        case Success(_) =>
          createBike1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      And("The same bike is updated")
      val updatedBike:Bike = Bike("206 Hatchback",
          "Peugeot",
          20000,
          4,
          FuelType.Petrol,
          5,
          5,
          LocalDate.of(2012, 1, 1),
          "ACR-393"
        )
      val updateBike1Result = objectUnderTest.updateByNumberPlate(updatedBike, "ACR-393")
      updateBike1Result.onComplete{
        case Success(_) =>
          updateBike1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      And("Then the updated bike should be retrieved with the latest information")
      val readBike1Result = objectUnderTest.findByNumberPlate("ACR-393")
      readBike1Result.onComplete{
        case Success(result) =>
          val bikeList = result.toList
          bikeList.length shouldEqual 1
          val bike:Bike = bikeList.head
          bike shouldEqual updatedBike
        case Failure(e) =>
          println(s"An error occurred $e")
      }
    }
  }
}