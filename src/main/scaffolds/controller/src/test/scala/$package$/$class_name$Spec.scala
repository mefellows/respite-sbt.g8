package $package$

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
import $package$.$class_name$

class $class_name$Spec extends ScalatraSuite with WordSpecLike with Matchers with BeforeAndAfter {
  protected implicit def executor: ExecutionContext = ExecutionContext.global
  implicit val bindingModule = TestConfigurationModule

  import au.com.onegeek.respite.models.ModelJsonExtensions._

  val repository = new $model_name$Repository
  addServlet(new $class_name$(repository = repository), "/$model_name;format="lower,word"$/*")

  before {

  }

  after {

  }

  "A $class_name$" should {

    get("$model_name;format="lower,word"$") {

    }

    // ...
  }
}