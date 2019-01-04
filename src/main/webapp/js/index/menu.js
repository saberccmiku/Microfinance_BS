/**
 * Created by saber on 2018/11/25
 */


$(document).ready(function () {
    // 初始化内容
    init();
});

/**
 * 初始化左侧菜单栏
 */
function loadLeftMenu() {
    var meuInfo = [
        {
            code: "console",
            title: "控制台",
            icon: "mdi mdi-airplay menu-icon",
            items: [{title: "信息预览", href: "/console/index", isShow: true}],
            isShow: true
        },
        {
            code: "mallManagement",
            title: "商城管理",
            icon: "mdi mdi-account-multiple menu-icon",
            items: [
                {title: "商品列表", href: "/mall/goodsList", isShow: true},
                {title: "添加商品", href: "../login.jsp", isShow: true},
                {title: "商品分类", href: "../login.jsp", isShow: true},
                {title: "订单管理", href: "../login.jsp", isShow: true},
                {title: "广告设置", href: "../login.jsp", isShow: true}
                ],
            isShow: true
        },
        {
            code: "loanManagement",
            title: "贷款管理",
            icon: "mdi mdi-book-multiple-variant menu-icon",
            items: [
                {title: "借款订单", href: "../login.jsp", isShow: true},
                {title: "放款管理", href: "../login.jsp", isShow: true},
                {title: "还款计划", href: "../login.jsp", isShow: true},
                {title: "逾期订单", href: "../login.jsp", isShow: true}
            ],
            isShow: true
        },
        {
            code: "userManagement",
            title: "用户管理",
            icon: "mdi mdi-air-conditioner menu-icon",
            items: [
                {title: "用户信息", href: "../login.jsp", isShow: true},
                {title: "黑名单", href: "../login.jsp", isShow: true}
            ],
            isShow: true
        },
        {
            code: "riskManagement",
            title: "风控管理",
            icon: "mdi mdi-clipboard-text menu-icon",
            items: [
                {title: "风控报告", href: "../login.jsp", isShow: true},
                {title: "认证项管理", href: "../login.jsp", isShow: true},
                {title: "每日通过率", href: "../login.jsp", isShow: true},
                {title: "用户认证统计", href: "../login.jsp", isShow: true}
            ],
            isShow: true
        },
        {
            code: "postLoanManagement",
            title: "贷后管理",
            icon: "mdi mdi-currency-usd menu-icon",
            items: [
                {title: "催收预警", href: "../login.jsp", isShow: true},
                {title: "催收员统计", href: "../login.jsp", isShow: true},
                {title: "催收人员管理", href: "../login.jsp", isShow: true}
            ],
            isShow: true
        },
        {
            code: "dataStatistics",
            title: "数据统计",
            icon: "mdi mdi-currency-ngn menu-icon",
            items: [
                {title: "每日损益统计", href: "../login.jsp", isShow: true},
                {title: "每日流水统计", href: "../login.jsp", isShow: true},
                {title: "数据日报", href: "../login.jsp", isShow: true}
            ],
            isShow: true
        },
        {
            code: "privilegeManagement",
            title: "权限管理",
            icon: "mdi mdi-sd menu-icon",
            items: [
                {title: "管理员列表", href: "/purview/employeeList", isShow: true},
                {title: "角色管理", href: "../login.jsp", isShow: true},
                {title: "管理员日志", href: "../login.jsp", isShow: true}
            ],
            isShow: true
        },
        {
            code: "promotionChannel",
            title: "推广渠道",
            icon: "mdi mdi-account-multiple-outline menu-icon",
            items: [
                {title: "渠道列表", href: "../login.jsp", isShow: true},
                {title: "渠道统计报表", href: "../login.jsp", isShow: true},
                {title: "渠道管理员", href: "../login.jsp", isShow: true}
                ],
            isShow: true
        },
        {
            code: "ruleEngine",
            title: "规则引擎",
            icon: "mdi mdi-book-multiple-variant menu-icon",
            items: [
                {title: "字段维护", href: "../login.jsp", isShow: true},
                {title: "规则集配置", href: "../login.jsp", isShow: true},
                {title: "规则类型绑定", href: "../login.jsp", isShow: true},
                {title: "规则匹配记录", href: "../login.jsp", isShow: true}
            ],
            isShow: true
        },
        {
            code: "systemConfig",
            title: "系统配置",
            icon: "mdi mdi-settings menu-icon",
            items: [
                {title: "菜单管理", href: "../login.jsp", isShow: true},
                {title: "管理员管理", href: "../login.jsp", isShow: true},
                {title: "角色管理", href: "../login.jsp", isShow: true},
                {title: "系统参数设置", href: "../login.jsp", isShow: true},
                {title: "通知管理", href: "../login.jsp", isShow: true},
                {title: "认证项管理", href: "../login.jsp", isShow: true},
                {title: "借贷产品管理", href: "../login.jsp", isShow: true},
                {title: "极光推送", href: "../login.jsp", isShow: true},
                {title: "APP版本发布", href: "../login.jsp", isShow: true}
            ],
            isShow: true
        }

    ];
    var leftMenuHtml = "";
    for (var i = 0; i < meuInfo.length; i++) {
        var controls = "";
        var itemHtml = "";
        if (meuInfo[i].isShow) {
            if (meuInfo[i].isShow && meuInfo[i].items !== null && meuInfo[i].items.length !== 0) {
                controls += "aria-controls='" + meuInfo[i].code + "'";
                var itemHtmlLi = "";
                for (var j = 0; j < meuInfo[i].items.length; j++) {
                    if (meuInfo[i].items[j].isShow) {
                        itemHtmlLi += "<li class='nav-item'> <a class='nav-link' href='javascript:void(0);' onclick='changeRightView(\""+meuInfo[i].items[j].href+"\")'>" + meuInfo[i].items[j].title + "</a></li>";
                    }

                }
                var divId = " id='" + meuInfo[i].code + "'";
                itemHtml += "<div class='collapse' " + divId + ">"
                    + "<ul class='nav flex-column sub-menu'>" + itemHtmlLi
                    + "</ul>"
                    + "</div>"
            }
            leftMenuHtml += "<li class='nav-item'>"
                + "<a class='nav-link' data-toggle='collapse' href='#" + meuInfo[i].code + "' aria-expanded='false' " + controls + ">"
                + "<span class='menu-title'>" + meuInfo[i].title + "</span>"
                + "<i class='menu-arrow'></i>"
                + "<i class='" + meuInfo[i].icon + "'></i>"
                + "</a>" + itemHtml
                + "</li>";
        }
    }
    $("#left_menu").append(leftMenuHtml);
}

