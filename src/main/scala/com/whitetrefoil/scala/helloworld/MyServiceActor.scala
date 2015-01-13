package com.whitetrefoil.scala.helloworld

import scala.util.{Success, Failure}
import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._
import models._
import play.api.libs.json._
import scala.concurrent.ExecutionContext.Implicits.global

class MyServiceActor extends Actor with MyService {
  def actorRefFactory = context

  def receive = runRoute(myRoute)
}

trait MyService extends HttpService {
  val myRoute = respondWithMediaType(`application/json`) {
    path("") {
      get { ctx =>
        UserDao.findAll() onComplete {
          case Success(users) =>
            val json = Json.stringify(Json.toJson(users))
            ctx.complete(json)
          case Failure(error) =>
            ctx.complete(Json.stringify(Json.toJson(Map("message" -> error.getMessage))))
        }
      }
    }
  }
}
