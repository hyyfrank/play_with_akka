package business
import javax.inject._
import dal._
import play.api.libs.json.Json
import scala.concurrent.{ExecutionContext, Future}

trait business (repo: PersonRepository)(implicit ec: ExecutionContext){
    /**
     * 获取特地person
     * @return
     */
    def getCertainPerson(name: String) = {
      repo.queryByName(name)
    }
}



