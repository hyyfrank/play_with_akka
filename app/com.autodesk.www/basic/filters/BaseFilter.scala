package com.autodesk.www.filters

import akka.util.ByteString
import play.api.Logger
import play.api.libs.streams.Accumulator
import play.api.mvc.{EssentialAction, EssentialFilter, RequestHeader, Result}

import scala.concurrent.ExecutionContext

class BaseFilter()(implicit ec: ExecutionContext) extends EssentialFilter {
  override def apply(nextFilter: EssentialAction): EssentialAction = new EssentialAction {
    override def apply(requestHeader: RequestHeader): Accumulator[ByteString, Result] = {
      val startTime = System.currentTimeMillis
      nextFilter(requestHeader).map { result =>
        val endTime = System.currentTimeMillis
        val requestTime = endTime - startTime
        println("hello")
//        Logger.info(s"${requestHeader.method} ${requestHeader.uri}" +
//          s" took ${requestTime}ms and returned ${result.header.status}")
        result.withHeaders("Request-Time" -> requestTime.toString)
      }
    }
  }
}
