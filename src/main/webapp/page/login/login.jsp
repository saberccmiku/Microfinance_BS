<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Purple Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="../../plug/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../../plug/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="../../css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="../../images/favicon.png"/>

    <!-- plugins:js -->
    <script src="../../plug/vendors/js/vendor.bundle.base.js"></script>
    <script src="../../plug/vendors/js/vendor.bundle.addons.js"></script>
    <!-- endinject -->
    <!-- inject:js -->
    <script src="../../js/core/off-canvas.js"></script>
    <script src="../../js/core/misc.js"></script>
    <!-- endinject -->
</head>

<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth">
            <div class="row w-100">
                <div class="col-lg-4 mx-auto">
                    <div class="auth-form-light text-left p-5">
                        <div class="brand-logo">
                            <img src="../../images/logo.svg">
                        </div>
                        <h4>您好！让我们开始吧</h4>
                        <h6 class="font-weight-light">登录继续.</h6>
                        <form id="loginForm" class="pt-3" action="/login/login" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control form-control-lg" id="userId"
                                       placeholder="用户名" name="userId">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control form-control-lg" id="password"
                                       placeholder="密码" name="password">
                            </div>
                            <div class="mt-3 text-danger">${msg}</div>
                            <div class="mt-3">
                                <%--<a id="login"--%>
                                   <%--class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn"--%>
                                   <%--href="<c:url value="/main/index"/>">登陆</a>--%>
                                <input  class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn" type="submit" value="登录">
                            </div>
                            <div class="my-2 d-flex justify-content-between align-items-center">
                                <div class="form-check">
                                    <label class="form-check-label text-muted">
                                        <input type="checkbox" class="form-check-input">
                                        记住密码
                                    </label>
                                </div>
                                <a href="#" class="auth-link text-black">忘记密码?</a>
                            </div>
                            <div class="text-center mt-4 font-weight-light">
                                管理员登陆-<span class="text-primary">Go for it</span>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
</body>
<script>
//    $('#login').click(function () {
//        $("form[name='loginForm']").submit();
//    });
</script>
</html>
