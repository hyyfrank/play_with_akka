package com.autodesk.www.basic.play

import java.util.concurrent.ForkJoinPool
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile
import scala.concurrent.{ExecutionContext, Future}

import com.autodesk.www.dal._

trait DataSource {
  def personRepository: PersonRepository
  def executionContext: ExecutionContext
}

class DataSourceJdbc(val dbConfig: DatabaseConfig[JdbcProfile], paralelism: Int) extends DataSource {
  override implicit val executionContext: ExecutionContext = ExecutionContext.fromExecutorService(new ForkJoinPool(paralelism))
  val personRepository = new PersonRepository(dbConfig)
}