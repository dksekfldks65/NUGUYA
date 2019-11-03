$("#form").submit(function (e) {
      
      var url = "http:localhost/getPagingMainList"
      var page = 1;
      
      $.ajax({
        type: "GET", 
        url:url, 
        data:data,
        success: function (data) {
        	
        },
        error:function(e){
        	alert(e.responseText);
        }
      });

    });