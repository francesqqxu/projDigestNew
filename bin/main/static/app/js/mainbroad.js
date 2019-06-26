/**
 * 
 */

$(function(){
	console.log("mainbroad.js");
	
  $('#nav').tree({
	  url: 'menu/get_menu',
	  lines: true,
	  onLoadSuccess: function(node, data){
		  var _this = this;
		  if(data){
			  $(data).each(function(index,value){
				  if(this.state=='closed'){
					  $(_this).tree('expandAll');
				  }
			  });
		  }
	  },
	  
	  onLoadError: function(data){
		  console.log(data.getAllResponseHeaders());
		  console.log(data.responseText);
		  location.href ="projDigest/";
		   
		  $.messager.show({
			  title : '出错信息',
			  msg : '加载菜单信息出错， 请联系管理人员！ 具体错误信息： ' + data.statusText
		  })
	  },
	  
	  onClick: function(node){
		 console.log(node.text + node.url);
		 if(node.url){
			 if($('#tabs').tabs('exists',node.text)){
				 $('#tabs').tabs('select',node.text)
				 var tabSelect = $('#tabs').tabs('getTab',node.text);
                 console.log(node.text);
                 console.log(tabSelect);
                 $('#tabs').tabs('update',{
                	 tab: tabSelect,
                	 options: {
                		 href:  node.url,
                		 fit: true,
                		 width: 1500
                		 
                	 }
                 })
			 }else {
				 console.log(node.url);
				 $('#tabs').tabs('add',{
					 title: node.text,
					 closable:true,
					 iconCls: node.iconCls,
					 href: node.url,
					 fit: true,
					 width:1500,
					 
				 });
			 }
		 }
	  }  
		 
  });

  
  
  
  
});

