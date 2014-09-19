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

/**
 * Controller class for $model_name$
 */
class $class_name$(repository: ReactiveRepository[$model_name$, BSONObjectID])(override implicit val bindingModule: BindingModule, override implicit val tag: ClassTag[$model_name$], override implicit val objectIdConverter: String => BSONObjectID) extends RestController[$model_name$, BSONObjectID]("$model_name;format="snake"$s", $model_name$.format, repository) /*  with MetricsRestSupport[$model_name$, BSONObjectID] with Authentication with CachingRouteSupport */ {

}