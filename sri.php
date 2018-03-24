<?php

$response = array();
$response["data"] = array();
for($i=0;$i<10;$i++){
	$temp = array();
	$temp['id'] = 'id'.$i;
	$temp['name'] = 'name'.$i;
	array_push($response["data"], $temp);
}

echo json_encode($response);

?>