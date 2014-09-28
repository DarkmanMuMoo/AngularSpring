<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body  data-contextpath="${pageContext.request.contextPath}" >

<nav class="navbar navbar-default" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">MuMoo App</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-5">
          <p class="navbar-text navbar-right">Signed in as <a href="${pageContext.request.contextPath}/j_spring_security_logout" class="btn btn-danger">Logout</a></p>
        </div>
      </div>
    </nav>
<div class="container" ng-view >

</div>
	
	
	
</body>
</html>
<script data-main="${pageContext.request.contextPath}/resources/js/main" src="${pageContext.request.contextPath}/resources/js/require.js" > </script>
