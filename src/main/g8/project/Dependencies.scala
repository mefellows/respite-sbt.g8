package $name;format="lower,word"$

import sbt.Keys._
import sbt._

object Dependencies {

  object Versions {
    val ScalaVersion    = "$scala_version$"
    val ScalatraVersion = "$scalatra_version$"
    val RespiteVersion  = "0.2.3"
  }

  object Compile {

    import Versions._

    val respite          = "au.com.onegeek"            %% "respite-core"             % RespiteVersion
    val scalatra         = "org.scalatra"              %% "scalatra"                 % ScalatraVersion
    val scalatraJson     = "org.scalatra"              %% "scalatra-json"            % ScalatraVersion
    val scalatraAuth     = "org.scalatra"              %% "scalatra-auth"            % ScalatraVersion
    val scalate          = "org.scalatra"              %% "scalatra-scalate"         % ScalatraVersion
    val logback          = "ch.qos.logback"            %  "logback-classic"          % "1.0.6"                     % "runtime"
    val jackson4s        = "org.json4s"                %% "json4s-jackson"           % "3.1.0"
    val subcut           = "com.escalatesoft.subcut"   %% "subcut"                   % "2.0"
    val jettyWebapp      = "org.eclipse.jetty"         %  "jetty-webapp"             % "8.1.10.v20130312"          % "compile"
    val jettyServlet     = "org.eclipse.jetty.orbit"   %  "javax.servlet"            % "3.0.0.v201112011016"       % "compile;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar"))

    // Web
    object Web {
      val jettyWebapp      = "org.eclipse.jetty"         %  "jetty-webapp"             % "8.1.10.v20130312"          % "container;compile"
      val jettyServlet     = "org.eclipse.jetty.orbit"   %  "javax.servlet"            % "3.0.0.v201112011016"       % "container;compile;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar"))
    }

    // Test
    object Test {
      val specs2           = "org.scalatra"              %% "scalatra-specs2"             % ScalatraVersion             % "test"
      val scalatest        = "org.scalatest"             %  "scalatest_2.10"              % "2.1.0"                     % "test"
      val pegdown          = "org.pegdown"               %  "pegdown"                     % "1.0.2"                     // Need this lib to remove error: java.lang.NoClassDefFoundError: org/pegdown/PegDownProcessor
      val scalatraTest     = "org.scalatra"              %% "scalatra-scalatest"          % "2.2.2"                     % "test"
      val scalatestMongo   = "com.github.simplyscala"    %% "scalatest-embedmongo"        % "0.2.1"                     % "test"
      val scalaMock        = "org.scalamock"             %% "scalamock-scalatest-support" % "3.0.1"                     % "test"
      val mockito          = "org.mockito"               %  "mockito-core"                % "1.9.5"                     % "test"
    }

  }
}