import $name;format="lower,word"$.Dependencies
import AssemblyKeys._ // put this at the top of the file

resolvers += Resolver.url("typesafe", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns)

giter8.ScaffoldPlugin.scaffoldSettings


name := "$name;format="lower,hyphen"$"

assemblySettings

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  Dependencies.Compile.respite,
  Dependencies.Compile.scalatra,
  Dependencies.Compile.scalate,
  Dependencies.Compile.logback,
  Dependencies.Compile.Web.jettyServlet,
  Dependencies.Compile.Web.jettyWebapp,
  Dependencies.Compile.Test.scalatraTest
)

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) => {
  case "logback.xml" => MergeStrategy.first
  case x => old(x)
}
}

mainClass in assembly := Some("au.com.respite.JettyLauncher")

jarName in assembly := "$name;format="lower,hyphen"$.jar"