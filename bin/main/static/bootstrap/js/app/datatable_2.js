function InitTable() {
      
	  var oTableInit = new Object();
	  datetime = document.getElementById('nowdate').value;

	  $("#table").bootstrapTable('destroy');
      $('#table').bootstrapTable({
            url : 'data1.json',
            method : 'get',
			striped: true,
		    //cache: false,
			pagination: true,
		    //sortable: true,
			//sortOrder: "asc",
            //queryParams: Search,
			sidePagination: "client",
			pageNumber: 1,
		    pageSize : 10,
		    pageList :[10,25,50,100],
			//search: false,
			//strictSearch: true,
			//showColumns: true,
			//showRefresh: true,
			//minimumCountColumns: 1,
			//clickToSelect: true,
			height: 500,
		    //uniqueId: "id",
			//showToggle: true,
			//cardView: true,
			//detailView: false,
			columns[{
				checkbox: true
				},
				{
					field : 'id',
				    title : 'Item ID'
				},
				{
	                field : 'name',
					title : 'Item Name'
				},
				{
					field : 'price',
					title : 'Item Price'

				}]
	  });


}

$(function() {
      $('#table').Datatable({
		  ajax: "data1.json",
	      columns:[{
			  title: "Item ID"
		  },
		  {
			  title: "Item Name"
		  },
		  {
			  title "Item Price"
		  }]

	  });
});