name := "SprayHelloWorld"

organization := "com.whitetrefoil"

version := "1.0"

scalaVersion := "2.11.5"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.3.8"
  val sprayV = "1.3.2"
  val sprayJsonV = "1.3.1"
  val reactivemongoV = "0.10.5.0.akka23"
  val reactivemongoExtensionV = "0.10.5.0.0.akka23"
  val logbackV = "1.1.2"

  Seq(
    "io.spray" %% "spray-can" % sprayV,
    "io.spray" %% "spray-routing" % sprayV,
    "io.spray" %% "spray-json" % sprayJsonV,
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "org.reactivemongo" %% "reactivemongo" % reactivemongoV,
    "org.reactivemongo" %% "reactivemongo-extensions-json" % reactivemongoExtensionV,
    "ch.qos.logback" % "logback-classic" % logbackV
  )
}

resolvers ++= Seq(
  "Spray repository" at "http://repo.spray.io",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)

Revolver.settings
