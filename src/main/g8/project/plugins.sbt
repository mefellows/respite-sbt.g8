addSbtPlugin("com.mojolly.scalate" % "xsbt-scalate-generator" % "0.4.2")

addSbtPlugin("net.databinder.giter8" %% "giter8-scaffold" % "0.6.4")

addSbtPlugin("org.scalatra.sbt" % "scalatra-sbt" % "0.3.2")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.0")

resolvers += Resolver.url(
  "bintray-sbt-plugin-releases",
  url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(
    Resolver.ivyStylePatterns)

resolvers += Classpaths.sbtPluginReleases

resolvers += Classpaths.typesafeReleases

addSbtPlugin("au.com.onegeek" % "sbt-dotenv" % "1.0.21")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.7.4")

addSbtPlugin("com.heroku" % "sbt-heroku" % "0.4.1")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")