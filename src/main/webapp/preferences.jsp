<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Preferences</h2>
					
						<form method="post" action="list" class="register-form"
							id="register-form">
							
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-city material-icons-name"></i></label> <input
									type="text" name="cname" id="cname" placeholder="Company Name" />
							</div>
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-pin-account material-icons-name"></i></label> <input
									type="text" name="rname" id="rname" placeholder="Interested Role" />
							</div>
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-pin material-icons-name"></i></label> <input
									type="text" name="lname" id="lname" placeholder="Location" />
							</div>
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-walk material-icons-name"></i></label> <input
									type="text" name="fname" id="fname" placeholder="Full Time or Part Time" />
							</div>
							<div class="form-group form-button">
								<input type="submit" name="prefernces" id="preferences"
									class="form-submit" value="SET" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
   
   <script type="text/javascript">
  
    var status = document.getElementById("status").value;
    if(status=="success")
    	{
    	swal("Congrats","Prefernces Set Successfully!!","success");
    	}
   </script>


</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>