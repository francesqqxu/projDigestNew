<?php
	$results[0] = array("name"=>"aoze","pwd"=>"20132588","t_name"=>"����");
	$results[1] = array("name"=>"lisi","pwd"=>"1234","t_name"=>"����");
	$results[2] = array("name"=>"wangwu","pwd"=>"44455","t_name"=>"����");
	header('content-type:application:json;charset=utf8');
header('Access-Control-Allow-Origin:*');
header('Access-Control-Allow-Method:POST');
header('Access-Control-Allow-Headers:x-requested-with, content-type');

    echo json_encode($results);
?>