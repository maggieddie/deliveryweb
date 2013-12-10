
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*8.99*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/main.css"))),format.raw/*9.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*10.59*/routes/*10.65*/.Assets.at("images/favicon.png"))),format.raw/*10.97*/(""""> 
		 <script src=""""),_display_(Seq[Any](/*11.18*/routes/*11.24*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*11.69*/("""" type="text/javascript"></script>
        <script src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script> 
        <script src=""""),_display_(Seq[Any](/*13.23*/routes/*13.29*/.Assets.at("javascripts/checkfile.js"))),format.raw/*13.67*/("""" type="text/javascript"></script>
        
    </head>
    <body>

        <header>
            <a href=""""),_display_(Seq[Any](/*19.23*/routes/*19.29*/.Application.index)),format.raw/*19.47*/("""">"""),_display_(Seq[Any](/*19.50*/title)),format.raw/*19.55*/("""</a>
        </header>

        <section>
            """),_display_(Seq[Any](/*23.14*/content)),format.raw/*23.21*/("""
        </section>

    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html) = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 22 22:54:06 MDT 2013
                    SOURCE: /Users/shuying/Documents/bk/wk_if/PlayPushDownOO/app/views/main.scala.html
                    HASH: d9cb3f3b9c87f34ceaf31a1047a8e3508b7ea9cd
                    MATRIX: 543->1|650->31|738->84|764->89|861->151|875->157|935->196|1026->252|1040->258|1095->292|1192->353|1207->359|1261->391|1318->412|1333->418|1400->463|1599->626|1614->632|1674->670|1817->777|1832->783|1872->801|1911->804|1938->809|2029->864|2058->871
                    LINES: 20->1|23->1|29->7|29->7|30->8|30->8|30->8|31->9|31->9|31->9|32->10|32->10|32->10|33->11|33->11|33->11|35->13|35->13|35->13|41->19|41->19|41->19|41->19|41->19|45->23|45->23
                    -- GENERATED --
                */
            