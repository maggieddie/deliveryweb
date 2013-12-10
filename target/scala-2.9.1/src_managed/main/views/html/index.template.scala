
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[scala.Tuple3[String, Int, Option[String]]],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(helloForm: Form[(String,Int,Option[String])]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.48*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "Anadroid: a static analyzer for Android malware detection")/*5.75*/ {_display_(Seq[Any](format.raw/*5.77*/("""

    <h3> Upload an apk file :</h3>

	"""),_display_(Seq[Any](/*9.3*/form(action = routes.Application.uploadFile, 'enctype -> "multipart/form-data")/*9.82*/ {_display_(Seq[Any](format.raw/*9.84*/("""
    
    <input type="file" name="apkfile">
    
    <p class="button">
        <input type="submit" value="Submit">
    </p>
    
    </br>
    </br>
    
    <footer>
    <ul>
    <li> Google Chrome is recommended, version 26.0.1410.43. (it is our testing environment),  Safari works, you can try Firefox. </li>
    <li> <p> Please enable Javascript to use Anadroid. </p> </li>
    
    </ul>
    
    </footer>
""")))})),format.raw/*28.2*/("""
    

""")))})),format.raw/*31.2*/("""
"""))}
    }
    
    def render(helloForm:Form[scala.Tuple3[String, Int, Option[String]]]) = apply(helloForm)
    
    def f:((Form[scala.Tuple3[String, Int, Option[String]]]) => play.api.templates.Html) = (helloForm) => apply(helloForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 22 22:54:06 MDT 2013
                    SOURCE: /Users/shuying/Documents/bk/wk_if/PlayPushDownOO/app/views/index.scala.html
                    HASH: ea91f8572e963cd84c2540ffadfcb7d48e771c96
                    MATRIX: 580->1|719->47|747->66|783->68|864->141|903->143|977->183|1064->262|1103->264|1550->680|1589->688
                    LINES: 20->1|24->1|26->4|27->5|27->5|27->5|31->9|31->9|31->9|50->28|53->31
                    -- GENERATED --
                */
            