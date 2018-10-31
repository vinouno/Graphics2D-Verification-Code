<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Java生成验证码</title>
</head>
<body>
	<br/><br/>
	<div align="center">
		<h2>Java生成验证码</h2>
		
		<form action="<%=basePath%>/register" method="post">
			<label>用户名：</label>
			<input type="text" name="userName" value="admin" /><br/><br/>  
			<label>密码：</label>
			<input type="password" name="passWord" value="123456"/><br/><br/> 
			<label>验证码：</label>
			<input	type="text" name="checkCode" />
			<img src="<%=basePath%>/verifyCode" onclick=flushCheckCode(this) alt="点击刷新验证码" style="cursor: hand" />
			<br/><br/>
			<input type="submit" value="保存" />
		</form>

	</div>

	<script type="text/javascript">
		function flushCheckCode(obj) {
			obj.src = (obj.src + '?' + new Date())
		}
	</script>
</body>
</html>