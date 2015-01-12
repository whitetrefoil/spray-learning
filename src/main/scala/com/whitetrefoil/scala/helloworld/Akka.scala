package com.whitetrefoil.scala.helloworld

import akka.actor.ActorSystem

object Akka {
  implicit val system = ActorSystem("hello-world")
}
