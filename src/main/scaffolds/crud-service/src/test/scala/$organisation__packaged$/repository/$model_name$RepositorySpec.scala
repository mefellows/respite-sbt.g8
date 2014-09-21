package $organisation$.repository

import org.scalatest.concurrent.ScalaFutures
import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import uk.gov.hmrc.mongo.CurrentTime
import org.scalatra.test.scalatest.ScalatraSuite
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.concurrent.ExecutionContext
import $organisation$.test.{Awaiting, MongoSpecSupport}
import $organisation$.model.$model_name$

class $model_name$RepositorySpec extends ScalatraSuite with ScalaFutures with  WordSpecLike with Matchers with BeforeAndAfter with MongoSpecSupport with Awaiting {

  val repository = new $model_name$Repository

  before {
    repository.removeAll
  }

  after {

  }

  "A $model_name$Repository" should {

    "when ..." in {
      // ...
    }

  }
}