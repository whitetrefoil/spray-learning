package com.whitetrefoil.scala.helloworld

import reactivemongo.api._
import scala.concurrent.ExecutionContext.Implicits.global

object Mongo extends Configuration {
  import Akka.system

  private val driver = new MongoDriver(system)
  private val connection = driver.connection(mongoHosts)
  val db = connection.db(mongoName)
}
