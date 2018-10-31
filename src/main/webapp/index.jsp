<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>登录-验证码</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no,minimal-ui">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
</head>

<body>
    <div id="login" align="center">
        <div class="logo"><h2>java生成验证码</h2></div>
        <div class="nav">
            <form action="<%=basePath%>/login" method="post" >
            
                <div class="form-group">
                    	帐号:<input type="text" name="userName" id="userName"  placeholder="帐号/邮箱/手机号码">
                </div>
                <br/>
                <div class="form-group">
                    	密码:<input type="password" name="passWord" id="passWord"  placeholder="登录密码">
                </div>
                 <br/><br/>
                 <label>验证码：</label>
				<input	type="text" name="checkCode" />
				<img src="<%=basePath%>/verifyCode" onclick=flushCheckCode(this) alt="点击刷新验证码" style="cursor: hand" />
				<br/><br/>
                <div class="forget">
                    <a href="<%=basePath%>/retrieve_pwd">忘记密码？</a>
                </div>
                <br/>
                <div class="button" style="width: 100px;">
                    <button type="submit" id="btn-login" >登录</button>
                </div>
            </form>
            <!-- 提示信息 -->
            <div id="error"></div>
        </div>
    </div>
    
    <script type="text/javascript">
		function flushCheckCode(obj) {
			obj.src = (obj.src + '?' + new Date())
		}
	</script>
	
    <div class="wrap" id="shade" align="center">
        <div class="shade"></div>
    </div>
    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
</body>

</html>