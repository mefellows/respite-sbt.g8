package $organisation$.controller

import $organisation$.config.TestConfigurationModule
import org.scalatest.concurrent.ScalaFutures
import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import uk.gov.hmrc.mongo.CurrentTime
import org.scalatra.test.scalatest.ScalatraSuite
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.concurrent.ExecutionContext
import $organisation$.model.$model_name$
import $organisation$.repository.$model_name$Repository
import $organisation$.test.{Awaiting, MongoSpecSupport}

class $model_name$ControllerSpec extends ScalatraSuite with WordSpecLike with Matchers with BeforeAndAfter with MongoSpecSupport with Awaiting {
  protected implicit def executor: ExecutionContext = ExecutionContext.global
  implicit val bindingModule = TestConfigurationModule

  import au.com.onegeek.respite.models.ModelJsonExtensions._

  val repository = new $model_name$Repository
  addServlet(new $model_name$Controller(repository = repository), "/$model_name;format="lower,word"$/*")

  before {

  }

  after {

  }

  "A $model_name$" should {

    "Respond on path /" in {
      get("/$model_name;format=" lower, word"$/") {

      }

      // ...
    }

  }
}