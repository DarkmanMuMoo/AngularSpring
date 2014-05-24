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
	<div ng-view ></div>
</body>
</html>
<script data-main="${pageContext.request.contextPath}/resources/js/main" src="${pageContext.request.contextPath}/resources/js/require.js" > </script>
