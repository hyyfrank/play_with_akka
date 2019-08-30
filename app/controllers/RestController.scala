package controllers

import javax.inject._

import business._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class RestController @Inject()(cc: MessagesControllerComponents
                              )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {
  /**
   * 获取所有person列表
   * @return
   */
  def getCertainPerson(name: String) = Action.async {
    implicit request =>{
      var ps = new PeopleService
      ps.getCertainPerson(name).map{
        oneperson => Ok(Json.toJson(oneperson))
      }
    }
  }


}


