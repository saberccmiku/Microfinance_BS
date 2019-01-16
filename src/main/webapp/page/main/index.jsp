<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: saber
  Date: 2018/11/24
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>信贷后台管理系统</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="../../plug/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../../plug/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- inject:css -->
    <link rel="stylesheet" href="../../css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="../../images/favicon.png"/>
    <!--container:css-->
    <link rel="stylesheet" href="../../css/container.css">

    <!-- plugins:js -->
    <script src="../../plug/vendors/js/vendor.bundle.base.js"></script>
    <script src="../../plug/vendors/js/vendor.bundle.addons.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page-->
    <!-- End plugin js for this page-->
    <!-- inject:js -->
    <script src="../../js/core/off-canvas.js"></script>
    <script src="../../js/core/misc.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page-->
    <script src="../../js/core/dashboard.js"></script>
    <!-- End custom js for this page-->
    <!-- Custom js for menu-->
    <script src="../../js/index/menu.js"></script>
    <!-- Custom js for chart-->
    <script src="../../js/index/chart.js"></script>

</head>
<body>
<div  class="outer-container">
    <!--head view-->
    <%@ include file="_navbar.jsp" %>
    <!-- partial -->
    <div class="page-body-wrapper">
        <!--left view-->
        <%@include file="leftMenu.jsp" %>
        <!--main view-->
        <iframe class="content-wrapper" id="rightIFrame" style="width: 100%;height:100%;border:0;" src="<c:url value="/console/index"/>"></iframe>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->

    <!-- container-scroller -->
</div>
</body>

</html>