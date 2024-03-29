name := """IST440Resume-Play"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean, SbtWeb)

scalaVersion := "2.12.8"

javacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-parameters",
  "-Xlint:unchecked",
  "-Xlint:deprecation",
  "-Werror"
)

crossScalaVersions := Seq("2.11.12", "2.12.7")

libraryDependencies += guice

// AWS
libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.3.11"

// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.197"

// PostgreSQL Database Dependencies
libraryDependencies += jdbc
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.11.1" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "3.1.3" % Test



// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))