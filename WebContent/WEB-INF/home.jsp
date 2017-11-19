<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
<head>
<title>Image Demo</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
</head>
<body>
	<main class="main">
	<div class="jumbotron">
		<h1 class="display-3">Image upload example</h1>
		<p class="lead">This example project demonstrates image upload and
			retrieval in Java.</p>
	</div>

	<div class="container">
		<c:if test="${not empty notice}">
			<div class="alert alert-primary" role="alert">
				<c:out value="${notice}" />
			</div>
		</c:if>

		<div class="row">
			<div class="col-sm-8">
				<h1>The images:</h1>
				<ul>
					<c:forEach var="image" items="${images}">
						<li><a href="/Images/download?id=${image.id}"><c:out value="${image.name}"></c:out></a></li>
					</c:forEach>
				</ul>
			</div>


			<div class="col-sm-4">
				<h2>Add an image</h2>
				<form action="/Images/upload" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<input class="form-control-file" type="file" name="newImage" />
					</div>
					<div class="form-group">
						<input class="btn btn-primary" type="submit" value="Upload"></input>
					</div>
				</form>

			</div>
		</div>
	</div>
	</main>

	<footer class="container">
		<hr />
		Please feel free to copy the ideas in your project, but not the code.
	</footer>

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
</body>
</html>
