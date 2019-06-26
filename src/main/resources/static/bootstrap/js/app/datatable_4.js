$(function() {

    var $table=$('#table');

	$.ajax({
        url: 'http://localhost:8080/php/index.php',
		type: 'post',
		dataType: 'json',
		beforeSend: function(){
            
		},
		success: function(d) {
           setTimeout(function() {
              $table.bootstrapTable({
			     data: d
			  });
		   },2000);
		}
	});

    $('#button').click(function(){
	    $table.bootstrapTable('refresh',{url:'index.php'});
	});
});