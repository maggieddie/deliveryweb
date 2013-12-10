// @SOURCE:/Users/shuying/Documents/bk/wk_if/PlayPushDownOO/conf/routes
// @HASH:e3c8fcd99d6f923f51d73953ff4ae5cd65f38a53
// @DATE:Tue Oct 22 22:54:04 MDT 2013

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:18
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers {

// @LINE:18
// @LINE:16
// @LINE:9
// @LINE:6
class ReverseApplication {
    


 
// @LINE:16
def uploadFile() = {
   Call("POST", "/upload")
}
                                                        
 
// @LINE:18
def config(path:String = "") = {
   Call("POST", "/config" + queryString(List(if(path == "") None else Some(implicitly[QueryStringBindable[String]].unbind("path", path)))))
}
                                                        
 
// @LINE:9
def sayHello() = {
   Call("GET", "/hello")
}
                                                        
 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        

                      
    
}
                            

// @LINE:13
// @LINE:12
class ReverseAssets {
    


 
// @LINE:13
// @LINE:12
def at(file:String) = {
   (file) match {
// @LINE:12
case (file) if true => Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                                
// @LINE:13
case (file) if true => Call("HEAD", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                                    
   }
}
                                                        

                      
    
}
                            
}
                    


// @LINE:18
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:18
// @LINE:16
// @LINE:9
// @LINE:6
class ReverseApplication {
    


 
// @LINE:16
def uploadFile = JavascriptReverseRoute(
   "controllers.Application.uploadFile",
   """
      function() {
      return _wA({method:"POST", url:"/upload"})
      }
   """
)
                                                        
 
// @LINE:18
def config = JavascriptReverseRoute(
   "controllers.Application.config",
   """
      function(path) {
      return _wA({method:"POST", url:"/config" + _qS([(path == null ? """ +  implicitly[JavascriptLitteral[String]].to("") + """ : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("path", path))])})
      }
   """
)
                                                        
 
// @LINE:9
def sayHello = JavascriptReverseRoute(
   "controllers.Application.sayHello",
   """
      function() {
      return _wA({method:"GET", url:"/hello"})
      }
   """
)
                                                        
 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:13
// @LINE:12
class ReverseAssets {
    


 
// @LINE:13
// @LINE:12
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      if (true) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      if (true) {
      return _wA({method:"HEAD", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:18
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:18
// @LINE:16
// @LINE:9
// @LINE:6
class ReverseApplication {
    


 
// @LINE:16
def uploadFile() = new play.api.mvc.HandlerRef(
   controllers.Application.uploadFile(), HandlerDef(this, "controllers.Application", "uploadFile", Seq())
)
                              
 
// @LINE:18
def config(path:String) = new play.api.mvc.HandlerRef(
   controllers.Application.config(path), HandlerDef(this, "controllers.Application", "config", Seq(classOf[String]))
)
                              
 
// @LINE:9
def sayHello() = new play.api.mvc.HandlerRef(
   controllers.Application.sayHello(), HandlerDef(this, "controllers.Application", "sayHello", Seq())
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:13
// @LINE:12
class ReverseAssets {
    


 
// @LINE:12
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                