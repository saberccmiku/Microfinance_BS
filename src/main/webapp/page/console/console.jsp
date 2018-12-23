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
    <title>控制台</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="../../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../../vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- inject:css -->
    <link rel="stylesheet" href="../../css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="../../images/favicon.png"/>


    <!-- plugins:js -->
    <script src="../../vendors/js/vendor.bundle.base.js"></script>
    <script src="../../vendors/js/vendor.bundle.addons.js"></script>
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
<div>
    <div class="content-wrapper">
        <div class="row">
            <div class="col-12">
              <span class="d-flex align-items-center purchase-popup">
                <i class="mdi mdi-compass icon-md text-danger mr-2"></i>
                <p class="text-white">用心生活，开创每一天</p>
                <a href="#" target="_blank" class="btn ml-auto download-button">love live, love life</a>
                <a href="#" target="_blank" class="btn purchase-button">前往签到</a>
                <i class="mdi mdi-close popup-dismiss"></i>
              </span>
            </div>
        </div>
        <div class="page-header">
            <h3 class="page-title">
              <span class="page-title-icon bg-gradient-primary text-white mr-2">
                <i class="mdi mdi-home"></i>
              </span>
                信息概况
            </h3>
            <nav aria-label="breadcrumb">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">
                        <span></span>Overview
                        <i class="mdi mdi-alert-circle-outline icon-sm text-primary align-middle"></i>
                    </li>
                </ul>
            </nav>
        </div>
        <!--卡片1-->
        <div class="row">
            <div class="col-md-4 stretch-card grid-margin">
                <div class="card bg-gradient-danger card-img-holder text-white">
                    <div class="card-body">
                        <img src="../../images/dashboard/circle.svg" class="card-img-absolute" alt="circle-image"/>
                        <h4 class="font-weight-normal mb-3">今日注册会员
                            <i class="mdi mdi-account-multiple-plus mdi-24px float-right"></i>
                        </h4>
                        <h2 class="mb-5">0 人 剩余：2000</h2>
                        <h6 class="card-text">Increased by 60%</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-4 stretch-card grid-margin">
                <div class="card bg-gradient-info card-img-holder text-white">
                    <div class="card-body">
                        <img src="../../images/dashboard/circle.svg" class="card-img-absolute" alt="circle-image"/>
                        <h4 class="font-weight-normal mb-3">今日登录会员
                            <i class="mdi mdi-account-check mdi-24px float-right"></i>
                        </h4>
                        <h2 class="mb-5">0 人</h2>
                        <h6 class="card-text">Decreased by 10%</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-4 stretch-card grid-margin">
                <div class="card bg-gradient-success card-img-holder text-white">
                    <div class="card-body">
                        <img src="../../images/dashboard/circle.svg" class="card-img-absolute" alt="circle-image"/>
                        <h4 class="font-weight-normal mb-3">今日审贷笔数
                            <i class="mdi mdi-database-plus mdi-24px float-right"></i>
                        </h4>
                        <h2 class="mb-5">0 笔</h2>
                        <h6 class="card-text">Increased by 5%</h6>
                    </div>
                </div>
            </div>
        </div>
        <!--卡片2-->
        <div class="row">
            <div class="col-md-4 stretch-card grid-margin">
                <div class="card bg-gradient-primary card-img-holder text-white">
                    <div class="card-body">
                        <img src="../../images/dashboard/circle.svg" class="card-img-absolute" alt="circle-image"/>
                        <h4 class="font-weight-normal mb-3">今日放款总额
                            <i class="mdi mdi-currency-usd mdi-24px float-right"></i>
                        </h4>
                        <h2 class="mb-5">0 元</h2>
                        <h6 class="card-text">Increased by 60%</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-4 stretch-card grid-margin">
                <div class="card bg-gradient-warning card-img-holder text-white">
                    <div class="card-body">
                        <img src="../../images/dashboard/circle.svg" class="card-img-absolute" alt="circle-image"/>
                        <h4 class="font-weight-normal mb-3">今日到期已还款总额
                            <i class="mdi mdi-currency-usd mdi-24px float-right"></i>
                        </h4>
                        <h2 class="mb-5">0 元</h2>
                        <h6 class="card-text">Decreased by 10%</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-4 stretch-card grid-margin">
                <div class="card bg-gradient-secondary card-img-holder text-white">
                    <div class="card-body">
                        <img src="../../images/dashboard/circle.svg" class="card-img-absolute" alt="circle-image"/>
                        <h4 class="font-weight-normal mb-3">今日到期应还款总额
                            <i class="mdi mdi-currency-usd mdi-24px float-right"></i>
                        </h4>
                        <h2 class="mb-5">0 元</h2>
                        <h6 class="card-text">Increased by 5%</h6>
                    </div>
                </div>
            </div>
        </div>
        <!--数据列表-->
        <div class="row" id="dataList">
        </div>
        <div class="page-header">
            <h3 class="page-title">
              <span class="page-title-icon bg-gradient-primary text-white mr-2">
                <i class="mdi mdi-earth-off"></i>
              </span>
                数据分析
            </h3>
            <nav aria-label="breadcrumb">
                <ul class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">
                        <span></span>Overview
                        <i class="mdi mdi-alert-circle-outline icon-sm text-primary align-middle"></i>
                    </li>
                </ul>
            </nav>
        </div>
        <!--统计图demo-->
        <div class="charts">
            <div class="row">
                <div class="col-lg-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">认证通过率近7天统计</h4>
                            <canvas id="lineChart" style="height:250px"></canvas>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">城市TOP</h4>
                            <canvas id="barChart" style="height:230px"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">年龄覆盖率</h4>
                            <canvas id="areaChart" style="height:250px"></canvas>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">放款趋势</h4>
                            <canvas id="doughnutChart" style="height:250px"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">男女比例</h4>
                            <canvas id="pieChart" style="height:250px"></canvas>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">活跃度标记</h4>
                            <canvas id="scatterChart" style="height:250px"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- content-wrapper ends -->
    <!-- partial:partials/_footer.html -->
    <footer class="footer">
        <div class="d-sm-flex justify-content-center">
                    <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">版权 © 2018 <a
                            href="" target="_blank">武汉满购网络科技有限公司</a> 版权所有. </span>
        </div>
    </footer>
    <!-- partial -->
</div>

</body>
