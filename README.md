# sparkjobserver-wordcount-scala

Reference: https://github.com/spark-jobserver/spark-jobserver


### Build
##### gradle clean build

### Run spark-jobserver
Reference: https://github.com/spark-jobserver/spark-jobserver

### Run sparkjobserver-wordcount-scala
#### Upload/Register jar file to job server
curl --data-binary  @build/libs/sparkjobserver-wordcount-scala-0.0.1-SNAPSHOT.jar localhost:8090/jars/wordcount

#### Run with new SparkContext
curl -d "inputFile = $(pwd)/inputFile/hosts.txt" 'localhost:8090/jobs?appName=wordcount&classPath=WordCount&sync=true'


#### Run with persisted/shared SparkContext
curl -d "" 'localhost:8090/contexts/shared-context?num-cpu-cores=4&memory-per-node=512m'

curl -d "inputFile = $(pwd)/inputFile/hosts.txt" 'localhost:8090/jobs?appName=wordcount&classPath=WordCount&context=shared-context&sync=true'
