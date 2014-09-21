import au.com.onegeek.respite.controllers.support.{CachingSupport, MetricsRestSupport, MetricsSupport, MetricsController}
import au.com.onegeek.respite.models.ApiKey
import au.com.onegeek.respite.security.{MongoDatabaseAuthServlet, DatabaseAuthenticationStrategy, Authentication, AuthenticationApi}
import $package$.config.{ApiDatasource, ProductionConfigurationModule}
import org.scalatra._
import javax.servlet.{ServletRegistration, ServletContext}
import $package$.$servlet_name$
import $package$.controller._
import $package$.repository._

import reactivemongo.bson.BSONObjectID
import uk.gov.hmrc.mongo.MongoConnector

import scala.reflect.ClassTag

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    import au.com.onegeek.respite.models.ModelJsonExtensions._

    val metricsPath = "/metrics"
    implicit val bindingModule = ProductionConfigurationModule
    implicit val mongoConnector = ApiDatasource.getMongoConnector

    context.mount(new $servlet_name$, "/*")
    context.mount(new MetricsController(metricsPath), metricsPath)
  }
}