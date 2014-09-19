package $package$.config

import reactivemongo.api.{DefaultDB, MongoConnection, MongoDriver}
import uk.gov.hmrc.mongo.MongoConnector
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}
import org.slf4j.LoggerFactory

/**
 * Created by mfellows on 6/04/2014.
 */
object ApiDatasource {

  val logger = LoggerFactory.getLogger(getClass)
  val DEFAULT_DATABASE_PORT = 17017
  val DEFAULT_DATABASE_HOST = "localhost"
  val DATABASE_EXCEPTION = "Unable to connect to database: No Database host defined. Specify a 'DATABASE_URL' environment variable containing the connection string e.g. \"mongodb://localhost:17017/mydatabase\""
  implicit val mongoConnector = new MongoConnector(getDatabaseURL)
  implicit val mongo = mongoConnector.db

  //  private lazy val database: DefaultDB = connect()

  def getDatabaseURL: String = {

    val databaseURL = if(System.getenv("DATABASE_URL") != null) {
      System.getenv("DATABASE_URL")
    } else {
      val port      = if(System.getenv("DATABASE_PORT") != null) System.getenv("DATABASE_PORT").toInt else DEFAULT_DATABASE_PORT
      val host      = if(System.getenv("DATABASE_HOST") != null) System.getenv("DATABASE_HOST") else DEFAULT_DATABASE_HOST
      val database  = if(System.getenv("DATABASE_NAME") != null) System.getenv("DATABASE_NAME") else throw new Exception(DATABASE_EXCEPTION)
      "mongodb://" + host + ":" + port + "/" + database
    }
    databaseURL
  }

  def getMongoConnector: MongoConnector = {
    mongoConnector
  }

  def connect(): DefaultDB = {
    val uri: String = getDatabaseURL

    logger.info("Connecting to MongoDB with URI: " + uri)

    // (creates an actor system)
    val driver = new MongoDriver
    val conn: Try[MongoConnection] =
      MongoConnection.parseURI(uri).map {
        parsedUri =>
          driver.connection(parsedUri)
      }
    conn match {
      case Success(connection) =>
        logger.debug("connected to DB: " + uri)
        connection("metrics")
      case Failure(e) =>
        logger.error("Unable to connect to db with URI: " + uri + ". Error message: " + e.getMessage)
        throw new Exception("Unable to connect to db. Error message: " + e.getMessage)
    }
  }

  def getConnection: DefaultDB = {
    var database = "metrics"
    var uri: String = "mongodb://localhost:17017/"

    if (System.getenv("MONGOHQ_URL") != null) {
      uri = System.getenv("MONGOHQ_URL")
    }
    if (System.getenv("MONGO_DATABASE") != null) {
      database = System.getenv("MONGO_DATABASE")
    }
    uri = uri + database
    logger.info("Connecting to MongoDB with URI: " + uri)

    // (creates an actor system)
    val driver = new MongoDriver
    val conn: Try[MongoConnection] =
      MongoConnection.parseURI(uri).map {
        parsedUri =>
          driver.connection(parsedUri)
      }
    conn match {
      case Success(connection) =>
        logger.debug("connected to DB: " + uri)
        connection(database)
      case Failure(e) =>
        logger.error("Unable to connect to db with URI: " + uri + ". Error message: " + e.getMessage)
        throw new Exception("Unable to connect to db. Error message: " + e.getMessage)
    }
  }
}