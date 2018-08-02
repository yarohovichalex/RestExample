<!DOCTYPE html>
<html>
    <head>
        <title>jquery project</title>
		<link rel="stylesheet" href="css/mystyle.css" type="text/css">
		<meta charset="UTF-8"/>				
	   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>	
    </head>

<body>



<h2>Hello World!</h2>
<button onclick="myFunction()">Send request</button>
<p id="paragraph"></p>

<script type="text/javascript">
function myFunction() {
    //function which send ajax request to the server
    $.ajax({
        url : '/afdsas/cars',
        datatype : 'json',
        type : "post",
        contentType : "application/json",
        data : JSON.stringify({
            message : 'Hi there',
            id : 1
        }),
        success : function(data) {
            console.log(data);
             $("#paragraph").text(data.message);
        }
    });
}
</script>
</body>
</html>