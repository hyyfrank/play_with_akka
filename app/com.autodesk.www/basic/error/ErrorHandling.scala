package com.autodesk.www.basic.error
import javax.inject._
import play.api.http.DefaultHttpErrorHandler
import play.api._
import play.api.mvc._
import play.api.mvc.Results._
import play.api.routing.Router
import play.core.SourceMapper

import scala.concurrent._

class ErrorHandling( env: Environment,
                     config: Configuration,
                     sourceMapper: Option[SourceMapper],
                     router:  => Option[Router] = None)
  extends DefaultHttpErrorHandler(env, config, sourceMapper, router) {

  override protected def onNotFound(request: RequestHeader, message: String): Future[Result] = {
    Future.successful {
      NotFound("Frank:Could not find " + request)
    }
  }


}