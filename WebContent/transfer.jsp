

<!DOCTYPE html>
<html lang="en">
<head>
<title>E-Banking a Banking Category Bootstrap Bootstrap Responsive website Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="E-Banking Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="css/font-awesome.css" rel="stylesheet">   <!-- font-awesome icons --> 
<!-- //Custom Theme files -->  
<!-- js --> 
	<script src="js/jquery-2.2.3.min.js"></script>
<!-- web-fonts -->
<link href="//fonts.googleapis.com/css?family=Secular+One" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<!-- //web-fonts --> 
</head>
<body> 
	<!-- header -->
	<div class="headerw3-agile"> 
		<div class="header-w3mdl"><!-- header-two --> 
			<div class="container"> 
				<div class="agileits-logo navbar-left">
					<h1><a href="index.html"><img src="images/e.png" alt="logo"/>Banking</a></h1> 
				</div> 
				<div class="agileits-hdright nav navbar-nav">
					<div class="header-w3top"><!-- header-top --> 
						<ul class="w3l-nav-top">
							<li><i class="fa fa-phone"></i><span> +01 222 111 444 </span></li> 
							<li><a href="mailto:example@mail.com"><i class="fa fa-envelope-o"></i><span>asdad</span></a></li>
						</ul>
						<div class="clearfix"> </div> 	 
					</div>
					  

				</div>
				<div class="clearfix"> </div> 
			</div>	
		</div>	
	</div>	
	<!-- //header -->  
	<!-- banner -->
	<div class="banner">
		<div class="header-nav"><!-- header-three --> 	
			<nav class="navbar navbar-default">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						Menu 
					</button> 
				</div>
				<!-- top-nav -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="index.html" class="active">Home</a></li>
						<li><a href="icons.html" data-toggle="dropdown">Accounts<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li class="has-down"><a href="icons.html" data-toggle="dropdown">Icons</a><span class="caret"></span></a>
								
								<ul class="dropdown-menu">
								<li><a href="icons.html">abcd</a></li>
								<li><a href="icons.html">abcd</a></li>
								</ul></li></ul></li>

				
							
							
							
							
						<li><a href="services.html" class="scroll">Funds Transfer</a></li>    
						<li><a href="gallery.html" class="scroll">Bill Pay/Recharge</a></li>						
						<li><a href="icons.html" data-toggle="dropdown">Short Codes<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="icons.html">Icons</a></li>
								<li><a href="typography.html">Typograpghy</a></li>
							</ul>
						</li>	
						<li><a href="contact.html" class="scroll">Contact Us</a></li>
						<li><b>Welcome
<%HttpSession s=request.getSession();
out.println(s.getAttribute("name"));
%></b></li>
					</ul>  
					<div class="clearfix"> </div>	
				</div>
			</nav>    
		</div>
		<!-- banner-text -->
		<!-- banner -->



<div class="container">
			<div class="banner-text agileits-w3layouts">
				<div  id="top" class="callbacks_container">
					<div class="banner-textagileinfo">
								<form action="transfer" style="border:1px solid #ccc">
 <!--  <div class="container">
  <center>
    <h1 style="color:white">Transfer Funds</h1>
    <br>
  <table>
<tr>
<td>
    <label for="psw" style="color:white"><b>User Name&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
    <input type="text" placeholder="Enter Email" name="email" required><br>
</td></tr>
  <tr><td>  <label for="psw" style="color:white"><b>Account Number&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
    <input type="text" placeholder="Enter Account Number" name="psw" required><br>
</td></tr>
    <tr><td><label for="psw" style="color:white"><b>IFSC Code&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
    <input type="tesxt" placeholder="Enter IFSC Code" required><br>
	</td></tr>
	 <tr><td><label for="psw" style="color:white"><b>Transfer Mode&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
	<select name="mode">
<option value="rtgs">RTGS</option>
<option value="neft">NEFT</option>
<option value="imps">IMPS</option>
</select>
</td></tr>
<br>
    <p>Please make sure you have sufficient funds available and cross check the benificiery account details.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Submit</button><br><br>
    </div>
	</center>
  </div> -->
  <style>
  
  th{
  padding: 15px;
}

td{
padding: 15px;
color: black;
}
tr{color:white;}
caption{
color:red;
size:20px;
}
</style>
  <table>
  <caption><center>Transfer(Intra Bank Only)</center></caption>
  <tr>
    <th>Enter Name</th>
    <td style=color:black><input type="text" name="name"></td>
  </tr>
  <tr>
    <th>Enter Account Number</th>
    <td style=color:black><input type="number" name="accno"></td>
  </tr>
  <!-- <tr>
    <th>Enter Customer ID</td>
    <td><input type="text" placeholder="customer id"></td>
  </tr> -->
  <tr>
    <th>Enter IFSC</td>
    <td><input type="text" name="ifsc"></td>
  </tr>
 <tr>
    <th>Transfer Type</td>
    <td>
    	<Select name="mode">
    		<option  value=1>NEFT</option>
    		<option  value=2>RTGS</option>
    		<option   value=3>IMPS</option>
    	</Select>
    </td>
  </tr>
  
  <tr>
    <th>Enter Amount</td>
    <td><input type="number" placeholder="" name="amount"></td>
  </tr>
  
  <tr>
    <td colspan=2 align="center"><input type="submit" name="submit" value="Submit" class="btn btn-success"/>
    <button class="btn btn-danger">Cancel</button>
    </td>
<!--     <th style=color:black><input type="submit" name="submit" value="Submit" class="btn btn-success"/></th>
    <th style=color:black><button class="btn btn-danger">Cancel</button></th> -->
  </tr>
</table>
  
  
</form>
								</div>	
							</div>	
				</div>
			</div>
		 </div>
	</div>