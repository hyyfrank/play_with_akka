// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/huangfr/github/play_with_akka/conf/routes
// @DATE:Fri Aug 30 17:41:02 CST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  PersonController_2: controllers.PersonController,
  // @LINE:10
  RestController_0: controllers.RestController,
  // @LINE:14
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    PersonController_2: controllers.PersonController,
    // @LINE:10
    RestController_0: controllers.RestController,
    // @LINE:14
    Assets_1: controllers.Assets
  ) = this(errorHandler, PersonController_2, RestController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PersonController_2, RestController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.PersonController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person""", """controllers.PersonController.addPerson"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """persons""", """controllers.PersonController.getPersons"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rest""", """controllers.RestController.getPersons"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rest/""" + "$" + """name<[^/]+>""", """controllers.RestController.getCertainPerson(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_PersonController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_PersonController_index0_invoker = createInvoker(
    PersonController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_PersonController_addPerson1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person")))
  )
  private[this] lazy val controllers_PersonController_addPerson1_invoker = createInvoker(
    PersonController_2.addPerson,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "addPerson",
      Nil,
      "POST",
      this.prefix + """person""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_PersonController_getPersons2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("persons")))
  )
  private[this] lazy val controllers_PersonController_getPersons2_invoker = createInvoker(
    PersonController_2.getPersons,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "getPersons",
      Nil,
      "GET",
      this.prefix + """persons""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_RestController_getPersons3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rest")))
  )
  private[this] lazy val controllers_RestController_getPersons3_invoker = createInvoker(
    RestController_0.getPersons,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RestController",
      "getPersons",
      Nil,
      "GET",
      this.prefix + """rest""",
      """ Restful Service API For Singel CRUD""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_RestController_getCertainPerson4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rest/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RestController_getCertainPerson4_invoker = createInvoker(
    RestController_0.getCertainPerson(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RestController",
      "getCertainPerson",
      Seq(classOf[String]),
      "GET",
      this.prefix + """rest/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_PersonController_index0_route(params@_) =>
      call { 
        controllers_PersonController_index0_invoker.call(PersonController_2.index)
      }
  
    // @LINE:7
    case controllers_PersonController_addPerson1_route(params@_) =>
      call { 
        controllers_PersonController_addPerson1_invoker.call(PersonController_2.addPerson)
      }
  
    // @LINE:8
    case controllers_PersonController_getPersons2_route(params@_) =>
      call { 
        controllers_PersonController_getPersons2_invoker.call(PersonController_2.getPersons)
      }
  
    // @LINE:10
    case controllers_RestController_getPersons3_route(params@_) =>
      call { 
        controllers_RestController_getPersons3_invoker.call(RestController_0.getPersons)
      }
  
    // @LINE:11
    case controllers_RestController_getCertainPerson4_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_RestController_getCertainPerson4_invoker.call(RestController_0.getCertainPerson(name))
      }
  
    // @LINE:14
    case controllers_Assets_versioned5_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned5_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
