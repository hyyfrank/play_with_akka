package services
import javax.inject._
import play.api.libs.json.Json
import scala.concurrent.{ExecutionContext, Future}
import dal._

/**
 * 所有业务逻辑和查询结果的组合都在service层处理
 * @param repo
 */
class PeopleService @Inject()(repo: PersonRepository){
  /**
   * 返回所有列表
   * @return
   */
  def getAllPerson() = {
      repo.list()
    }
  /**
   * 通过名字获取特地person信息
   * @return
   */
    def getCertainPerson(name: String) = {
      repo.queryByName(name)
    }

  /**
   * 创建一个person
   */
  def creatPerson(name:String, age:Int) = {
    repo.create(name,age)
  }
}



