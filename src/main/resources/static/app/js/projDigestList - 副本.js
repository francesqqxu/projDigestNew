/**
 * 
 */

/**
 * 
 */

$(function(){
	
	console.log("projDigestList.js");
	
	var url;
	var hideIndexs = new Array();
	
	//date formatter
	$.extend($.fn.datebox.defaults.formatter = function(date) {
	    	var y=date.getFullYear();
	    	var m = date.getMonth() +1;
	    	var d = date.getDate();
	    	
	    	if( m < 10 ){
	    		m = '0'+m;
	       	}
	    	if(d < 10 ){
	    		d = '0'+d;
	    	}
	    	return  y+'-'+m+'-'+d;
	});
	
	function projDigest_fm_load_edit(row){
		
		$('#projDigest_fm').form("load",row);
		
		$('#dg').dialog('open').dialog("setTitle","编辑项目摘要信息");
		
		$('#industryCategory').combobox({
			url: 'industry/get_industryCategory',
			valueField: 'id',
			textField: 'industry',
			onSelect: function(rec){
				console.log("edit industryCategory onSelect");
				var url = "field/get_fieldByIndustryId?id=" + rec.id;
				
				$('#fieldCategory').combobox('reload',url);
			},
			onLoadSuccess:function(){
				
				var industryData = $(this).combobox("getData");
				console.log("edit industryCategory load success");
				console.log(industryData);
			
				var industry = $.trim(row.industryCategory);
				 
				for(var i=0; i<industryData.length; i++){
					if($.trim(industryData[i].industry) == industry ){
						$(this).combobox('setText',industryData[i].industry);
						$(this).combobox('setValue',industryData[i].id);
					} 
				}
				
			}
			
		
		});
		
		$('#fieldCategory').combobox({
			url: 'field/get_fieldCategory',
			valueField: 'id',
			textField: 'field',
			onSelect:function(rec){
				console.log("edit fieldCategory onSelect")
				var url = "app/get_appByFieldId?id=" + rec.id;
				$('#applicationCategory').combobox('reload',url);
			},
			onLoadSuccess:function(){
				console.log("edit fieldCategory loadSuccess");
				var fields = $(this).combobox("getData");
				console.log(fields);
		 
				var field = row.fieldCategory;
				console.log("field=" + field);
				if(fields.length <= 0){
					$(this).combobox('setText',"");
				}
				
				for(var i=0; i<fields.length; i++) {
					 
					 if(fields[i].field == field){ 
						 //$(this).combobox('select',val[0][item]);
						 $(this).combobox('setText',fields[i].field);
						 $(this).combobox('setValue',fields[i].id);
						 break;
					 }
					 else{
						 $(this).combobox('setText',"");
						 
					 }
				}
				 	
			}
		
		});
		
		$('#applicationCategory').combobox({
			url: 'app/get_appCategory', 
			valueField: 'id',
			textField: 'application',
			
			onLoadSuccess:function(){
				console.log("edit applicatonCategory loadsuccess");
				var apps = $(this).combobox("getData");
				console.log(apps);
				 
				var app = row.applicationCategory;
		        
				if(apps.length <= 0){
					$(this).combobox('setText',"");
				}
				
				for(var i=0; i<apps.length; i++){ 
					  
					 if(apps[i].application == app){ 
						 //$(this).combobox('select',val[0][item]);
						 $(this).combobox('setText',apps[i].application);
						 $(this).combobox('setValue',apps[i].id);
						 break;
					 }
					 else{
						 $(this).combobox('setText',"");
					 }
				}
				
			}
		});
		
		url = "projDigest/update?id=" + row.id;
	}
	
	$('#projDigest_list').datagrid({
		  title:'项目摘要',
		  url:'projDigest/get_projDigest',
		  fitColumns:true,
		  fit:true,
		  rownumbers:true,
		  striped: true,
		  border:false,
		  scrollbarSize: 0,
		  toolbar: '#projDigest_list_tool',
		  pagination:true,
		  pageSize:20,
		  pageNumber:1,
		  pagePosition:'bottom',
		  sortName:'proj_outcome_id',
		  sortOrder:'asc',
		  queryParams:{
			  projOutcomeId:"",
			  projName: "",
			  projNum: "",
			  lob: ""
		  },
		  
		  frozenColumns: [[{
			 field: 'id',
			 title: '自动编号',
			 width:10,
			 checkbox:true
		  }]],
		  
		  columns:[[
			  {
				 field:'projOutcomeId',
				 title:'项目成果ID',
				 width:20
			  },
			  {
					 field:'lob',
					 title:'LOB',
					 width:20
			  },
			  {
					 field:'projName',
					 title:'项目名称',
					 width:20
			  },
			  {
					 field:'projNum',
					 title:'项目编号',
					 width:20
			  },
			  {
					 field:'custName',
					 title:'客户名称',
					 width:20
			  },
			  {
					 field:'projBrief',
					 title:'项目简介',
					 width:20
			  },
			  {
					 field:'projBeginDate',
					 title:'项目开始日期',
					 width:20
			  },
			  {
					 field:'projEndDate',
					 title:'项目关闭日期',
					 width:20
			  },
			  {
					 field:'archivePath',
					 title:'归档SVN路径',
					 width:20
			  },
			  {
					 field:'projManagerName',
					 title:'项目经理姓名',
					 width:20
			  },
			  {
					 field:'projManageId',
					 title:'项目经理ID',
					 width:20
			  },
			  {
					 field:'projManageEmail',
					 title:'项目经理邮箱',
					 width:20
			  },
			  {
					 field:'projManageTel',
					 title:'项目经理电话',
					 width:20
			  },
			  {
					 field:'industryCategory',
					 title:'行业',
					 width:20
			  },
			  {
					 field:'fieldCategory',
					 title:'领域',
					 width:20
			  },
			  {
					 field:'applicationCategory',
					 title:'应用',
					 width:20
			  },
			  {
					 field:'usedLanguage',
					 title:'编程语言',
					 width:20
			  },
			  {
					 field:'systemSoft',
					 title:'系统软件',
					 width:20
			  },
			  {
					 field:'systemHard',
					 title:'系统硬件',
					 width:20
			  },
			  {
					 field:'usedDatabase',
					 title:'数据库',
					 width:20
			  },
			  {
					 field:'testFramework',
					 title:'测试框架',
					 width:20
			  },
			  {
					 field:'keyTechSkills',
					 title:'其他关键技术',
					 width:20
			  }
		 
		  ]],
		  rowStyler: function(index,row){
			  console.log("index:" + index);
			  console.log("row:" + row['projOutcomeId']);
			  console.log("hideIndexs: " + hideIndexs);
			  if(hideIndexs.indexOf(index) >= 0)  {
				  return 'background:red;display:none';
			  }
		  },
		  onDblClickRow : function (rowIndex, rowData){
			  projDigest_fm_load_edit(rowData);
		  }, 
	      onLoadError: function() {
	    	 $.messager.show({
	    		 title : '提示',
	    		 msg   : '加载项目摘要信息出错， 请联系系统管理人员！'
	    	 })
	      }
	});
	
	$('#projDigest_list_tool_search_lob').combobox({
		url:'projDigest/get_distinctLob',
		valueField:'id',
		textField: 'lob',
		onSelect: function(rec){
			$('#projDigest_list').datagrid('load',{
				
				projOutcomeId : $.trim($('#projDigest_list_tool_search_projOutcomeId').val()),
				projName: $.trim($('#projDigest_list_tool_search_projName').val()),
				projNum: $.trim($('#projDigest_list_tool_search_projNum').val()),
				lob:  rec.lob,
				keyWord: $.trim($('#projDigest_list_tool_search_keyWord').val())
				
				
			}); 
		}
	 
	});
	
	$('#projDigest_list_tool_search_projOutcomeId').textbox({
		onChange:function(newValue, oldValue){
	    	$('#projDigest_list').datagrid('load',{
				
				projOutcomeId : newValue,
				projName: $.trim($('#projDigest_list_tool_search_projName').val()),
				projNum: $.trim($('#projDigest_list_tool_search_projNum').val()),
				lob:   $.trim($('#projDigest_list_tool_search_lob').combobox('getText')),
				keyWord: $.trim($('#projDigest_list_tool_search_keyWord').val())
			}); 	
		}
	})
	
	
    $('#projDigest_list_tool_search_projName').textbox({
    	onChange: function(newValue,oldValue){
    		$('#projDigest_list').datagrid('load',{
				projOutcomeId : $.trim($('#projDigest_list_tool_search_projOutcomeId').val()),
				projName: newValue,
				projNum: $.trim($('#projDigest_list_tool_search_projNum').val()),
				lob:   $.trim($('#projDigest_list_tool_search_lob').combobox('getText')),
				keyWord: $.trim($('#projDigest_list_tool_search_keyWord').val())
			}); 	
    	}
    })
    
    $('#projDigest_list_tool_search_projNum').textbox({
    	onChange: function(newValue,oldValue){
    		$('#projDigest_list').datagrid('load',{
				projOutcomeId : $.trim($('#projDigest_list_tool_search_projOutcomeId').val()),
				projName: $.trim($('#projDigest_list_tool_search_projName').val()),
				projNum:  newValue,
				lob:   $.trim($('#projDigest_list_tool_search_lob').combobox('getText')),
				keyWord: $.trim($('#projDigest_list_tool_search_keyWord').val())
			}); 	
    	}
    })
	
	$('#projDigest_list_tool_search_keyWord').searchbox({
		width:110,
		searcher: function(value){
			console.log("value: " + value);
			hideIndexs.length = 0;
			if(value == '请输入查询关键字'){
				value='';
			}
		
		    //结束datagrid的编辑
	        endEdit();
	        var rows = $('#projDigest_list').datagrid('getRows');
	        
	        var cols = $('#projDigest_list').datagrid('options').columns[0];
	        
	        for(var i=rows.length-1; i >= 0; i--){
	        	var row = rows[i];
	        	console.log("index of row: " + i);
	        	var isMatch = false;
	        	for(var j=0; j < cols.length; j++){
	        		console.log("j:cols[j].field:" + j+":"+cols[j].field);
	        		var cellValue = row[cols[j].field];
	        		console.log("cellValue=" +cellValue);
	        		if(cellValue == undefined){
	        			continue;
	        		}
	        		if(cellValue.toString().toLowerCase().indexOf(value) >=0 || cellValue.toString().indexOf(value) >= 0 ) {
	        			console.log("cellValue is match: j" + cellValue + ":" + j);
	        			isMatch = true;
	        			break;
	        		}
	        	}
	        	if(!isMatch)
	        		hideIndexs.push(i);
	        	//刷新行
	        	$('#projDigest_list').datagrid('refreshRow', i);
	        }
	         
		},
		prompt: '请输入查询关键字'
		
	});
	
	function endEdit(){
		var rows = $('#projDigest_list').datagrid('getRows');
		for(var i=0; i<rows.length; i++){
			$('#projDigest_list').datagrid('endEdit',i);
		}
	}
	
	
	
	$('#projDigest_list_tool_search').click(function(){
		
	    console.log("projDigest_list_tool_search");
	    console.log($('#projDigest_list_tool_search_projOutcomeId').val());
		$('#projDigest_list').datagrid('load',{
			projOutcomeId : $.trim($('#projDigest_list_tool_search_projOutcomeId').val()),
			projName: $.trim($('#projDigest_list_tool_search_projName').val()),
			projNum: $.trim($('#projDigest_list_tool_search_projNum').val()),
			lob: $.trim($('#projDigest_list_tool_search_lob').combobox('getText')),
			keyWord: $.trim($('#projDigest_list_tool_search_keyWord').val())	
			
		});
	});
	
	$('#projDigest_list_tool_clear').click(function(){
	   $('#projDigest_list_tool_search_projOutcomeId').textbox('clear');
	   $('#projDigest_list_tool_search_projName').textbox('setValue','');
	   $('#projDigest_list_tool_search_projNum').textbox('setValue','');
	   var val = $('#projDigest_list_tool_search_lob').combobox('getData');
	   
	   for(var item in val[0]){
			 console.log(item);
			 console.log(val[0][item]);
			 if(item="id"){
				 $('#projDigest_list_tool_search_lob').combobox('select',val[0][item]);
			 }
		}
	   
	   $('#projDigest_list').datagrid('load',{
			projOutcomeId : $.trim($('#projDigest_list_tool_search_projOutcomeId').val()),
			projName: $.trim($('#projDigest_list_tool_search_projName').val()),
			projNum: $.trim($('#projDigest_list_tool_search_projNum').val()),
			lob: $.trim($('#projDigest_list_tool_search_lob').combobox('getText')),
			keyWord: $.trim($('#projDigest_list_tool_search_keyWord').val())	
			
		});
	})
		
	$('#projDigest_list_tool_add').click(function(){
		$('#dg').dialog('open').dialog('setTitle','添加项目摘要信息');
		$('#projDigest_fm').form('clear');
		url = "projDigest/add";
		
		$('#industryCategory').combobox({
			url:'industry/get_industryCategory',
			valueField: 'id',
			textField: 'industry',
			onSelect: function(rec){
				var url = "field/get_fieldByIndustryId?id=" + rec.id;
				$('#fieldCategory').combobox('reload',url);
			},
			onLoadSuccess:function(){
				
				var val = $(this).combobox("getData");
							 
				for(var item in val[0]){
					 //console.log(item);
					 //console.log(val[0][item]);
					 if(item="id"){
						 $(this).combobox('select',val[0][item]);
					 }
				}
				
			}
			 
		});
		
		$('#fieldCategory').combobox({
			url:'field/get_fieldCategory',
			valueField: 'id',
			textField: 'field',
			onSelect:function(rec){
				var url = "app/get_appByFieldId?id=" + rec.id;
				$('#applicationCategory').combobox('reload',url);
			}
			
		});
		
		$('#applicationCategory').combobox({
			valueField: 'id',
			textField: 'application'
		})
		
	});
	
	
	
	$('#btnAddIndustry').click(function(){
	      var industry = $('#industryCategory').combobox('getText');
	      $.ajax({
	    	  url: 'industry/add',
			  type: 'POST',
			  timeout: 100000,
			  dataType:'json',
	    	  data:{
	    		  industry: industry
	    	  },
			  success: function(data,response,status){
					if(data.success==true){
						$.messager.alert("系统提示","保存成功！");
					}
					else{
						$.messager.alert("系统提示","保存失败，请联系管理人员！");
					}
						
				},
				error: function(data){
					alert(data);
					$.messager.alert("出错，请检查数据！");
				}
	    	  
	      })
		
		
	});
	
	$('#btnAddField').click(function(){
	      var field = $('#fieldCategory').combobox('getText');
	     
	      var industry = $('#industryCategory').combobox('getText');
	      console.log("industry:="+industry);
	      
	      var industryId = $('#industryCategory').combobox('getValue');
	      console.log("industryId:=" +industryId);
	      
	      var industryArr = $('#industryCategory').combobox('getData');
	      
	      for( var index in industryArr){
	    	  console.log(industryArr);
	    	  console.log(industryArr[index]);
	    	  for(var item in industryArr[index]){
					console.log(item);
					 
					 if(item="industry"){
						 //$(this).combobox('select',val[0][item]);
						 console.log(industryArr[index][item]);
					 }
				}
		     	      
	      }
	      
	      $.ajax({
	    	  url: 'field/add',
			  type: 'POST',
			  timeout: 100000,
			  dataType:'json',
	    	  data:{
	    		  field: field,
	    		  industryId: industryId
	    	  },
			  success: function(data,response,status){
					if(data.success==true){
						$.messager.alert("系统提示","保存成功！");
					}
					else{
						$.messager.alert("系统提示","保存失败，请联系管理人员！");
					}
						
				},
				error: function(data){
					alert(data);
					$.messager.alert("出错，请检查数据！");
				}
	    	  
	      })
		
		
	});
	
	$('#btnAddApp').click(function(){
	      var application = $('#applicationCategory').combobox('getText');
	      
	      var fieldId = $('#fieldCategory').combobox('getValue');
	      
	      
	      $.ajax({
	    	  url: 'app/add',
			  type: 'POST',
			  timeout: 100000,
			  dataType:'json',
	    	  data:{
	    		  application: application,
	    		  fieldId: fieldId
	    	  },
			  success: function(data,response,status){
					if(data.success==true){
						$.messager.alert("系统提示","保存成功！");
					}
					else{
						$.messager.alert("系统提示","保存失败，请联系管理人员！");
					}
						
				},
				error: function(data){
					alert(data);
					$.messager.alert("出错，请检查数据！");
				}
	    	  
	      })
		
		
	});
	

	
	
	$('#projDigest_add_submit').click(function(){
		$('#projDigest_fm').form("submit",{
			url:url,
			onSubmit: function(){
				return $(this).form("validate");
			},
			
			success: function(result){
				var result = eval('(' +result + ')');
				if(result.success){
					$.messager.alert("系统提示","保存成功！");
					
					$('#dg').dialog("close");
					
					$('#projDigest_list').datagrid("reload");
				}
			}
		});
	});
	
	
	/*$('#projDigest_add_submit').click(function(){
		
		$.ajax({
			url: url,
			type: 'POST',
			timeout: 100000,
			dataType:'json',
			data: $('#projDigest_fm').serialize(),
			 
			
			success: function(data,response,status){
				if(data.success==true){
					$.messager.alert("系统提示","保存成功！");
					$('#dg').dialog('close');
					$('#projDigest_list').datagrid('reload');
				}
				else{
					$.messager.alert("系统提示","保存失败，请联系管理人员！");
				}
					
			},
			error: function(data){
				alert(data);
				$.messager.alert("出错，请检查数据！");
			}
			
		});
		
		
	});
	*/
	
	$('#projDigest_add_cancel').click(function(){
		
		$('#dg').dialog('close');
		
	})
	
	$('#projDigest_list_tool_update').click(function(){
		
		var selectedRows= $('#projDigest_list').datagrid("getSelections");
		
		if(selectedRows.length != 1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		
		var row = selectedRows[0];
		
		projDigest_fm_load_edit(row);
		
				
	});
	
	
	$('#projDigest_list_tool_delete').click(function(){
		
		var rows = $('#projDigest_list').datagrid('getSelections');
		
		if(rows.length > 0 ){
			$.messager.confirm('确定','确定要删除<strong>'+rows.length+'<strong>条记录吗?',function(flag){
				if(flag){
					var ids=[];
					for(var i=0; i<rows.length; i++){
						ids.push(rows[i].id);
					}
					
					$.ajax({
						url:'projDigest/delByIds',
						type: 'POST',
						datatype: 'json',
						data:{
							ids: ids.join(',')
						},
					
						beforeSend : function() {
						    	$('#projDigest_list').datagrid('loading');
						},
					    success : function(data){
					    	if(data.success==true){
					    		$('#projDigest_list').datagrid('loaded');
					    		$('#projDigest_list').datagrid('reload');
					    		$('#projDigest_list').datagrid('unselectAll');
					    		$.messager.show({
					    			title : '提交',
					    			msg : '项目摘要信息被删除！'
					    			
					    		});
					    		$.messager.progress('close');
					    	}
					    	else if (data.success=="false"){
					    		$.messager.show({
					    			title : '错误信息',
					    			msg  :  '项目摘要信息删除发生错误，请联系管理人员! 错误信息： ' + data.msg
					    		});
					    	}
					    },
					    error : function(data){
							$.messager.progress('close');
							$.messager.alert('错误,请检查数据');
							$('#projDigest_list').datagrid('loaded');
							$('#projDigest_list').datagrid('reload');
						}
					});	 
			    }  
		   });  
        }  
	});
	
	$('#projDigest_list_tool_add').linkbutton({
		iconCls: 'icon-add',
		plain: true
	});
	
	$('#projDigest_list_tool_update').linkbutton({
		iconCls: 'icon-edit',
		plain:true
	});
	
	$('#projDigest_list_tool_delete').linkbutton({
		iconCls: 'icon-remove',
		plain:true
	});
		
	$('#projDigest_list_tool_search').linkbutton({
		iconCls: 'icon-search',
		plain:true
	});
	
	$('#projDigest_list_tool_clear').linkbutton({
		iconCls: 'icon-clear',
		plain:true
	});
		
	 
		
});
	
	
