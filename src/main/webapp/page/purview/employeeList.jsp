<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: saber
  Date: 2018/12/27
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员列表</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="../../plug/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../../plug/vendors/css/vendor.bundle.base.css">
    <!-- inject:css -->
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../plug/jquery/css/jquery-ui-1.10.0.custom.css">
    <!-- plugins:js -->
    <script src="../../plug/vendors/js/vendor.bundle.base.js"></script>
    <script src="../../plug/vendors/js/vendor.bundle.addons.js"></script>
    <script src="../../plug/jquery/js/jquery-1.9.0.min.js"></script>
    <script src="../../plug/jquery/js/jquery-ui-1.10.0.custom.min.js"></script>
    <script src="../../js/purview/purview.js"></script>

    <!--限制表格编辑状态样式-->
    <style type="text/css">
        table, th, td {
            border: 1px solid #328AA4;
        }

        td input {
            border: none;
            width: 100%;
            height: 100%;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function () {
            purview.initEmployeeList("employeeList", purview.getEmployeeListHead(), ${users});
        });
    </script>
</head>
<body>
<div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">管理员列表</h4>
            <div class="template-demo mt-2">
                <button id="dialog_link" type="button" class="btn btn-outline-primary btn-icon-text">
                    <i class="mdi mdi-library-plus btn-icon-prepend"></i>
                    新增员工
                </button>
                <button type="button" class="btn btn-outline-success btn-icon-text">
                    刷新列表
                    <i class="mdi mdi-google-drive btn-icon-append"></i>
                </button>
            </div>
            <table id="employeeList" class="table table-bordered"></table>
        </div>
    </div>
    <!-- ui-dialog -->
    <div id="dialog_simple"  title="新增人员">
        <iframe id="dialog" style="width: 100%;height:70%;border:0;overflow-x: hidden" src="<c:url value="/purview/dialog"/>"></iframe>
        <%--<%@include file="dialog.jsp" %>--%>
    </div>
</div>
</body>
<script>
    // Dialog Link
    $('#dialog_link').click(function () {
        $('#dialog_simple').dialog('open');
        return false;
    });

    // Dialog Simple
    $('#dialog_simple').dialog({
        autoOpen: false,
        width: 600,
        buttons: {
            "确定": function () {
                $("#dialog").contents().find("#submit").click();
            },
            "取消": function () {
                $(this).dialog("close");
            }
        }
    });
</script>
</html>
