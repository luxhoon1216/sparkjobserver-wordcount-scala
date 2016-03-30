import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import spark.jobserver.SparkJob
import spark.jobserver.SparkJobValidation
import com.typesafe.config.Config
import spark.jobserver.SparkJobInvalid
import spark.jobserver.SparkJobValid
import scala.util.Try


object WordCount extends SparkJob {
  
  override def validate(sc: SparkContext, config: Config): SparkJobValidation = {
    Try(config.getString("inputFile"))
    .map(x => SparkJobValid)
    .getOrElse(SparkJobInvalid("No inputFile"))
  }
  
  override def runJob(sc: SparkContext, config: Config): Any = {
    val tokenized = sc.textFile(config.getString("inputFile")).flatMap(_.split(" "))
 
    // count the occurrence of each word
    val wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)
    wordCounts.collect().toMap
  }
}