name := "spark-measure"

version := "0.12.1"

scalaVersion := "2.10.7"
    
resolvers += Resolver.mavenLocal
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

isSnapshot := false

spIgnoreProvided := true

val spark = "2.1.0"

sparkVersion := spark

libraryDependencies += "org.apache.spark" %% "spark-sql" % spark
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.6.5"
libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.25"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.3" % "test"
libraryDependencies += "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.9.1" % "test"

organization := "ch.cern.sparkmeasure"

// publishing to Maven
publishMavenStyle := true
publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))

homepage := Some(url("https://github.com/LucaCanali/sparkMeasure"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/LucaCanali/sparkMeasure"),
    "scm:git@github.com:LucaCanali/sparkMeasure.git"
  )
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", "MANIFEST.MF") =>
    MergeStrategy.discard
  case PathList(ps @ _*) =>
    MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
