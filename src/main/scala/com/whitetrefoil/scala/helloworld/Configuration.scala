package com.whitetrefoil.scala.helloworld

import com.typesafe.config.ConfigFactory

import scala.util.Try

trait Configuration {
  val config = ConfigFactory.load()

  lazy val serviceHost = Try(config.getString("service.host")).getOrElse("localhost")
  lazy val servicePort = Try(config.getInt("service.port")).getOrElse(8080)

  lazy val mongoHosts = List(Try(config.getString("db.host")).getOrElse("localhost"))
  lazy val mongoPort = Try(config.getInt("db.port")).getOrElse(27017)
  lazy val mongoName = Try(config.getString("db.name")).getOrElse("test")
}
