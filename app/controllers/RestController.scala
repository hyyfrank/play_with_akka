package controllers

import javax.inject._

import models._
import dal._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class RestController @Inject()(repo: PersonRepository,
                                 cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {
  /**
   * 获取所有person列表
   * @return
   */
  def getPersons = Action.async { implicit request =>
    repo.list().map { people =>
      Ok(Json.toJson(people))
    }
  }

  def getCertainPerson(name: String) = Action.async {
    implicit request =>
      repo.queryByName(name).map{
        oneperson => Ok(Json.toJson(oneperson))
      }
  }


}


