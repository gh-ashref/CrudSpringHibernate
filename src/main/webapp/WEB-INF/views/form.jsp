<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit User</h1>
		<c:out value="${erreur}" />
		<form action="addUser" method="post" modelAttribute="user">
			<table>
				<input type="hidden" name="id" value=<c:out value="${user.id}" />>
				<tr>
					<td>First Name:</td>

					<td><input type="text" name="firstName"
						value=<c:out value="${user.firstName}" />></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName"
						value=<c:out value="${user.lastName}" />></td>
				</tr>
				<tr>
					<td>Login:</td>
					<td><input type="text" name="login"
						value=<c:out value="${user.login}" />></td>
				</tr>
				<tr>
					<td>password:</td>
					<td><input type="password" name="password"
						value=<c:out value="${user.password}"/>></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save" class="btn btn-success"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
