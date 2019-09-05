import javax.inject.Inject

import play.api.http.HttpFilters
import play.filters.gzip.GzipFilter
import play.filters.headers.SecurityHeadersFilter

class Filters @Inject() (gzip: GzipFilter) extends HttpFilters {
  println("in gzip filter and security header filter")
  val filters = Seq(gzip, SecurityHeadersFilter())
}