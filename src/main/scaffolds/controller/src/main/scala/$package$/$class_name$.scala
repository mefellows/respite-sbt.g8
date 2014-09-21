/**
 * Copyright (c) ... [TODO: Insert copyright notice]
 *
 */
package $package$
import scala.reflect.ClassTag

import au.com.onegeek.respite.controllers.RestController
import au.com.onegeek.respite.models.ModelJsonExtensions._
import au.com.onegeek.respite.models.Model
import com.escalatesoft.subcut.inject.BindingModule
import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import scala.reflect._
import scala.reflect.ClassTag
import uk.gov.hmrc.mongo.{ReactiveMongoFormats, ReactiveRepository, MongoConnector}
import uk.gov.hmrc.mongo.ReactiveMongoFormats.objectIdFormats
import au.com.onegeek.respite.models.ModelJsonExtensions._
import $organisation$.model.$model_name$
import au.com.onegeek.respite.controllers.support._

/**
 * Controller class for ...
 */
class $class_name$ extends ScalatraServlet with MetricsSupport /* with CachingRouteSupport */ {

}