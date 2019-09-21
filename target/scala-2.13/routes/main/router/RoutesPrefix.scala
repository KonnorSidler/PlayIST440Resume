// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/konno/IST Projects/IST440Resume/PlayIST440Resume/conf/routes
// @DATE:Tue Sep 17 18:56:08 EDT 2019


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
