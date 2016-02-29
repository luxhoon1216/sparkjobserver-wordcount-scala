# spark-wordcount-scala

Reference: http://www.datastax.com/dev/blog/accessing-cassandra-from-spark-in-java


### Build
##### gradle clean build

### Upload files to Spark server
##### create spark-cassandra-java/ directory in spark server
mkdir spark-wordcount-scala
##### upload build/libs/spark-wordcount-scala-0.0.1-SNAPSHOT.jar

### run spark-submit
##### go to spark-cassandra-java/ in spark server
cd spark-wordcount-scala
##### run spark-submit
spark-submit --class WordCount --jars build/libs/spark-wordcount-scala-0.0.1-SNAPSHOT.jar \
--master {master} spark-wordcount-scala-0.0.1-SNAPSHOT.jar {spark master} {input file name} {thread count}


spark-submit --class WordCount --jars build/libs/spark-wordcount-scala-0.0.1-SNAPSHOT.jar --master local[4] spark-wordcount-scala-0.0.1-SNAPSHOT.jar local build.gradle