<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

		<!-- Latest compiled and minified JavaScript -->
		<script type="txt/JavaScript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

		<!-- Latest compiled and minified JavaScript -->
		<script type="txt/JavaScript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>

		<script type="txt/JavaScript" src="app/app.js"></script>

		<title>Welcome</title>
	</head> 
	<body>
		<c:url value="/showMessage.html" var="messageUrl" />
		<a href="${messageUrl}">Click to enter 1</a>
		<p>
			I am {{4+6}}
		</p>
	</body>
</html>
