package com.autodesk.www


import play.api.ApplicationLoader.Context
import play.api.db.evolutions.EvolutionsComponents
import play.api.db.slick.evolutions.SlickEvolutionsComponents
import play.api.db.slick.{DbName, DefaultSlickApi}
import play.api.{Application, ApplicationLoader, BuiltInComponentsFromContext}
import play.filters.HttpFiltersComponents
import router.Routes
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

import com.autodesk.www.controller._
import com.autodesk.www.dal._
import com.autodesk.www.basic.DataSource
import com.autodesk.www.basic.DataSourceJdbc
import com.autodesk.www.services._



class Boot extends ApplicationLoader {
  def load(context: Context): Application = {
    val components = new BootComponents(context)
    components.applicationEvolutions // Run the evolutions
    components.application
  }
}

class BootComponents(context: Context)
  extends BuiltInComponentsFromContext(context)
    with HttpFiltersComponents
    with EvolutionsComponents
    with SlickEvolutionsComponents {

  override def api: DefaultSlickApi = new DefaultSlickApi(environment, configuration, applicationLifecycle)
  private[this] val defaultDBName: DbName = DbName("playdb")
  private[this] val dbConfig: DatabaseConfig[JdbcProfile] = slickApi.dbConfig[JdbcProfile](defaultDBName)

  // TODO put this into config
  private[this] val dbPoolSize = 10
  private[this] lazy val dataSource: DataSource = new DataSourceJdbc(dbConfig, dbPoolSize)
//  lazy val applicationController = new
//  private[this] lazy val restController: RestController = new RestController(PersonRepository, dataSource)
//  override lazy val router: Routes = new Routes(httpErrorHandler, RestController, assets)
}