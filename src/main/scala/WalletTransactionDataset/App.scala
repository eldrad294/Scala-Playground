package com.demo.HelloWorld
package WalletTransactionDataset

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object App {

  def main(args:Array[String]):Unit = {

    val appName = "WalletTransactionsProcessor"
    val master = "local[1]"
    val sparkConf = new SparkConf()
      .setAppName(appName)
      .setMaster(master)
    val sc = new SparkContext(sparkConf)
    val ss = SparkSession
      .builder()
      .appName(appName)
      .master(master)
      .getOrCreate()
    import ss.implicits._

    // Open Raw File
    val walletTransactionDataset = sc.textFile("src/main/resources/wallet_transactions.csv")
    walletTransactionDataset
      .take(100)
      .foreach(println)

    // Clean Up
    val transformedWalletTransactionDataset = walletTransactionDataset
      .filter(line => !line.equals("RECORD_METADATA,RECORD_CONTENT"))
      .map(line => line.replace("\"","").replace("\n",""))
    transformedWalletTransactionDataset.take(100).foreach(println)

    // Transform to Dataframe
    transformedWalletTransactionDataset.toDF().show()

  }

}
