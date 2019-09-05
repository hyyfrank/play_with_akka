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
import com.autodesk.www.dal._
import com.autodesk.www.basic.DataSource
import com.autodesk.www.basic.DataSourceJdbc
import com.autodesk.www.services._
import play.api.routing.Router



class AppLoader extends ApplicationLoader {
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
  // add db config
  private[this] val defaultDBName: DbName = DbName("playdb")
  private[this] val dbConfig: DatabaseConfig[JdbcProfile] = slickApi.dbConfig[JdbcProfile](defaultDBName)
  private[this] val dbPoolSize = 10
  private[this] lazy val dataSource: DataSource = new DataSourceJdbc(dbConfig, dbPoolSize)

//  lazy val applicationController = new
//  private[this] lazy val restController: RestController = new RestController(PersonRepository, dataSource)
//  override lazy val router: Routes = new Routes(httpErrorHandler, RestController, assets)
  lazy val router = Routes


}