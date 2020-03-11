resolvers += sbt.Resolver.bintrayRepo("denigma", "denigma-releases") //add resolver

enablePlugins(ScalaJSPlugin)

name := "SpaceGame"

version := "0.1"

scalaVersion := "2.12.10"

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.denigma" %%% "threejs-facade" % "0.0.77-0.1.8" //add dependency
libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0"
