package com.whitetrefoil.scala.helloworld

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._
import spray.json._
import DefaultJsonProtocol._

class MyServiceActor extends Actor with MyService {
  def actorRefFactory = context

  def receive = runRoute(myRoute)
}

trait MyService extends HttpService {
  val myRoute = respondWithMediaType(`application/json`) {
    path("") {
      get {
        complete {
          Map("hello" -> "world!").toJson.compactPrint
        }
      }
    }
  }
}
