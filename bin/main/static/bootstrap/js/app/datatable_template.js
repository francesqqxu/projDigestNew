$(function() {
  
  //1. 初始化Table
  var oTable = new TableInit();
  oTable.Init();

  //2.初始化Button的点击事件
  var oButtonInit = new ButtonInit();
  oButtonInit.Init();



});

var TableInit = function() {
     var oTableInit = new Object();
	 //初始化Table
	 oTableInit.Init=function() {
         $('#tb_depts").bootstrapTable({
            url: '/Home/GetDepartment',
		    method:'get',
		    toolbar: '#toolbar',
			striped: true,
			cache: false,
		    pagination: true,
			sortable: false,
			sortOrder: "asc",
            queryParams: oTableInit.queryParams,
		    sidePagination: "server",
			pageNumber:1,
		    pageSize: 10,
			pageList: [10,25,50,100],
			search: true,
			strictSearch:true,
			showColumns:true,
		    showRefresh:true,
			minimumCountColumns:2,
		    clickToSelect:true,
			height:500,
			uniqueId:"ID",
			showToggle:true,//是否显示详细视图和列表视图切换按钮
			cardView:false,
			detailView:false,
			columns:[{
				checkbox: true
			},
		    {
			    field: 'Name',
				title: '部门名称'
			},
			 {
                 field: 'ParenName',
			     title: '上级部门'
			 },
             {
                  field: 'Level',
				  title: '部门级别'
			 },
			 {
                   field: 'Desc',
				   title :'描述'
			 },]
		    
		 });

	 }; //function Init

	 oTableInit.queryParams = function(params){
        var temp = {
           limit: params.limit,
		   offset: params.offset,
		   departmentname: $('#txt_search_deptname').val(),
		   stauts: $('#txt_search_status').val()
		};
        return temp;
	 };
	 return oTableInit;
}; //var TableInit

var ButtonInit = function() {
   var oInit = new Object();
   var postdata = {};

   oInit.Init = function() {

   };
   return oInit;

};