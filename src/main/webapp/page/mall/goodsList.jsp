<%--
  Created by IntelliJ IDEA.
  User: saber
  Date: 2018/12/13
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="../../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../../vendors/css/vendor.bundle.base.css">
    <!-- inject:css -->
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../jquery/css/jquery-ui-1.10.0.custom.css">
    <!-- plugins:js -->
    <script src="../../vendors/js/vendor.bundle.base.js"></script>
    <script src="../../vendors/js/vendor.bundle.addons.js"></script>
    <script src="../../jquery/js/jquery-1.9.0.min.js"></script>
    <script src="../../jquery/js/jquery-ui-1.10.0.custom.min.js"></script>
    <script src="../../js/mall/goods.js"></script>
</head>
<body>
<div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">商品列表</h4>
            <div class="template-demo mt-2">
                <button id="dialog_link" type="button" class="btn btn-outline-primary btn-icon-text">
                    <i class="mdi mdi-library-plus btn-icon-prepend"></i>
                    添加商品
                </button>
                <button type="button" class="btn btn-outline-success btn-icon-text">
                    刷新列表
                    <i class="mdi mdi-google-drive btn-icon-append"></i>
                </button>
            </div>
            <table id="goodList" class="table table-striped"></table>
        </div>
    </div>
</div>
<!-- ui-dialog -->
<div id="dialog_simple" title="新增商品">
    <div class="card">
        <div class="card-body">
            <form class="forms-sample text-right">`
                <div class="form-group row">
                    <label for="type" class="col-sm-2 ">名称</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="type" placeholder="Username">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="title" class="col-sm-2  ">价格</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="title" placeholder="Email">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="des" class="col-sm-2  ">上/下架</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="des" placeholder="Mobile number">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="url" class="col-sm-2  ">库存</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="url" placeholder="Password">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="rewardsRate" class="col-sm-2  ">类别</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="rewardsRate" placeholder="Password">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="interestRate" class="col-sm-2  ">排序</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="interestRate" placeholder="Password">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="uploadImg" class="col-sm-2  ">传图片</label>
                    <div class="col-sm-9">
                                <span tabindex="0" class="text-lg-center" role="button" style="margin-bottom:10px;display: block; border: 1px dashed rgb(217, 217, 217); border-radius: 6px; cursor: pointer; width: 150px; height: 150px; overflow: hidden;">
                                    <input id = "uploadImg" type="file" accept=".png,.jpg,.jpeg,.gif" style="display: none;">
                                    <i class="icon-lg mdi mdi-plus " style="text-align:center;display:block;position: relative;top:50%;transform:translateY(-50%);"></i>
                                </span>
                        <div class="text-left text-secondary ">图标为不小于150*150的等比正方形图片</div>
                    </div>
                </div>
            </form>
        </div>
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
                $(this).dialog("close");
            },
            "取消": function () {
                $(this).dialog("close");
            }
        }
    });
</script>
</html>
