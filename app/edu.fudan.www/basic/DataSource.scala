package edu.fudan.www.basic

import java.util.concurrent.ForkJoinPool

import dal._
import model.Device
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

import scala.collection.immutable.Iterable
import scala.concurrent.{ExecutionContext, Future}

trait DataSource {
  def personRepository: PersonRepository
  def executionContext: ExecutionContext
}

class DataSourceJdbc(val dbConfig: DatabaseConfig[JdbcProfile], paralelism: Int) extends DataSource {

  override implicit val executionContext: ExecutionContext = ExecutionContext.fromExecutorService(new ForkJoinPool(paralelism))

  val personRepository = new PersonRepository(dbConfig)
}
