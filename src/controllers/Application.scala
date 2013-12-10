package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.Play.current
import views._
import java.io.File
import play.api.libs.json._
import org.ucombinator.playhelpers.PlayHelper
import org.ucombinator.playhelpers.AnalysisHelperThread
import org.ucombinator.utils.CommonUtils
import models.{Configs, PropertyCheckList}
 import sys.process._

object Application extends Controller {

  /**
   * Describes the hello form.
   */
  val helloForm = Form(
    tuple(
      "name" -> nonEmptyText,
      "repeat" -> number(min = 1, max = 100),
      "color" -> optional(text)
    )
  )

  /*  val configForm = Form(
      tuple(
          "k" -> optional(number),
          "gc" -> optional(text),
          "doStateCutOff" -> optional(text),
          "stateCutoff" -> number(),
          "verbose" -> optional(text),
          "doRegex" -> optional(text),
          "regex" -> nonEmptyText,
          "dochecklist" -> optional(text),
          "sms" -> checked("SMS")
          )
      )*/

  val configForm = Form(
    mapping(
      "k" -> optional(number),
      "gc" -> optional(text),
       "intra" -> optional(text),
      "doStateCutOff" -> optional(text), 
      "stateCutoff" -> number(),
       "doTimeCutOff" -> optional(text),
      "timeCutoff" -> number(), 
      "doRegex" -> optional(text),
      "regex" -> nonEmptyText,
      "dochecklist" -> optional(text),   
      "pl" -> mapping( 
       "fs" -> boolean,  
      "location" -> boolean,  
      "pic" -> boolean,  

      "deviceid" -> boolean, 

      "network" -> boolean, 
//      
//      "display" -> boolean,
      
      "thread" -> boolean,
      "ipc" -> boolean,
      "contact" -> boolean,
      "sensor" -> boolean,
      "account" -> boolean,
      "media" -> boolean,
      "sms" -> boolean 
      )
      { //(_, fs, _, loc, _, pic, _, dev, _, ntw ) => PropertyCheckList(fs,  loc,  pic, dev, ntw)  }
        ( fs,  loc,  pic, dev,  ntw,    thread, ipc, contact, sensor, account, media, sms) => 
          PropertyCheckList(fs,  loc,  pic, dev,  ntw,  thread, ipc, contact, sensor, account, media, sms)   
      }
       { pl => //Some(true, pl.filesystem, true, pl.location, true, pl.picture,true, pl.deviceid, true, pl.network)}
         Some( pl.filesystem,  
             pl.location, 
             pl.picture, 
             pl.ids, 
             pl.network,  
            // pl.display,
             pl.thread, pl.ipc, pl.contact, pl.sensor, pl.account, pl.media, pl.sms) } 
    
          )
          
          // The mapping signature doesn't match the User case class signature,
    // so we have to define custom binding/unbinding functions
    {
      // Binding: Create a User from the mapping result (ignore the second password and the accept field)
      (k, gc, intra, doStateCutOff,  stateCutoff, doTimeCutoff, timeCutoff,//verbose, 
          doRegex, regex, dochecklist , 
          propertyList 
          ) 
      => { 
         Configs(k, gc, intra, doStateCutOff, stateCutoff, doTimeCutoff, timeCutoff,//verbose, 
             doRegex, regex, dochecklist,//smsh, 
             propertyList 
             ) } 
      }
     
    {
      // Unbinding: Create the mapping values from an existing User value
      configs => {  
        Some(configs.k, configs.gc, configs.intra, configs.doStateCutOff, configs.stateCutoff, configs.doTimeCutoff, configs.timeCutoff,
            //configs.verbose, 
            configs.doRegex, configs.regex, configs.dochecklist ,
            //false, configs.smsh,
          configs.propertyList 
            ) 
      }
    }  .verifying(
      // Add an additional constraint: The username must not be taken (you could do an SQL request here)
      "Wrong regular expresion format",
      configs => !Seq("+", "*", "?", "{}").contains(configs.regex)
    )
      )

  // -- Actions

  /**
   * Home page
   */
  def index = Action {
    Ok(html.index(helloForm))
  }
  
  private def getFileName(fn: String) : String = {
    val splitted = fn.split("\\.").toList
    if(!splitted.isEmpty){
      splitted.head
    }else
      fn
  }

  /**
   * Handles the form submission.
   */
  def sayHello = Action { implicit request =>
    helloForm.bindFromRequest.fold(
      formWithErrors => BadRequest(html.index(formWithErrors)),
      {case (name, repeat, color) => Ok(html.hello(name, repeat.toInt, color))}
    )
  }
  
  

