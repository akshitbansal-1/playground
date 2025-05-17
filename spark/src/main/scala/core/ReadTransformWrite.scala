package core

import org.apache.spark.{SparkConf, SparkContext}

object ReadTransformWrite extends App {

  val sparkConfig = new SparkConf().setAppName("master").setMaster("local")
  val sc = new SparkContext(sparkConfig)

  val rdd = sc.textFile("/Users/akshitbansal/Developer/personal/Spark-Learn/src/main/scala/README.md").cache()

  val x = rdd.map(value => value.toUpperCase())
  val y = x.filter(!_.startsWith("A"))

  y.saveAsTextFile("/Users/akshitbansal/Developer/personal/Spark-Learn/src/main/scala/123")
  sc.stop()
}
