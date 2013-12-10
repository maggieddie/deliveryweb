
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
object configure extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Configs],String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(configForm: Form[Configs], path:String):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*3.1*/("""

"""),_display_(Seq[Any](/*5.2*/main(title = "Anadroid: a static analyzer for Android malware detection")/*5.75*/ {_display_(Seq[Any](format.raw/*5.77*/(""" 
	 
    """),_display_(Seq[Any](/*7.6*/helper/*7.12*/.form(action = routes.Application.config(path))/*7.59*/ {_display_(Seq[Any](format.raw/*7.61*/("""
    
		<fieldset>
              <legend> Configure TAPAS </legend>
        	"""),_display_(Seq[Any](/*11.11*/select(
            	 configForm("k"), 
           		 options = options(
                "0" -> "0",
                "1" -> "1",
                "2" -> "2"
            ),
            '_default -> "--- Choose k value ---",
            '_label -> "Context-sensitivity K	", 
            '_showConstraints -> false 
        	))),format.raw/*21.11*/(""" 
        
         	"""),_display_(Seq[Any](/*23.12*/select(
           	 	 configForm("gc"), 
           	 	options = options(
              	  "true" -> "True",
             	   "false" -> "False"
           		 ),
            '_label -> "Abstract Garbage Collection?	",
            '_default -> "--- Turn on AGC ---" 
        	))),format.raw/*31.11*/(""" 
        	
        	"""),_display_(Seq[Any](/*33.11*/select(
           	 	 configForm("intra"), 
           	 	options = options(
           	 	  "false" -> "False",
              	  "true" -> "True"
           		 ),
            '_label -> "Intra-procedural?	",
            '_default -> "--- Turn on intra-procedural analysis ---" 
        	))),format.raw/*41.11*/(""" 
        	
        	
         	"""),_display_(Seq[Any](/*44.12*/select(
           	 	 configForm("doStateCutOff"), 
           	 	options = options(
              	  "true" -> "Yes",
             	   "false" -> "No"
           		 ),
           	 '_id -> "turnOnStateCutOff",
            '_label -> "Cut off states after number?	",
            '_default -> "--- Turn on number cutoff ---" 
        	))),format.raw/*53.11*/("""  
         	 
  			 """),_display_(Seq[Any](/*55.8*/inputText(
           			 configForm("stateCutoff"),
           			 '_label -> "Cut off states after number?	", 
           			 '_id -> "stateNO",
           			 'size -> 15, 
           			 'value -> 10,
           			 'placeholder -> 10000,
           			 '_showConstraints -> false
        	 ))),format.raw/*63.12*/("""
        	 
        	 """),_display_(Seq[Any](/*65.12*/select(
           	 	 configForm("doTimeCutOff"), 
           	 	options = options(
              	  "true" -> "Yes",
             	   "false" -> "No"
           		 ),
           	 '_id -> "turnOnTimeCutOff",
            '_label -> "Cut off states after some time? ",
            '_default -> "--- Turn on time cutoff ---" 
        	))),format.raw/*74.11*/("""  
         	 
  			 """),_display_(Seq[Any](/*76.8*/select(
           	 	 configForm("timeCutoff"), 
           	 	options = options(
              	  "5" -> "< 5 min",
             	   "10" -> "< 10 min",
             	   "20" -> "< 20 min",
             	   "30" -> "< 30 min",
             	   "50" -> "< 50 min",
             	   "90" -> "< 1.5 h",
             	   "120" -> "< 2 h" 
           		 ),
           	 '_id -> "timeCutoff",
            '_label -> "Cut off states after: "
        	))),format.raw/*89.11*/("""  
			 
		
        	
        	
        	"""),_display_(Seq[Any](/*94.11*/select(
           	 	 configForm("doRegex"), 
           	 	options = options(
              	  "true" -> "Yes",
             	   "false" -> "No"
           		 ),
           	 '_id -> "doRegex",
            '_label -> "Regex to highlight states?	",
            '_default -> "--- Turn on regex highlighting  ---" 
        	))),format.raw/*103.11*/("""  
        	
        	"""),_display_(Seq[Any](/*105.11*/inputText(
           			 configForm("regex"),
           			 '_label -> "Regex to highlight state", 
           			 '_id -> "regexStr",
           			 '_help-> "Input Regular expression to match states: e.g. .*java/io/.*|android.os/.*|.*startActivity.*", 
           			 'value -> "", '_error -> configForm.error("regex") ,
           			 '_showConstraints -> false
        	 ))),format.raw/*112.12*/(""" 
        	 
        	 
        	 """),_display_(Seq[Any](/*115.12*/select(
           	 	 configForm("dochecklist"), 
           	 	options = options(
              	  "true" -> "Yes",
             	   "false" -> "No"
           		 ),
           	 '_id -> "doCheckList",
            '_label -> "Check list to match states?",
            '_default -> "--- Turn on checkList highlighting  ---" 
        	))),format.raw/*124.11*/("""
        	
         
        	
        </fieldset>	 
        
        <fieldset> 
        	 
        	 """),_display_(Seq[Any](/*132.12*/checkbox(
                configForm("pl.fs"), 
                '_id -> "fs",
                '_label -> "File System", '_text -> "(file system, reflection, sdcard)",
                '_showConstraints -> false
            ))),format.raw/*137.14*/("""
            
            
        	 
        	 """),_display_(Seq[Any](/*141.12*/checkbox(
                configForm("pl.location"), '_text -> "(GPS location, reflection)",
                '_id -> "location",
                '_label -> "Location", 
                '_showConstraints -> false
            ))),format.raw/*146.14*/("""
            
           
        	 
        	 """),_display_(Seq[Any](/*150.12*/checkbox(
                configForm("pl.pic"), '_text -> "(pictures, reflection)",
                '_id -> "pic",
                '_label -> "Picture", 
                '_showConstraints -> false
            ))),format.raw/*155.14*/("""
            
        	 
        	 
        	 """),_display_(Seq[Any](/*159.12*/checkbox(
                configForm("pl.deviceid"), 
                '_id -> "deviceid", '_text -> "( deviceid, serialid,reflection)",
                '_label -> "IDs", 
                '_showConstraints -> false
            ))),format.raw/*164.14*/("""
            
           
        	 
        	  """),_display_(Seq[Any](/*168.13*/checkbox(
                configForm("pl.network"), 
                '_id -> "network", '_text -> "(network,reflection)",
                '_label -> "Network", 
                '_showConstraints -> false
            ))),format.raw/*173.14*/("""
          
        	 
        	 
            
             """),_display_(Seq[Any](/*178.15*/checkbox(
                configForm("pl.thread"), 
                '_id -> "thread",
                '_label -> "Thread", 
                '_showConstraints -> false
            ))),format.raw/*183.14*/("""
            
            
        	 
        	  """),_display_(Seq[Any](/*187.13*/checkbox(
                configForm("pl.ipc"), '_text -> "(intent,reflection)",
                '_id -> "ipc",
                '_label -> "IPC", 
                '_showConstraints -> false
            ))),format.raw/*192.14*/("""
            
            
        	 
        	   """),_display_(Seq[Any](/*196.14*/checkbox(
                configForm("pl.contact"), 
                '_id -> "contact",
                '_label -> "Contact", 
                '_showConstraints -> false
            ))),format.raw/*201.14*/("""
            
            
        	  """),_display_(Seq[Any](/*204.13*/checkbox(
                configForm("pl.sensor"), 
                '_id -> "sensor",
                '_label -> "Sensor", 
                '_showConstraints -> false
            ))),format.raw/*209.14*/("""
            
             
        	 
        	   """),_display_(Seq[Any](/*213.14*/checkbox(
                configForm("pl.account"), 
                '_id -> "account",
                '_label -> "Account", 
                '_showConstraints -> false
            ))),format.raw/*218.14*/("""
            
             """),_display_(Seq[Any](/*220.15*/checkbox(
                configForm("pl.media"), '_text -> "(voice, multimedia,reflection)",
                '_id -> "media",
                '_label -> "Media", 
                '_showConstraints -> false
            ))),format.raw/*225.14*/("""
            
             """),_display_(Seq[Any](/*227.15*/checkbox(
                configForm("pl.sms"), 
                '_id -> "sms",
                '_label -> "SMS", 
                '_showConstraints -> false
            ))),format.raw/*232.14*/(""" 
         
        </fieldset>
       

        <div class="buttons">
           
            <input type="submit" id="submit" value="Start Analysis">
        </div>
        <div>
         </br>
        <p> <b> How to use:</b> </p>
          <footer>
          	<ol>
          	<li> <b>Context sensitivity k</b>: Last k call sites (0 to up to 2); </li>
          	<li> <b>Abstract garbage collection</b>: Garbage collect unreachable abstract addresses, can boost precision and performance.
          		 Live register analysis is also turned on when this option is on. It is recommend to turn this option.
          	</li>
          	<li>
          		<b> Intra-procedural? </b>: It is specialized to do intra-procedural analysis in the framework. 
          		<b>Turning intra-procedural analysis can be really fast but very imprecise!!! (It is actually used for a subproject-Intent fuzzer)</b>
          		    
          	</li>
          	<li> <b>Cut off states after number?</b>: Stop analyzer after some number of explored states. When this option is on, you will need to input a number in the input text field appeared next line; 
          	</li>
          	<li> <b>Cut off states after some time?</b>: Stop analyzer after after some minutes or hours. When this option is on, you are required to select the upper bound time limit in the selector appeared in the next line with the default value 5 minutes;</li>
          	<li> <b>Regex to highlight state?</b>: The regular expression to search the analysis results, matched states will be highlighted in the color number 8:
          	 
                   </br> <img src="./assets/images/custom-color.png" alt="Color 8" width="840" height="60">
                </br> If this option is off, state graph will use default color scheme to color states: 2 for normal states, 4 for tainted states, red for source or sinks states. 
                </br> <img src="./assets/images/default.png" alt="deafult" width="840" height="60"> 
          	 </li>
          	<li><b>Check list to match states?</b>: Similar to regex matching, this is handy to match analysis result with set of specific kinds of categories. 
          	     A list of checkboxes will be popped following the option. To reduce confusion, it will use the same color scheme as regex matching do (color number 8 in rdpu8) to color matched states. Otherwise, default color scheme will apply;
          	 </li>    
          	 <li>
          	 <b>Start Anadroid: start analysis.</b>
          	 </li>
          	</ol>
                
                <p> <b> Additional note:</b> </p>
                If the form is filled incorrectly, errors will be presented in the returning page. 
                Error message will be in the last line of the page. Contact liangsy&#64;cs&#46;utah&#46;edu for any questions.
            </footer>
            </div>

    """)))})),format.raw/*278.6*/(""" 
	 
	  <script>
        $(document).ready(function ()"""),format.raw("""{"""),format.raw/*281.39*/("""
        $("#stateNO").hide(); 
         $("#timeCutoff").hide();
        $("#regexStr").hide(); 
         $("#fs").hide();
 		$("#location").hide();
		$("#pic").hide();
 		$("#deviceid").hide();
		$("#network").hide(); 
 		 
		 $("#thread").hide(); 
		$("#ipc").hide();
 		$("#contact").hide();
		$("#sensor").hide();
 		$("#account").hide();
 		$("#media").hide();
 		$("#sms").hide();
		 
         
         $("#turnOnStateCutOff").change(function() """),format.raw("""{"""),format.raw/*300.53*/("""
                 
                if ( $(this).find('option:selected').val() == "true") """),format.raw("""{"""),format.raw/*302.72*/("""
                    $("#stateNO").show();
                """),format.raw("""}"""),format.raw/*304.18*/("""else"""),format.raw("""{"""),format.raw/*304.23*/("""
                    $("#stateNO").hide();
                    $("#stateNO").val( 10)
                """),format.raw("""}"""),format.raw/*307.18*/(""" 
            """),format.raw("""}"""),format.raw/*308.14*/(""");
            
            $("#turnOnTimeCutOff").change(function() """),format.raw("""{"""),format.raw/*310.55*/("""
                 
                if ( $(this).find('option:selected').val() == "true") """),format.raw("""{"""),format.raw/*312.72*/("""
                    $("#timeCutoff").show();
                """),format.raw("""}"""),format.raw/*314.18*/("""else"""),format.raw("""{"""),format.raw/*314.23*/("""
                    $("#timeCutoff").hide(); 
                """),format.raw("""}"""),format.raw/*316.18*/(""" 
            """),format.raw("""}"""),format.raw/*317.14*/(""");
            
              $("#doRegex").change(function() """),format.raw("""{"""),format.raw/*319.48*/(""" 
                if ( $(this).find('option:selected').val() == "true") """),format.raw("""{"""),format.raw/*320.72*/("""
                    $("#regexStr").show();
                """),format.raw("""}"""),format.raw/*322.18*/("""else"""),format.raw("""{"""),format.raw/*322.23*/("""
                    $("#regexStr").hide();
                    $("#regexStr").val("");
                """),format.raw("""}"""),format.raw/*325.18*/(""" 
            """),format.raw("""}"""),format.raw/*326.14*/(""");
            $("#doCheckList").change(function() """),format.raw("""{"""),format.raw/*327.50*/(""" 
                if ( $(this).find('option:selected').val() == "true") """),format.raw("""{"""),format.raw/*328.72*/("""
                   
                    $("#fs").show();
                    $("#location").show();
                    $("#pic").show();
                    $("#deviceid").show();
                    $("#network").show(); 
        
 					 
					 $("#thread").show(); 
					$("#ipc").show();
 					$("#contact").show();
					$("#sensor").show();
 					$("#account").show();
 					$("#media").show();
 					$("#sms").show();
                      
                    
                """),format.raw("""}"""),format.raw/*346.18*/("""else"""),format.raw("""{"""),format.raw/*346.23*/("""
                  //  $("#sms").hide(); 
                    $("#fs").hide(); 
                     $("#location").hide(); 
                    $("#pic").hide(); 
                    $("#deviceid").hide(); 
                    $("#network").hide(); 
                    
                    
					 $("#thread").hide(); 
					$("#ipc").hide();
 					$("#contact").hide();
					$("#sensor").hide();
 					$("#account").hide();
 					$("#media").hide();
 					$("#sms").hide();
                """),format.raw("""}"""),format.raw/*362.18*/(""" 
            """),format.raw("""}"""),format.raw/*363.14*/("""); 
     
        """),format.raw("""}"""),format.raw/*365.10*/(""");
        
      
    </script>
 
    

""")))})),format.raw/*372.2*/("""
"""))}
    }
    
    def render(configForm:Form[Configs],path:String) = apply(configForm,path)
    
    def f:((Form[Configs],String) => play.api.templates.Html) = (configForm,path) => apply(configForm,path)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 22 22:54:06 MDT 2013
                    SOURCE: /Users/shuying/Documents/bk/wk_if/PlayPushDownOO/app/views/configure.scala.html
                    HASH: 80cbd2bdc29a61764c017e2a350417686e986a7b
                    MATRIX: 557->1|690->41|717->59|754->62|835->135|874->137|918->147|932->153|987->200|1026->202|1140->280|1484->602|1542->624|1841->901|1899->923|2211->1213|2280->1246|2638->1582|2695->1604|3013->1900|3072->1923|3429->2258|3486->2280|3955->2727|4032->2768|4379->3092|4439->3115|4840->3493|4912->3528|5271->3864|5412->3968|5658->4191|5744->4240|5992->4465|6077->4513|6310->4723|6394->4770|6644->4997|6730->5046|6970->5263|7068->5324|7271->5504|7358->5554|7584->5757|7672->5808|7878->5991|7954->6030|8157->6210|8246->6262|8452->6445|8517->6473|8760->6693|8825->6721|9019->6892|11921->9762|12024->9817|12526->10271|12664->10361|12772->10421|12825->10426|12976->10529|13039->10544|13157->10614|13295->10704|13406->10767|13459->10772|13571->10836|13634->10851|13745->10914|13866->10987|13975->11048|14028->11053|14181->11158|14244->11173|14344->11225|14465->11298|14999->11784|15052->11789|15593->12282|15656->12297|15723->12316|15797->12358
                    LINES: 20->1|24->1|25->3|27->5|27->5|27->5|29->7|29->7|29->7|29->7|33->11|43->21|45->23|53->31|55->33|63->41|66->44|75->53|77->55|85->63|87->65|96->74|98->76|111->89|116->94|125->103|127->105|134->112|137->115|146->124|154->132|159->137|163->141|168->146|172->150|177->155|181->159|186->164|190->168|195->173|200->178|205->183|209->187|214->192|218->196|223->201|226->204|231->209|235->213|240->218|242->220|247->225|249->227|254->232|300->278|303->281|322->300|324->302|326->304|326->304|329->307|330->308|332->310|334->312|336->314|336->314|338->316|339->317|341->319|342->320|344->322|344->322|347->325|348->326|349->327|350->328|368->346|368->346|384->362|385->363|387->365|394->372
                    -- GENERATED --
                */
            