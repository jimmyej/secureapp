<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Jimmy Sanchez">


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script type="txt/JavaScript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script type="txt/JavaScript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>

<script type="text/javascript" src="content/js/jquery-1.12.3.min.js"></script>

<script type="txt/JavaScript" src="app/app.js"></script>
<script type="txt/JavaScript" src="content/js/chatscript.js"></script>
<link rel="stylesheet" href="content/css/chatstyle.css">

<title>Welcome</title>
</head>
<body>
	<c:url value="/view/showMessage.html" var="messageUrl" />
	<a href="${messageUrl}">Click to enter 1</a>

	<div class="container chat-signin">
		<form class="form-signin">
			<h2 class="form-signin-heading">Chat sign in</h2>
			<label for="nickname">Nickname</label> <input type="text" class="input-block-level" placeholder="Nickname" id="nickname">
			<div class="btn-group">
				<label for="chatroom">Chatroom</label> <select size="1" id="chatroom">
					<option>arduino</option>
					<option>java</option>
					<option>groovy</option>
					<option>scala</option>
				</select>
			</div>
			<button class="btn btn-large btn-primary" type="submit" id="enterRoom">Sign in</button>
		</form>
	</div>
	<!-- /container -->

	<div class="container chat-wrapper">
		<form id="do-chat">
			<h2 class="alert alert-success"></h2>
			<table id="response" class="table table-bordered"></table>
			<fieldset>
				<legend>Enter your message..</legend>
				<div class="controls">
					<input type="text" class="input-block-level" placeholder="Your message..." id="message" style="height: 60px" />
					<input type="submit" class="btn btn-large btn-block btn-primary" value="Send message" />
					<button class="btn btn-large btn-block" type="button" id="leave-room">Leave room</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>
