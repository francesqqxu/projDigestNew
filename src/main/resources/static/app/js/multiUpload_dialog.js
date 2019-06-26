/**
 * 
 */

$(function(){
	
	console.log("multiUpload.js");
	
		
	$('#openFileUpload').linkbutton({
		iconCls: 'icon-add'
	});
	
	$('#openFileUpload').click(function(){
		$('#fileUpload').dialog('open');
	});
	
	$('#fileUpload').dialog({
		  resizable: false,
		  height : 140,
	      width :  350,
	      title: '文件上传',
	      modal: true,
	      closed: true,
	      
	     
	      buttons: [{
	    	  text:'确定',
	    	  iconCls:'icon-ok',
	    	  handler:function(){
	    		  $.ajaxFileUpload({
	    			 url:'multiUploading',
	    			 secureuri:false,
	    			 fileElementId:'multiFileUpload',
	    			 datatype:'json',
	    			 
	    			 success: function(data,status){
	    				 alert(data);
	    			 },
	    			 error: function(data,status,e){
	    				 alert(e);
	    			 }
	    			
	    		  });
	    		  
	    	  }
	    	  
	      },  	  
    	  {
            text: '取消',
	        iconCls: 'icon-cancel',
	        handler: function() {
	          $("#fileUpload").dialog("close");
	      }
	      }],
	      
	      onClose:function(){
	    	  $('#fileUpload').dialog('close');
	      }
	       
	    });
		
		 
		 
});
	
	
