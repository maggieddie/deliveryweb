

function checkFile(fileUrl, callback) {
    var xmlHttpReq = false;
    var self = this;
        // Mozilla/Safari
    if (window.XMLHttpRequest) {
        self.xmlHttpReq = new XMLHttpRequest();
    }
    // IE
    else if (window.ActiveXObject) {
        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if(self.xmlHttpReq == null){
	alert("Your browser does not support XMLHTTPReq")
    }

    self.xmlHttpReq.open('HEAD', fileUrl, false);
    self.xmlHttpReq.onreadystatechange = function() {
        if (self.xmlHttpReq.readyState == 4) {
            if (self.xmlHttpReq.status == 200) { 
		 callback(1);
		//alert(window.rett);
           } else if (self.xmlHttpReq.status == 404) { 
		 setInterval(function(){checkFile(fileurl, callback);}, 300);
		  callback(0);
		//alert(window.rett);
            }
        }
    }
    self.xmlHttpReq.send(); 
}

 function callbackFunc(rett) {
   	     	
	window.myRet = rett
   	     }

function callbackFuncDot(rett) {
   	     	
	window.myRetDot = rett
   	     }


function ajaxCheckFile(fileUrl, callback) {  
        $.ajax({
        url: fileUrl,
 	type: "HEAD",
        dataType: 'json',
	async: false,        
	success: function () { 
              callback(1);
        },
         error: function () {  
	 	callback(0);
		setInterval(function(){ajaxCheckFile(fileUrl, callback);}, 3000);}
        });
    }  
