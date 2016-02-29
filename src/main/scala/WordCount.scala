import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object WordCount {
  def main(args: Array[String]) {
    val sc = new SparkContext(new SparkConf().setAppName("Spark Word Count").setMaster(args(0)))
 
    // split each document into words
    val tokenized = sc.textFile(args(1)).flatMap(_.split(" "))
 
    // count the occurrence of each word
    val wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)
 
    System.out.println(wordCounts.collect().mkString(", "))
  }
}