// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/huangfr/github/play_with_akka/conf/routes
// @DATE:Fri Aug 30 17:41:02 CST 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseRestController RestController = new controllers.ReverseRestController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePersonController PersonController = new controllers.ReversePersonController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseRestController RestController = new controllers.javascript.ReverseRestController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePersonController PersonController = new controllers.javascript.ReversePersonController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
