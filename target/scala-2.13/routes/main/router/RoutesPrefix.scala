// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/hyy/github/play_akka_mysql_demo/play_curd_akka/conf/routes
// @DATE:Fri Aug 02 22:34:35 CST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
