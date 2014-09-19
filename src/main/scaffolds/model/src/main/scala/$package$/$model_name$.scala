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

/**
 * Model class for $model_name$
 */
case class $model_name$(id: BSONObjectID = BSONObjectID.generate /* TODO: Put Model fields in here */) extends Model[BSONObjectID]
object $model_name$ { implicit val format = modelFormat { Json.format[$model_name$] } }