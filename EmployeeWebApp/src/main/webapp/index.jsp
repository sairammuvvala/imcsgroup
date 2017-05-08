<html>
 <head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head> 
<body>
<h2 align="center">Create Employee</h2>




<form class="form-horizontal" role="form" method="post" action="/EmployeeWebApp/CreateEmployee">
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">FirstName</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="firstname" name="firstname" placeholder="FirstName" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">LastName</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="lastname" name="lastname" placeholder="LastName" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="gender" class="col-sm-2 control-label">Gender</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="gender" name="gender" placeholder="Male ot Female" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="salary" class="col-sm-2 control-label">Salary</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="salary" name="salary" placeholder="Enter > 20000" value="">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<input id="submit" name="submit" type="submit" value="Send" class="btn btn-primary">
		</div>
	</div>
	<!-- <div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<! Will be used to display an alert to the user>
		</div>
	</div> -->
	
	<a href="readEmployee.jsp">read</a>
</form>
</body>
</html>