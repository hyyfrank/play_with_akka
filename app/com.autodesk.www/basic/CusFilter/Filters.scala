package com.autodesk.www.basic.CusFilter

import javax.inject.Inject
import play.api.http.HttpFilters

class Filters @Inject() (log: MyLoggerFilter) extends HttpFilters {
  val filters = Seq(log)
}
