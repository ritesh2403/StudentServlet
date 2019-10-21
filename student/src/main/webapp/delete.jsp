<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<title>>Account Removal</title>
<style>
.btn {
	font-size: 1.1rem;
	background: none;
	cursor: pointer;
}

.btn {
	color: blue;
}

.form {
	border: 2px;
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
	<p class="error">${message1}</p>

	<form action="delete" method="post">
		<div class="container">

			<p align="center">
				<b>To delete your account please enter your username and
					password</b>
			</p>

			<hr>
			<table align="center">

				<tr>
					<td><label for="email"><b>Email</b></label></td>

					<td><input type="text" placeholder="Enter Email" name="email"
						required></td>
				</tr>

				<tr>
					<td><label for="psw"><b>Password</b></label></td>

					<td><input type="password" placeholder="Enter Password"
						name="psw" required></td>
				</tr>

				<tr>
					<td colspan=2 align="center"><button type="submit" class="btn">Delete</button></td>
				</tr>
			</table>

		</div>


	</form>
</body>

</html>