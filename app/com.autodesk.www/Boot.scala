package com.autodesk.www

import play.api.ApplicationLoader.Context
import play.api.{Application, ApplicationLoader, LoggerConfigurator}

import com.autodesk.www.basic.play.ServiceBoot

class Boot {

}



class MyApplicationLoader extends ApplicationLoader {
  override def load(context: Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach { _.configure(context.environment) }
    new ServiceBoot(context).application
  }
}
