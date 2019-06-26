$(function(){
   $('#teacher_table').on('click-row.bs.table', function(e, row,element){
       $(.success).removeClass('success'); 
	   $(element).addClass('success');
   });
   
   function getSelectedRow() {
       var index = $('#teacher_table').find('tr.success').data('index');
	   return$('#teacher_table').bootstrapTable('getData')[index];

   }

});