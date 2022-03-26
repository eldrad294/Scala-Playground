package com.demo.HelloWorld
package com.demo.HelloWorld.Spark.WalletTransactionDataset

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.command.ClearCacheCommand.schemaString
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object App {

  def main(args:Array[String]):Unit = {

    val appName = "WalletTransactionsProcessor"
    val master = "local[1]"

    val sparkConf = new SparkConf()
      .setAppName(appName)
      .setMaster(master)
    val ss = SparkSession
      .builder()
      .appName(appName)
      .master(master)
      .getOrCreate()


    val ds = ss
      .read
      .option("header","true")
      .csv("src/main/resources/dataset.csv")

    ds.toDF().select("ACCOUNT_AMOUNT").take(10).foreach(println)
    ds.toDF().select("EVENT_TIME").take(10).foreach(println)

    ds.printSchema()
    ds.createTempView("MyDataSet")
    ds.sqlContext.sql(
        """
        SELECT SUM(ACCOUNT_AMOUNT) as TOTAL, date_trunc('DAY',event_time) as DAYS
        FROM MyDataSet
        WHERE EVENT_TIME is not null
        GROUP BY date_trunc('DAY', event_time)
        ORDER BY 1 desc
        """.stripMargin
      ).show(5)

  }

}
