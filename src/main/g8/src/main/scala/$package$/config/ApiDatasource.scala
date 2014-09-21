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
  val DEFAULT_DATABASE_PORT = 27017
  val DEFAULT_DATABASE_HOST = "localhost"
  val DATABASE_EXCEPTION = "Unable to connect to database: No Database host defined. Specify a 'DATABASE_URL' environment variable containing the connection string e.g. \"mongodb://localhost:27017/mydatabase\""
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
}