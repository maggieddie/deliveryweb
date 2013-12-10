
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
import play.api.libs.json.JsValue
/**/
object hello extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Int,Option[String],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(name: String, repeat: Int, color: Option[String]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.52*/("""

"""),_display_(Seq[Any](/*3.2*/main("Here is the result:")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""

    <ul style="color: """),_display_(Seq[Any](/*5.24*/color/*5.29*/.getOrElse("inherited"))),format.raw/*5.52*/("""">
        """),_display_(Seq[Any](/*6.10*/for(_ <- 1 to repeat) yield /*6.31*/ {_display_(Seq[Any](format.raw/*6.33*/("""
            <li>Hello """),_display_(Seq[Any](/*7.24*/name)),format.raw/*7.28*/("""!</li>
        """)))})),format.raw/*8.10*/("""
    </ul>

    <p class="buttons">
        <a href=""""),_display_(Seq[Any](/*12.19*/routes/*12.25*/.Application.index)),format.raw/*12.43*/("""">Back to the form</a>
    </p>
""")))})),format.raw/*14.2*/("""
"""))}
    }
    
    def render(name:String,repeat:Int,color:Option[String]) = apply(name,repeat,color)
    
    def f:((String,Int,Option[String]) => play.api.templates.Html) = (name,repeat,color) => apply(name,repeat,color)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 22 22:54:06 MDT 2013
                    SOURCE: /Users/shuying/Documents/bk/wk_if/PlayPushDownOO/app/views/hello.scala.html
                    HASH: 29e1db9140e9ec2bc6a9b1f392600f8dfa8ddac0
                    MATRIX: 558->1|685->51|722->54|757->81|796->83|856->108|869->113|913->136|960->148|996->169|1035->171|1094->195|1119->199|1166->215|1256->269|1271->275|1311->293|1375->326
                    LINES: 20->1|23->1|25->3|25->3|25->3|27->5|27->5|27->5|28->6|28->6|28->6|29->7|29->7|30->8|34->12|34->12|34->12|36->14
                    -- GENERATED --
                */
            