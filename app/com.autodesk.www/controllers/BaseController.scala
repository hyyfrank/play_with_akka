//import jdk.nashorn.internal.codegen.CompilerConstants.Call

//abstract class BaseController[T] extends Nothing {
//  def onFail(form: Nothing): Nothing
//
//  def onSuccess(elem: T): CompilerConstants.Call
//
//  def submit(clazz: Class[T]): Nothing = {
//    val boundForm = form(clazz).bindFromRequest
//    if (boundForm.hasErrors) badRequest(onFail(boundForm))
//    else redirect(onSuccess(boundForm.get))
//  }
//
//  def onGet():Nothing
//  def onPost():Nothing
//}