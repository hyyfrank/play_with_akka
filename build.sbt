name := """play-scala-slick-example"""

version := "2.7.x"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.0"

libraryDependencies += guice
libraryDependencies += "com.typesafe.play" %% "play-slick" % "4.0.2"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "4.0.2"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.34"
// HOCON notation
libraryDependencies += "com.typesafe" % "config" % "1.0.2"
// using dependence injection in router
routesGenerator := InjectedRoutesGenerator
// default setting for scalariform setting
//com.typesafe.sbt.SbtScalariform.scalariformSettings

libraryDependencies += specs2 % Test

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xfatal-warnings"
)

