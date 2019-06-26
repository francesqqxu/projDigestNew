<?php
	$results[0] = array("name"=>"aoze","pwd"=>"20132588","t_name"=>"张三");
	$results[1] = array("name"=>"lisi","pwd"=>"1234","t_name"=>"李四");
	$results[2] = array("name"=>"wangwu","pwd"=>"44455","t_name"=>"王五");
	header('content-type:application:json;charset=utf8');
header('Access-Control-Allow-Origin:*');
header('Access-Control-Allow-Method:POST');
header('Access-Control-Allow-Headers:x-requested-with, content-type');

    echo json_encode($results);
?>