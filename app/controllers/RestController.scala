package controllers

import javax.inject._

import business.PeopleService
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class RestController @Inject()(ps:PeopleService,cc: MessagesControllerComponents)
                              (implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {
  /**
   * 获取所有person列表
   * @return
   */
  def getPersons() = Action.async {
    implicit request =>{
      ps.getAllPerson().map{
        persons=>Ok(Json.toJson(persons))
      }
    }
  }
  def getPersonByName(name: String) = Action.async {
    implicit request =>{
      ps.getCertainPerson(name).map{
        oneperson => Ok(Json.toJson(oneperson))
      }
    }
  }
  def addPerson() = Action.async {
    implicit request=>{
      val json = request.body.asJson
      println(json.toString)
      ps.creatPerson("jelly",21).map{
        _ => Ok("create successful")
      }
     }
  }


}


