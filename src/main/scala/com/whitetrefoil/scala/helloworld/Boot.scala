package com.whitetrefoil.scala.helloworld

import java.util.concurrent.TimeUnit

import akka.actor.Props
import akka.io.IO
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout

object Boot extends App with Configuration {
  import Akka.system

  val service = system.actorOf(Props[MyServiceActor], "demo-service")

  implicit val timeout = Timeout(5, TimeUnit.SECONDS)

  IO(Http) ? Http.Bind(service, interface = serviceHost, port = servicePort)
}
