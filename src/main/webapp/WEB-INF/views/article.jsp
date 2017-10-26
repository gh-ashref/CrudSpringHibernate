<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="b"%>

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
		<h1>New Article</h1>
		<h3>
			<a href="form">New User</a>
		</h3>
		<form action="addArticle" method="post" modelAttribute="article">
			<table>

				<tr>
					<td>content:</td>

					<td><input type="text" name="content"></td>
				</tr>
				<tr>
					<td>description:</td>
					<td><input type="text" name="description"></td>
				</tr>
				<tr>
					<td>keywords:</td>
					<td><input type="text" name="keywords"></td>
				</tr>
				<tr>
					<td>title:</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save" class="btn btn-success"></td>
				</tr>
			</table>


			<select name="user_id" id="user_id">
				<c:forEach var="user" items="${listUser}">

					<option value=<c:out value="${user.login}" />><c:out
							value="${user.firstName}" />
						<c:out value="${user.lastName}" /></option>
				</c:forEach>
			</select>




		</form>
	</div>
	<br />
	<center>
		<table border="1">

			<th>content</th>
			<th>description</th>
			<th>keywords</th>
			<th>title</th>
			<th>user</th>

			<b:forEach var="articles" items="${listArticle}">
				<tr>

					<td><c:out value="${articles.content}" /></td>
					<td><c:out value="${articles.description}" /></td>
					<td><c:out value="${articles.keywords}" /></td>
					<td><c:out value="${articles.title}" /></td>
					<td><c:out value="${articles.user.firstName}" /> <c:out
							value="${articles.user.lastName}" /></td>

				</tr>
			</b:forEach>
		</table>
	</center>
</body>
</html>
