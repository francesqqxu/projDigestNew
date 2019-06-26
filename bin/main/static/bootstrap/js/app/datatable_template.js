$(function() {
  
  //1. ��ʼ��Table
  var oTable = new TableInit();
  oTable.Init();

  //2.��ʼ��Button�ĵ���¼�
  var oButtonInit = new ButtonInit();
  oButtonInit.Init();



});

var TableInit = function() {
     var oTableInit = new Object();
	 //��ʼ��Table
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
			showToggle:true,//�Ƿ���ʾ��ϸ��ͼ���б���ͼ�л���ť
			cardView:false,
			detailView:false,
			columns:[{
				checkbox: true
			},
		    {
			    field: 'Name',
				title: '��������'
			},
			 {
                 field: 'ParenName',
			     title: '�ϼ�����'
			 },
             {
                  field: 'Level',
				  title: '���ż���'
			 },
			 {
                   field: 'Desc',
				   title :'����'
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