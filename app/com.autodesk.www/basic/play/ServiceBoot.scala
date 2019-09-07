package com.autodesk.www.basic.play

import com.autodesk.www.basic.error.ErrorHandling
import com.autodesk.www.controllers._
import com.autodesk.www.dal.PersonRepository
import com.autodesk.www.services.PeopleService
import com.typesafe.config.ConfigValueFactory
import org.slf4j.LoggerFactory
import play.api.db.evolutions.EvolutionsComponents
import play.api.db.slick.evolutions.SlickEvolutionsComponents
import play.api.db.slick.{DbName, SlickComponents}
import play.api.http.HttpErrorHandler
import play.api.mvc.EssentialFilter
import play.api.routing.Router
import play.api.{ApplicationLoader, BuiltInComponentsFromContext, OptionalSourceMapper}
import router.Routes
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile
import javax.inject.Provider

class ServiceBoot(context: ApplicationLoader.Context) extends BuiltInComponentsFromContext(context)
  with SlickComponents
  with EvolutionsComponents
  with SlickEvolutionsComponents{
  // add logger
  lazy val bootLogger = LoggerFactory.getLogger("com.autodesk.www")
  // add custom error handling
  override lazy val httpErrorHandler: HttpErrorHandler = new ErrorHandling(context.environment, context.initialConfiguration, devContext.map(_.sourceMapper), Some(router))

  // add singlton db
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
  // bind controller with service
  lazy val singletonPersonRepository = new PersonRepository(writerConfig)
  val ps: PeopleService = new PeopleService(singletonPersonRepository)
  lazy val personController = new PersonController(ps,controllerComponents)
  lazy val router: Router = new Routes(httpErrorHandler, personController)
  // add default implementataion of parent class.
  override def httpFilters: Seq[EssentialFilter] = Nil
  println("start....successful...")
}
