
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
object simple extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[JsValue,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(svgPath:  JsValue):play.api.templates.Html = {
        _display_ {import play.api.libs.json._  


Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Analysis result:")/*5.26*/ {_display_(Seq[Any](format.raw/*5.28*/("""  
    
	<ul   id="resultList"></ul>
	
 
	
    
	<script id="resultTemplate" type="text/x-jquery-tmpl"> 
  	    <p><li> 
  			"""),format.raw("""{"""),format.raw("""{"""),format.raw/*14.8*/("""if  $item.checkLink("link") == 1"""),format.raw("""}"""),format.raw("""}"""),format.raw/*14.42*/("""
  			  """),format.raw("""{"""),format.raw("""{"""),format.raw/*15.10*/("""if link.indexOf(".svg") !== -1  """),format.raw("""}"""),format.raw("""}"""),format.raw/*15.44*/("""
  			  	"""),format.raw("""{"""),format.raw("""{"""),format.raw/*16.11*/("""if window.myRet == 1"""),format.raw("""}"""),format.raw("""}"""),format.raw/*16.33*/("""
  					 <h2> <a href = $"""),format.raw("""{"""),format.raw/*17.26*/("""link"""),format.raw("""}"""),format.raw/*17.31*/("""  target="_blank"><b>$"""),format.raw("""{"""),format.raw/*17.54*/("""type"""),format.raw("""}"""),format.raw/*17.59*/("""</b> </a> </h2>
  				 		<ul>
  				 		<li> 
  				 			  <a href = $"""),format.raw("""{"""),format.raw/*20.25*/("""buildTarGraphPath(link)"""),format.raw("""}"""),format.raw/*20.49*/(""" target="_blank">
  				 			    <b><font size="4" color="red"> Download svg graph package </font> (svg file + embedded html file)  
  				 			    </b> 
  				 			  </a> 
  				 		</li>
  				 		<li>
  				 		
  				 		      <a href = $"""),format.raw("""{"""),format.raw/*27.28*/("""buildTarAllPath(link)"""),format.raw("""}"""),format.raw/*27.50*/(""" target="_blank">
  				 			    <b><font size="6" color="red"> ALL analysis results available! </font>
  				 			    </b> 
  				 			  </a> 
  				 		</li>
  				 		
  				 		</ul>
  				
  				 """),format.raw("""{"""),format.raw("""{"""),format.raw/*35.10*/("""else"""),format.raw("""}"""),format.raw("""}"""),format.raw/*35.16*/("""
  				 	<h2> <a href =  $"""),format.raw("""{"""),format.raw/*36.27*/("""buildTarGraphPath(link)"""),format.raw("""}"""),format.raw/*36.51*/(""" target="_blank"><b> Download Dot graph package  for now (use "dot -Tsvg somefile.dot -o somefile.svg" offline) </b>
  				 	<p> <b><font size="4" color="red">  Svg state graph download link will be available shortly too!! </font> </b></p>
  				 	 </a> </h2>
  				 		
  				 
  				 """),format.raw("""{"""),format.raw("""{"""),format.raw/*41.10*/("""/if"""),format.raw("""}"""),format.raw("""}"""),format.raw/*41.15*/("""
  			   """),format.raw("""{"""),format.raw("""{"""),format.raw/*42.11*/("""/if"""),format.raw("""}"""),format.raw("""}"""),format.raw/*42.16*/("""
  			    """),format.raw("""{"""),format.raw("""{"""),format.raw/*43.12*/("""if  link.indexOf(".txt") !== -1 ||  link.indexOf(".html") !== -1 """),format.raw("""}"""),format.raw("""}"""),format.raw/*43.79*/("""
  	  	 			<h2> <a href = $"""),format.raw("""{"""),format.raw/*44.28*/("""link"""),format.raw("""}"""),format.raw/*44.33*/("""  target="_blank"><b>$"""),format.raw("""{"""),format.raw/*44.56*/("""type"""),format.raw("""}"""),format.raw/*44.61*/("""</b> </a> </h2>
   	 			"""),format.raw("""{"""),format.raw("""{"""),format.raw/*45.11*/("""/if"""),format.raw("""}"""),format.raw("""}"""),format.raw/*45.16*/("""
  			"""),format.raw("""{"""),format.raw("""{"""),format.raw/*46.8*/("""else"""),format.raw("""}"""),format.raw("""}"""),format.raw/*46.14*/("""
    		<b>$"""),format.raw("""{"""),format.raw/*47.12*/("""type"""),format.raw("""}"""),format.raw/*47.17*/(""" </b> 
    		
    		<p> You can try the following links manually if no links shown after time bound you set for the analyzer </p>
    		 <ul > 
				<li>
				  All results: <em>homepage.e.g. http://pegasus.cs.utah.edu:9090</em>$"""),format.raw("""{"""),format.raw/*52.76*/("""buildTarAllPath(link)"""),format.raw("""}"""),format.raw/*52.98*/(""" (this can not be available due to the graph file generation)  </b>  
				</li>
				<li>
				 Text reports:  <em>homepage.e.g. http://pegasus.cs.utah.edu:9090</em>$"""),format.raw("""{"""),format.raw/*55.77*/("""buildTarReportPath(link)"""),format.raw("""}"""),format.raw/*55.102*/(""" (all files except graphs)
				</li>
			</ul>
				
  			"""),format.raw("""{"""),format.raw("""{"""),format.raw/*59.8*/("""/if"""),format.raw("""}"""),format.raw("""}"""),format.raw/*59.13*/(""" 
  		</li> </p>
  		
	</script>
	
	
	 
	<script type="text/javascript"> 
   	     var results = JSON.parse('"""),_display_(Seq[Any](/*67.37*/svgPath)),format.raw/*67.44*/("""'.replace(/&quot;/g,'"'));    

   		 function getDotLink(svgLink) """),format.raw("""{"""),format.raw/*69.37*/("""
   		 	var svgL = svgLink.length;
   		 	var svgPathIndex = svgL - 3;
   		 	var dotPath = svgLink.substring(0,svgPathIndex) +"dot";
   		 	return dotPath;
   		 """),format.raw("""}"""),format.raw/*74.8*/("""
   		 
   		 function buildTarGraphPath(svgPath) """),format.raw("""{"""),format.raw/*76.44*/("""
   			var l1 = svgPath.split("/");
   			var l1len = l1.length;
   			var l2 = l1.slice(0, l1len-1);
   			var l3 = l2.map(function(e) """),format.raw("""{"""),format.raw/*80.36*/("""return e+"/";"""),format.raw("""}"""),format.raw/*80.50*/(""");
   			var res = "";
   			l3.forEach(function(e) """),format.raw("""{"""),format.raw/*82.31*/("""return res = res + e"""),format.raw("""}"""),format.raw/*82.52*/(""");
   			 
   				return res + "graph.tar.gz";"""),format.raw("""}"""),format.raw/*84.37*/("""
   				
   		function buildTarAllPath(svgPath) """),format.raw("""{"""),format.raw/*86.41*/("""
   			var l1 = svgPath.split("/");
   			var l1len = l1.length;
   			var l2 = l1.slice(0, l1len-2);
   			var l3 = l2.map(function(e) """),format.raw("""{"""),format.raw/*90.36*/("""return e+"/";"""),format.raw("""}"""),format.raw/*90.50*/(""");
   			var res = "";
   			l3.forEach(function(e) """),format.raw("""{"""),format.raw/*92.31*/("""return res = res + e"""),format.raw("""}"""),format.raw/*92.52*/(""");
   			 
   				return res + "all.tar.gz";"""),format.raw("""}"""),format.raw/*94.35*/("""	
   				
   		 function buildTarReportPath(svgPath) """),format.raw("""{"""),format.raw/*96.45*/("""
   			var l1 = svgPath.split("/");
   			var l1len = l1.length;
   			var l2 = l1.slice(0, l1len-2);
   			var l3 = l2.map(function(e) """),format.raw("""{"""),format.raw/*100.36*/("""return e+"/";"""),format.raw("""}"""),format.raw/*100.50*/(""");
   			var res = "";
   			l3.forEach(function(e) """),format.raw("""{"""),format.raw/*102.31*/("""return res = res + e"""),format.raw("""}"""),format.raw/*102.52*/(""");
   			 
   				return res + "reports/" + "reports.tar.gz";"""),format.raw("""}"""),format.raw/*104.52*/("""	
   			 
   		 
     	 setInterval("refreshPage();", 2000);  
     
      function refreshPage() """),format.raw("""{"""),format.raw/*109.31*/("""
         	$('ul').empty();
   	      	$("#resultTemplate").tmpl(results, """),format.raw("""{"""),format.raw/*111.48*/("""
    			checkLink : function(key) """),format.raw("""{"""),format.raw/*112.35*/("""
     			 var linkRes = this.data[key]; 
     			 var dotLinkRes = linkRes.replace(".svg", ".dot")
     			 ajaxCheckFile(linkRes, callbackFunc);  
     			 ajaxCheckFile(dotLinkRes, callbackFuncDot);  
     		 	return window.myRet || window.myRetDot;
   				 """),format.raw("""}"""),format.raw/*118.10*/("""
			"""),format.raw("""}"""),format.raw/*119.5*/(""").appendTo("#resultList" );  
 	         """),format.raw("""}"""),format.raw/*120.13*/("""
 	         
 	         
	</script> 
  
  <div>
  </br>
  </br>
  <footer>
  <p> 
  <b>Note</b>
  </p>
  
  <ol>
  <li> 
  Analysis takes some moments, results will be presented in the page shortly. <b><em><font size="3" color="red"> Don't close this window! </font> </em></b> 
  </li>
  <li>
  
  There are five result links will be presented to you. Clicking result will bring you to a new tab or a window according to your browser settings.
  (<b><em><font size="2" color="red"> In case there are no links shown, you can manually try static links for reports or whole analysis package are presented to you any time. </font> </em>)
  <ol>
  	<li><b>Analysis Statistics:</b> Analysis runtime, and values for precision metrics (points-to, exceptions)</li>
    <li><b>Permission Report:</b> It shows the permissions that the app has requested, the permissions that the app has reached, and discrepancy between the two sets. </li>
  	<li><b>Security Report in text:</b> It shows suspicious lines of code, in the format of <em>"bytecode-statement&#64;&#64;&#64;class-name&#36;&#36;method-name&#58;&#58;&#58;line-number"</em>, entry points, and security categories. </li>
  	<li><b>Heat Map:</b> Rough report for profiling the analysis </li>
  	<li><b>Analysis State Graph:</b> It virtualizes  abstract execution of pushdown-based model for Dalvik bytode. 
  	There are two kinds of graph links provided: SVG and Dot graph. DOT format is the raw graph generated by analysis, it is then converted to SVG graph.
  	SVG format graph can show you the flows of sensitive data by coloring related state nodes, it also allows you to  inspect details of any state by clicking the state node. 
  	 But in case it takes long to generate, you can always download the dot graph file and do the convertion offline by adding the homepage link before the the relative path presented, e.g. <em>/assets/apks/SysMon596173159/SysMon/graphs/graph-1-pdcfa-gc-lra.dot</em>
     </li>
    
  </ol>
  </li>
  
 
  </ol>
  </footer>
  </div>
  
""")))})))}
    }
    
    def render(svgPath:JsValue) = apply(svgPath)
    
    def f:((JsValue) => play.api.templates.Html) = (svgPath) => apply(svgPath)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 22 22:54:06 MDT 2013
                    SOURCE: /Users/shuying/Documents/bk/wk_if/PlayPushDownOO/app/views/simple.scala.html
                    HASH: 3384a5f47daa1d604c27e25af2c01cfe7e23eadc
                    MATRIX: 541->1|667->20|695->53|731->55|763->79|802->81|995->209|1095->243|1171->253|1271->287|1348->298|1436->320|1509->346|1561->351|1631->374|1683->379|1799->448|1870->472|2153->708|2222->730|2485->927|2557->933|2631->960|2702->984|3055->1271|3126->1276|3203->1287|3274->1292|3352->1304|3485->1371|3560->1399|3612->1404|3682->1427|3734->1432|3826->1458|3897->1463|3970->1471|4042->1477|4101->1489|4153->1494|4428->1722|4497->1744|4709->1909|4782->1934|4905->1992|4976->1997|5122->2107|5151->2114|5266->2182|5476->2346|5574->2397|5758->2534|5819->2548|5919->2601|5987->2622|6081->2669|6177->2718|6361->2855|6422->2869|6522->2922|6590->2943|6682->2988|6783->3042|6968->3179|7030->3193|7131->3246|7200->3267|7310->3329|7457->3428|7580->3503|7663->3538|7972->3799|8024->3804|8114->3846
                    LINES: 20->1|24->1|26->4|27->5|27->5|27->5|36->14|36->14|37->15|37->15|38->16|38->16|39->17|39->17|39->17|39->17|42->20|42->20|49->27|49->27|57->35|57->35|58->36|58->36|63->41|63->41|64->42|64->42|65->43|65->43|66->44|66->44|66->44|66->44|67->45|67->45|68->46|68->46|69->47|69->47|74->52|74->52|77->55|77->55|81->59|81->59|89->67|89->67|91->69|96->74|98->76|102->80|102->80|104->82|104->82|106->84|108->86|112->90|112->90|114->92|114->92|116->94|118->96|122->100|122->100|124->102|124->102|126->104|131->109|133->111|134->112|140->118|141->119|142->120
                    -- GENERATED --
                */
            