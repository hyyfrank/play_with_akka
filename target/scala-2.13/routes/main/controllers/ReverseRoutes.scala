// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/huangfr/github/play_with_akka/conf/routes
// @DATE:Fri Aug 30 17:41:02 CST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:10
  class ReverseRestController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def getPersons(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "rest")
    }
  
    // @LINE:11
    def getCertainPerson(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "rest/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
  }

  // @LINE:6
  class ReversePersonController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getPersons(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "persons")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:7
    def addPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "person")
    }
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
