package com.autodesk.www.basic.play

import com.autodesk.www.controllers._
import com.autodesk.www.dal.PersonRepository
import com.autodesk.www.services.PeopleService
import com.typesafe.config.ConfigValueFactory
import org.slf4j.LoggerFactory
import play.api.db.evolutions.EvolutionsComponents
import play.api.db.slick.evolutions.SlickEvolutionsComponents
import play.api.db.slick.{DbName, SlickComponents}
import play.api.mvc.EssentialFilter
import play.api.routing.Router
import play.api.{ApplicationLoader, BuiltInComponentsFromContext}
import router.Routes
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

class ServiceBoot(context: ApplicationLoader.Context) extends BuiltInComponentsFromContext(context)
  with SlickComponents
  with EvolutionsComponents
  with SlickEvolutionsComponents{
  lazy val bootLogger = LoggerFactory.getLogger("com.autodesk.www")
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
  val dbEncyptConfig = slickApi.dbConfig[JdbcProfile](DbName("playdb"))
  val writerConfig = try {
    val decryptedConfig = dbEncyptConfig.config.
      withValue("db.user", ConfigValueFactory.fromAnyRef(dbEncyptConfig.config.getConfig("db").getString("user"))).
      withValue("db.password", ConfigValueFactory.fromAnyRef(dbEncyptConfig.config.getConfig("db").getString("password")))
    DatabaseConfig.forConfig[JdbcProfile]("", decryptedConfig)
  } catch {
    case e: Throwable => {
      bootLogger.warn("DBConfig Encrypt error ", e)
      dbEncyptConfig
    }
  }
  lazy val singletonPersonRepository = new PersonRepository(writerConfig)
  val ps: PeopleService = new PeopleService(singletonPersonRepository)
  lazy val personController = new PersonController(ps,controllerComponents)

  lazy val router: Router = new Routes(httpErrorHandler, personController)

  override def httpFilters: Seq[EssentialFilter] = Nil
  println("start....successful...")
}
