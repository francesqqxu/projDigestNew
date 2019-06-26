/**
 * 
 */

$(function(){
	
	console.log("multiUpload");
	
	$('#btnOpenDialog').click(function(){
		$('#dg_fileUpload').dialog('open').dialog('setTitle','导入项目摘要信息');
	});
	
	$('#multiFileUpload_submit').click(function(){
		ajaxFileUpload();
	})
	
	$('#multiFileUpload_cancel').click(function(){
		$('#dg_fileUpload').dialog('close');
	})
	 
});

function ajaxFileUpload(){
	 $.ajaxFileUpload({
		 url:'projDigest/multiUploading',
		 secureuri:false,
		 fileElementId:'multiFileUpload',
		 contentType: "applicaiton/x-www-form-urlencoded",
		 dataType:'json',
		 
		 success: function(data,status){
			 

			 if(data.success == true){
				    $('#dg_fileUpload').dialog('close');
				    $.messager.show({
						title  : '提示',
						msg    : '项目摘要导入成功！'
					});
					
				}
				else if(data.success == false){
				   $.messager.show({
						title : '出错信息',
						msg :   data.msg
					});
				}
		 },
		 error: function(data,status,e){
			 $.messager.progress('close');
			 $.messager.alert('错误,请检查数据');
		 }
		
	  });
	
}