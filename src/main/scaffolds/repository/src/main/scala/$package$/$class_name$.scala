/**
 * Copyright (c) ... [TODO: Insert copyright notice]
 *
 */
package $package$

import au.com.onegeek.respite.models.ModelJsonExtensions._
import au.com.onegeek.respite.models.Model
import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import uk.gov.hmrc.mongo.{ReactiveMongoFormats, ReactiveRepository, MongoConnector}
import uk.gov.hmrc.mongo.ReactiveMongoFormats.objectIdFormats
import au.com.onegeek.respite.models.ModelJsonExtensions._
import au.com.onegeek.respite.controllers.support.{CachingRouteSupport, MetricsSupport, MetricsRestSupport}
import $organisation$.model.$model_name$

/**
 * Repository object for $model_name$
 */
class $class_name$(implicit mc: MongoConnector)
  extends ReactiveRepository[$model_name$, BSONObjectID]("$model_name;format="snake"$", mc.db, modelFormatForMongo {Json.format[$model_name$]}, ReactiveMongoFormats.objectIdFormats) {
}