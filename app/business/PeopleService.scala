package business
import javax.inject._
import play.api.libs.json.Json
import scala.concurrent.{ExecutionContext, Future}
import dal._


class PeopleService @Inject()(repo: PersonRepository){
    /**
     * 获取特地person
     * @return
     */
    def getCertainPerson(name: String) = {
      repo.queryByName(name)
    }
}



