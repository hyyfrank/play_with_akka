package com.autodesk.www.controllers

import com.autodesk.www.services.PeopleService
import play.api.libs.json.Json
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}

class PersonController (ps:PeopleService, cc:ControllerComponents)(implicit ec: ExecutionContext)
  extends AbstractController(cc) {
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


}


