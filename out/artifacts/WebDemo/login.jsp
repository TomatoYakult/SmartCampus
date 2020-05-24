<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录 | 智慧校园报修系统</title>
    <link rel="icon" href="img/logo.ico">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

</head>
<body class="text-center">
<form class="form-signin" action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">
    <img class="mb-4" src="img/logo.png" alt="" width="88" height="88">
    <h1 class="h3 mb-3 font-weight-normal">智慧校园报修系统</h1>
    <h2 class="h3 mb-3 font-weight-normal">V1.0</h2>

    <c:if test="${sessionScope.msg != null}">
        <p style="color: red">${msg}</p>
    </c:if>

    <label for="userName" class="sr-only"></label>
    <input type="text" id="userName" name="userName" class="form-control" placeholder="用户名" required autofocus>
    <label for="psw" class="sr-only"></label>
    <input type="password" id="psw" name="psw" class="form-control" placeholder="密　码" required>
    <label for="tryCode" class="sr-only"></label>
    <input type="text" id="tryCode" name="tryCode" class="form-control" placeholder="验证码" required>
    <img id="imgTryCode" height="45px" width="125px" src="${pageContext.request.contextPath}/kaptcha/kaptcha.jpg">
    <a href="#" onclick="changeTryCode()"><span style="margin-left: 15px">看不清，换一张</span></a>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
</form>
<script>
    function changeTryCode() {
        var img = document.getElementById("imgTryCode");
        img.src = "${pageContext.request.contextPath}/kaptcha/kaptcha.jpg?d=" + new Date() * 1;
    }
</script>
</body>
</html>