function loadListView() {
    var data = [{
        title: "累计数据",
        data: [{code: 30, value: 31, describe: "历史放款总量", unit: "笔", icon: "mdi mdi-star"},
            {code: "", value: 122, describe: "历史还款总量", unit: "笔", icon: "mdi mdi-sort-ascending"},
            {code: "", value: 66, describe: "历史展期次数", unit: "次", icon: "mdi mdi-sort-ascending"},
            {code: "", value: 55, describe: "历史展期订单", unit: "笔", icon: "mdi mdi-sort-ascending"},
            {code: "", value: 31, describe: "推广渠道总量", unit: "个", icon: "mdi mdi-sort-ascending"},
            {code: "", value: 6, describe: "渠道注册总量", unit: "人", icon: "mdi mdi-sort-ascending"},
            {code: "", value: 1383, describe: "逾期总笔数", unit: "笔", icon: "mdi mdi-sort-ascending"},
            {code: "", value: 18, describe: "再借人数", unit: "笔", icon: "mdi mdi-sort-ascending"}]
    },
        {
            title: "实时数据",
            data: [{code: 30, value: 22, describe: "待还款总余额", unit: "元", icon: "mdi mdi-sort-ascending"},
                {code: "", value: 122, describe: "到期未还款总额", unit: "元", icon: "mdi mdi-sort-ascending"},
                {code: "", value: 66, describe: "累计放款总额", unit: "元", icon: "mdi mdi-sort-ascending"},
                {code: "", value: 55, describe: "累计还款总额", unit: "元", icon: "mdi mdi-sort-ascending"},
                {code: "", value: 31, describe: "展期费用总额", unit: "元", icon: "mdi mdi-sort-ascending"},
                {code: "", value: 6, describe: "逾期金总额", unit: "元", icon: "mdi mdi-sort-ascending"},
                {code: "", value: 1383, describe: "头收服务费", unit: "元", icon: "mdi mdi-sort-ascending"},
                {code: "", value: 18, describe: "渠道获客费", unit: "元", icon: "mdi mdi-sort-ascending"}]
        }
    ];
    var listHtml = "";
    for (var i = 0; i < data.length; i++) {
        var moduleData = data[i];
        var moduleHtml = "";
        moduleHtml += "<ul class='list-ticked' >";
        var row = 0;
        if (moduleData.data.length % 2 !== 0) {
            row = moduleData.data.length / 2 + 1;
        } else {
            row = moduleData.data.length / 2;
        }
        for (var j = 1; j <= row; j++) {
            moduleHtml += "<li class='text-capitalize nav-item font-weight-light'>" +
                "<span style='width:50%;display:inline-block;'><i class=' " + moduleData.data[2 * j - 2].icon + " m-lg-2 text-primary'></i>" + moduleData.data[2 * j - 2].describe + "<span class='font-weight-bold'>" + moduleData.data[2 * j - 2].value + "</span>" + moduleData.data[2 * j - 2].unit + "</span>" +
                "<span style='width:50%;display:inline-block;'><i class=' " + moduleData.data[2 * j - 1].icon + " m-lg-2 text-primary'></i>" + moduleData.data[2 * j - 1].describe + "<span class='font-weight-bold'>" + moduleData.data[2 * j - 1].value + "</span>" + moduleData.data[2 * j - 1].unit + "</span>" +
                "</li>";
        }
        moduleHtml += "</ul>";

        listHtml += "<div class='col-md-6 stretch-card grid-margin'>"
            + "<div class='card card-img-holder text-black'>"
            + "<div class='card-header bg-white'>" + moduleData.title + "</div>"
            + "<div class='card-body'>" + moduleHtml
            + "</div></div></div>";
    }
    $("#dataList").append(listHtml);
}

function init() {
    //左侧菜单
    loadLeftMenu();
    //累计数据与实时数据
    loadListView();
    //柱形图
    chart.loadBarChart();
    //线型图
    chart.loadLineChart();
    //面积图
    chart.loadAreaChart();
    //线型图
    chart.loadDoughnutChart();
    //饼形图
    chart.loadPieChart();
    //散点图
    chart.loadScatterChart();

}
function changeRightView(url) {
    $("#rightIFrame",parent.document.body).attr("src",url);
}
