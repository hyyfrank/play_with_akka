package com.autodesk.www.basic.CusFilter

import javax.inject._
import play.api.mvc._
import scala.concurrent.ExecutionContext

class MyLoggerFilter @Inject() (implicit ec: ExecutionContext) extends EssentialFilter {
  def apply(nextFilter: EssentialAction) = new EssentialAction {
    def apply(requestHeader: RequestHeader) = {
      println("Filter1 receive request")
      nextFilter(requestHeader).map { result =>
        println("Filter1 receive response")
        result
      }
    }
  }
}

