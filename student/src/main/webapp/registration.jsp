<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>STUDENT REGISTRATION PORTAL</title>
<style>
.btn {
	font-size: 1.1rem;
	background: none;
	cursor: pointer;
}

.btn:hover {
	color: blue;
}

.error {
	color: red;
}
</style>
</head>

<body>

	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must revalidate");

		response.setHeader("Pragma", "no-cache");

		//response.setHeader("Expires","0");
	%>

	<form action="registration" method="post">
		<h1>Register</h1>
		<hr>
		<p>Please fill in this form to create an account.</p>
		<p class="error">
			${message1} <br> ${message2} <br> ${message3} <br>${message4}<br>
			${title}<br>${firstname}<br> ${lastname} <br>${email} <br>${password} <br>${cnfpassword}
		</p>
		<hr>
		<table align="center">
			<tr>

				<td>Title *</td>
				<td><select name="Title">
						<option>select</option>
						<option>Mr</option>
						<option>Mrs</option>
						<option>Ms</option>
				</select></td>
			<tr>
				<td>First Name*</td>
				<td><input type="text" placeholder="Enter First Name"
					name="firstName"  /></td>
			</tr>


			<tr>
				<td>Last Name*</td>
				<td><input type="text" placeholder="Enter Last Name"
					name="lastName"  /></td>
			</tr>


			<tr>
				<td>Email Id*</td>
				<td><input type="text" placeholder="Enter Email id" name="email"
					 /></td>
			</tr>


			<tr>
				<td>Password*</td>
				<td><input type="password" placeholder="Enter Password"
					name="password"  /></td>
			</tr>


			<tr>
				<td>Confirm Password*</td>
				<td><input type="password" placeholder="Confrim Password"
					name="confirmPassword"  /></td>
			</tr>


			<tr>
				<td>Mobile Number</td>
				<td><input type="text" placeholder="Enter Mobile Number"
					name="phoneNumber" /></td>
			</tr>


			<tr>

				<td colspan="2" align="right">
					<button class="btn" type="submit">Sign up</button>
				</td>
			</tr>

		</table>

		<%--
         Integer hitsCount = (Integer)application.getAttribute("hitCounter");
         if( hitsCount ==null || hitsCount == 0 ) {
            /* First visit */
            hitsCount = 1;
         } 
         else
         {
        	 hitsCount+=1;
         }
         application.setAttribute("hitCounter", hitsCount);
         
      --%>


		<p>
			<b>Already have an account?</b> <a href="login.jsp">Sign in</a>
		</p>

	      <p>
			<b>To view list of student? </b> <a href="viewservlet">view student</a>

		</p>


	</form>
</html>
