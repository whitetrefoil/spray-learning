package com.whitetrefoil.scala.helloworld.models

import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import play.modules.reactivemongo.json.BSONFormats._
import reactivemongo.extensions.json.dao.JsonDao
import scala.concurrent.ExecutionContext.Implicits.global

case class User(
  _id: BSONObjectID = BSONObjectID.generate,
  name: String
  )

object User {
  implicit val userFormat = Json.format[User]
}

object UserDao
  extends JsonDao[User, BSONObjectID](com.whitetrefoil.scala.helloworld.Mongo.db, "users")
