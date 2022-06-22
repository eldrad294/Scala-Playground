package com.demo.HelloWorld
package VehicleRentalTest.Integration

import org.scalatest.{BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import slick.jdbc.JdbcBackend.Database
import VehicleRental.Car.CarDAO
import VehicleRental.Enums.FuelType
import VehicleRental.Car.dto.Car
import java.time.LocalDate
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

class CarDAOTest extends AnyWordSpecLike
  with GivenWhenThen
  with Matchers
  with BeforeAndAfterEach{

  var db:Database = _
  var objectUnderTest:CarDAO = _

  override def beforeEach(): Unit = {
    db = Database.forConfig("h2mem")
    objectUnderTest = new CarDAO(db)
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

  "A Car Vehicle Repository" should {

    "Create a new car" in {
      Given("A brand new car")
      val car:Car = Car("Demio",
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
      val createResult = objectUnderTest.insert(car)
      createResult.onComplete{
        case Success(_) => createResult.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      Then("it is expected to be retrieved from the database")
      val readResult = objectUnderTest.findByNumberPlate("ACR-393")
      readResult.onComplete{
        case Success(_) => readResult.value.get should be(Success(Vector(car)))
        case Failure(e) =>
          println(s"An error occurred $e")
      }
    }

    "Create multiple cars" in {
      Given("Two brand new cars")
      val car1:Car = Car("Demio",
        "Mazda",
        20000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393"
      )

      val car2:Car = Car("206 Hatchback",
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
      val createCar1Result = objectUnderTest.insert(car1)
      createCar1Result.onComplete{
        case Success(_) => createCar1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      val createCar2Result = objectUnderTest.insert(car2)
      createCar2Result.onComplete{
        case Success(_) => createCar2Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      Then("they are expected to be retrieved from the database")
      val readCar1Result = objectUnderTest.findByNumberPlate("ACR-393")
      readCar1Result.onComplete{
        case Success(_) => readCar1Result.value.get should be(Success(Vector(car1)))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      val readCar2Result = objectUnderTest.findByNumberPlate("FBW-182")
      readCar2Result.onComplete{
        case Success(_) => readCar2Result.value.get should be(Success(Vector(car2)))
        case Failure(e) =>
          println(s"An error occurred $e")
      }
    }

    "Create multiple cars with the same number plates should fail" in {
      Given("Two brand new cars")
      val car1:Car = Car("Demio",
        "Mazda",
        20000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393"
      )

      val car2:Car = Car("206 Hatchback",
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
      val createCar1Result = objectUnderTest.insert(car1)
      createCar1Result.onComplete{
        case Success(_) =>
          createCar1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      Then("the second should fail")
      val createCar2Result = objectUnderTest.insert(car2)
      createCar2Result.onComplete{
        case Success(_) =>
          println("This should have failed")
        case Failure(_) =>
          createCar2Result.value.get should be(Failure)
      }
    }

    "Retrieved car data should conform to the same structure as it was originally inserted" in {
      Given("A brand new car")
      val car1:Car = Car("Demio",
        "Mazda",
        20000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393"
      )

      And("The car is inserted")
      val createCar1Result = objectUnderTest.insert(car1)
      createCar1Result.onComplete{
        case Success(_) =>
          createCar1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      Then("The car retrieved should conform to the expected data properties")
      val readCar1Result = objectUnderTest.findByNumberPlate("ACR-393")
      readCar1Result.onComplete{
        case Success(result) =>
          val carList = result.toList
          carList.length shouldEqual 1
          val car:Car = carList.head
          car shouldEqual car1
        case Failure(e) =>
          println(s"An error occurred $e")
      }
    }

    "A deleted car will be removed from the database" in {
      Given("A brand new car")
      val car1:Car = Car("Demio",
        "Mazda",
        20000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393"
      )

      And("The car is inserted")
      val createCar1Result = objectUnderTest.insert(car1)
      createCar1Result.onComplete{
        case Success(_) =>
          createCar1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      And("The same car is deleted")
      val deleteCar1Result = objectUnderTest.deleteByNumberPlate("ACR-393")
      deleteCar1Result.onComplete{
        case Success(_) =>
          deleteCar1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      And("Then the same car no longer exists")
      val readCar1Result = objectUnderTest.findByNumberPlate("ACR-393")
      readCar1Result.onComplete{
        case Success(result) =>
          val carList = result.toList
          carList.length shouldEqual 0
        case Failure(e) =>
          println(s"An error occurred $e")
      }
    }

    "An existing car is updated correctly" in {
      Given("A brand new car")
      val car1:Car = Car("Demio",
        "Mazda",
        20000,
        4,
        FuelType.Petrol,
        5,
        5,
        LocalDate.of(2012, 1, 1),
        "ACR-393"
      )

      And("The car is inserted")
      val createCar1Result = objectUnderTest.insert(car1)
      createCar1Result.onComplete{
        case Success(_) =>
          createCar1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      And("The same car is updated")
      val updatedCar:Car = Car("206 Hatchback",
          "Peugeot",
          20000,
          4,
          FuelType.Petrol,
          5,
          5,
          LocalDate.of(2012, 1, 1),
          "ACR-393"
        )
      val updateCar1Result = objectUnderTest.updateByNumberPlate(updatedCar, "ACR-393")
      updateCar1Result.onComplete{
        case Success(_) =>
          updateCar1Result.value.get should be(Success(1))
        case Failure(e) =>
          println(s"An error occurred $e")
      }

      And("Then the updated car should be retrieved with the latest information")
      val readCar1Result = objectUnderTest.findByNumberPlate("ACR-393")
      readCar1Result.onComplete{
        case Success(result) =>
          val carList = result.toList
          carList.length shouldEqual 1
          val car:Car = carList.head
          car shouldEqual updatedCar
        case Failure(e) =>
          println(s"An error occurred $e")
      }
    }
  }
}