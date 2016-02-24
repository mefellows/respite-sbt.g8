package $name;format="lower,word"$

import com.mojolly.scalate.ScalatePlugin.Binding
import com.mojolly.scalate.ScalatePlugin.ScalateKeys
import com.mojolly.scalate.ScalatePlugin.ScalateKeys._
import com.mojolly.scalate.ScalatePlugin.TemplateConfig
import org.scalatra.sbt.ScalatraPlugin
import org.scalatra.sbt.ScalatraPlugin
import $name;format="lower,word"$.Dependencies
import sbt.Keys._
import sbt.Keys._
import sbt._
import org.scalatra.sbt.PluginKeys._
import com.mojolly.scalate.ScalatePlugin._
import ScalateKeys._

object $name;format="Camel"$Build extends Build {
  val Organization = "$package$"
  val Name = "$name$"
  val Version = "$version$"

  lazy val project = Project (
    "$name;format="lower,hyphen"$",
    file("."),
    settings = Defaults.defaultSettings ++ ScalatraPlugin.scalatraWithJRebel ++ scalateSettings ++ Seq(

      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := Dependencies.Versions.ScalaVersion,
      scalateTemplateConfig in Compile <<= (sourceDirectory in Compile){ base =>
        Seq(
          TemplateConfig(
            base / "webapp" / "WEB-INF" / "templates",
            Seq.empty,  /* default imports should be added here */
            Seq(
              Binding("context", "_root_.org.scalatra.scalate.ScalatraRenderContext", importMembers = true, isImplicit = true)
            ),  /* add extra bindings here */
            Some("templates")
          )
        )
      }
    )
  )
}
