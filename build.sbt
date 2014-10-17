libraryDependencies += "org.msgpack" %% "msgpack-scala" % "0.6.8"

libraryDependencies += "org.apache.kafka" % "kafka_2.9.2" % "0.8.1.1" exclude("com.sun.jmx","jmxri") exclude("com.sun.jdmk","jmxtools") exclude("javax.jms","jms")

resolvers += "Apache repo" at "https://repository.apache.org/content/repositories/releases" 

name := "sudoku"

version := "1.0"

scalaVersion := "2.10.4"

mainClass in (Compile, run) := Some("Sudoku")