  // uploadFile -> configure
  def uploadFile = Action(parse.multipartFormData) { implicit request =>
    request.body.file("apkfile").map { picture =>
      import java.io.File
      val filename = picture.filename
      
      val originalFileName = getFileName(filename) 
      
      
      val fileNameWithoutSpaces = if(originalFileName.contains(" ")) originalFileName.replace(" ", "-") else originalFileName
      
      val contentType = picture.contentType
      println(contentType) 
   
      
      // want to build separate project file folder
      val path = "./public" + File.separator + "apks" +
      // random
        File.separator  + fileNameWithoutSpaces + scala.util.Random.nextInt.toString 
      
      val pathfolder = new File(path)
      val pathfolderD =  
        if (! pathfolder.exists()) {     
    	   pathfolder.mkdir()
      }    
      
      val newpath0 = path + File.separator + filename
      
        val newpath = if(newpath0.contains(" ")){
          val res = newpath0.replace(" ", "-")
          val strMvCmd = "mv " + newpath0 + " " + res
          strMvCmd !
          
          val strRmCmd = "rm " + newpath0
          strRmCmd
          res
          
        }else newpath0
      
      picture.ref.moveTo(new File(newpath), true)
      
      // when the updaload is OK, we want to direct to the configure page
      println("newPath: =====> " + newpath)
      println("path in updaload ------> " + path)
     // (Option[Int],Option[String], Option[String], Int, Option[String], Option[String], String)], path: String  )
      val initialPropertyCheckList = PropertyCheckList(true, true,true,true,true,true,true,true, true, true,true,true )//PropertyCheckList("false","false","false","false","false")
      val initConfig = Configs(
          Some(1), 
          Some("true"),
          Some("false"), Some("false"), 
          100,
          Some("false"), 15,
          Some("false"), "empty", 
          Some("false"), 
          initialPropertyCheckList
         /* "false", 
           "false",
          "false",
          "false","false"*/
          )
      val newform = configForm.fill(initConfig)//Some(1), Some("true"), Some("false"), 100, Some("false"), Some("false"), "empty", Some("false"), false)
      
      Ok(html.configure(newform, newpath))
      
    }.getOrElse {
      Redirect(routes.Application.index).flashing(
        "error" -> "Missing file")
    }
}
  
  case class FileInfo(path: String, info: String)
  
  // for test the analyzer finally will return something like this.
  private def jsonResult() : JsValue = {
    
    Json.toJson(
    Seq(Json.toJson(
        Map("link"->Json.toJson("/assets/apks/2.svg"),  "type" -> Json.toJson("SVG")) 
        ),
        Json.toJson(
        Map("link"->Json.toJson("/assets/apks/index.html"),  "type" -> Json.toJson("HTML")) 
        )//,
      //  Json.toJson(
       //  Map("link"->Json.toJson("/assets/apks/1.svg"),  "type" -> Json.toJson("SVG Not Ready")) 
       //  )
        )
        )
  }
  // config knows the apks folder
  // it will pass to the result displaying
  // the result call a helper,
  def config(path: String) = Action { implicit request =>
    configForm.bindFromRequest.fold(
      formWithErrors => { 
        BadRequest(formWithErrors.toString)//html.configure(formWithErrors, path))
      },
      configs => {
   //   {case (k, gc, doStateCutOff, stateCutoff, verbose, doRegex, regex, docheckList, sms) =>  
        val k = configs.k
        val gc = configs.gc
        val doIntra = configs.intra
        val doStateCutOff = configs.doStateCutOff
        val stateCutoff =configs.stateCutoff
        
        val doTimeCutoff = configs.doTimeCutoff
        val timeCutoff = configs.timeCutoff
        //val verbose = configs.verbose
        val doRegex = configs.doRegex
        val regex = configs.regex
        val docheckList = configs.dochecklist
        val properList = configs.propertyList
        
        val fs = properList.filesystem 
        val loc = properList.location
        val pic = properList.picture
        val personal = properList.ids
        val ntw = properList.network
     //  val path0 = path.replace(" ", "-")
      
        println("path*****", path)
      
          
        val at = new AnalysisHelperThread(k, gc,doIntra,  doStateCutOff, stateCutoff, doTimeCutoff, timeCutoff,//verbose, 
            path,doRegex, regex, docheckList, properList)//fs,loc,pic,personal,ntw)
            at.start()
        Ok(html.simple(CommonUtils.constrJsonResult(k, gc, doIntra, doStateCutOff, stateCutoff, doTimeCutoff, timeCutoff,path, doRegex, regex, docheckList, properList)))
        //fs,loc,pic,personal,ntw)))
      }   
     // }
    )
  }
  
}
