// @SOURCE:/Users/shuying/Documents/bk/wk_if/PlayPushDownOO/conf/routes
// @HASH:e3c8fcd99d6f923f51d73953ff4ae5cd65f38a53
// @DATE:Tue Oct 22 22:54:04 MDT 2013

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:9
val controllers_Application_sayHello1 = Route("GET", PathPattern(List(StaticPart("/hello"))))
                    

// @LINE:12
val controllers_Assets_at2 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    

// @LINE:13
val controllers_Assets_at3 = Route("HEAD", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    

// @LINE:16
val controllers_Application_uploadFile4 = Route("POST", PathPattern(List(StaticPart("/upload"))))
                    

// @LINE:18
val controllers_Application_config5 = Route("POST", PathPattern(List(StaticPart("/config"))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index"""),("""GET""","""/hello""","""controllers.Application.sayHello"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""HEAD""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""","""/upload""","""controllers.Application.uploadFile"""),("""POST""","""/config""","""controllers.Application.config(path:String ?= "")"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:9
case controllers_Application_sayHello1(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.sayHello, HandlerDef(this, "controllers.Application", "sayHello", Nil))
   }
}
                    

// @LINE:12
case controllers_Assets_at2(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    

// @LINE:13
case controllers_Assets_at3(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    

// @LINE:16
case controllers_Application_uploadFile4(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.uploadFile, HandlerDef(this, "controllers.Application", "uploadFile", Nil))
   }
}
                    

// @LINE:18
case controllers_Application_config5(params) => {
   call(params.fromQuery[String]("path", Some(""))) { (path) =>
        invokeHandler(_root_.controllers.Application.config(path), HandlerDef(this, "controllers.Application", "config", Seq(classOf[String])))
   }
}
                    
}
    
}
                