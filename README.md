# Respite Template Project

g8 template for getting off the ground with the [Respite REST Framework](https://github.com/mefellows/respite)

## Getting Started

Follow these steps to get a basic Respite project up and running.

1. [Install sbt](http://www.scala-sbt.org/release/tutorial/Setup.html).
2. [Install giter8](https://github.com/n8han/giter8#installation).
3. In a command console, `cd` to your development environment
4. Run `g8 mefellows/respite-sbt.g8`
5. Fill in the prompted blanks. Default values are in the square brackets. Fill in the variables as you see fit, but only mess with the versions if you know what you're doing.
6. `cd` to the newly created directory and do your `git init`, etc.
7. Launch `sbt` in this directory. Wait patiently as it downloads the internet the first time.
8. Execute `container:start` to launch the web application.
9. Execute `browse` to see a default HTML template display in your browser - this is nothing exciting.

## Scaffolding

From within sbt run `g8Scaffold <TAB>` to see what can be auto-generated for you:

### Creating Models

`g8Scaffold model`

### Creating Repositories

`g8Scaffold repository`

### Creating Controllers

`g8Scaffold controller`

## Deploying

Respite packages into an executable Jar file, from within your project dir run `sbt assembly` to package theh application.

Then, from your environment, heroku, etc., ensure the appropriate environment variables are set and run the Jar:

```
DATABASE_PORT=27017 DATABASE_HOST=127.0.0.1 DATABASE_NAME=test_foo java -jar target/scala-2.10/my-project.jar
```