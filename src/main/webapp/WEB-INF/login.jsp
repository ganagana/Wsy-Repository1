<%--
  Created by IntelliJ IDEA.
  User: 17191
  Date: 2020/9/30
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.css"/>
    <link rel="stylesheet" href="../css/login.css"/>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal">
                <span class="heading">登录</span>
                <div class="form-group">
                    <input type="text" class="form-control" id="username" placeholder="手机号">
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="password" placeholder="密码">
                </div>
                <div class="form-group help">
                    <input type="text" class="form-control" id="inputVerify" placeholder="验证码">
                </div>
                <div class="form-group help">
                    <button type="button" class="btn btn-default" onclick="getVerifyCode()">获取验证码</button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-success btn-block" onclick="submitLogin()">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="../js/jquery3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../layer/layer.js"></script>
<script>
    function getVerifyCode() {
        $.ajax({
            type: "post",
            url: "/send/message",
            data: {
                phone: $("#username").val()
            },
            async: true,
            success: function (res) {
                if (!res.status) {
                    layer.msg(res.info, {icon: 2});
                } else {
                    layer.msg("发送成功！");
                }
            }, error: function () {
                layer.msg("未知错误", {icon: 2});
            }
        })
        ;

    }

</script>
</body>
</html>