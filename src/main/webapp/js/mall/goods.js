/**
 * Created by saber on 2018/12/13.
 */
$(document).ready(function () {
    goods.initGoodsList(goods.getGoodsListHead(), goods.getGoodsListBody());
});

$('#tb :button').click(function () {
    var toEdit = this.value == '编辑';
    this.value = toEdit ? '确定' : '编辑';
    $(this).closest('tr').find('td').not(':last').each(function () {
        if (toEdit) this.innerHTML = '<input class="text" type="text" value="'+this.innerHTML.replace(/"/g,'&quot;')+'"/>';
        else this.innerHTML = this.firstChild.value.replace(/</g, '&lt;').replace(/>/g, '&gt;');
    });
});

var goods = {
    getGoodsListHead: function () {
        //商品列表head字段数据
        return [//tye img显示图片地址  text文本 progress进度条文本
            {field: "ico", name: "略缩图", type: "img"},
            {field: "id", name: "序号", type: "text"},
            {field: "title", name: "名称", type: "text"},
            {field: "price", name: "价格", type: "text"},
            {field: "isSale", name: "上/下架", type: "text"},
            {field: "count", name: "库存", type: "progress"},
            {field: "createTime", name: "入库时间", type: "text"},
            {field: "sort", name: "排序", type: "text"}
        ];
    },
    getGoodsListBody: function () {
        //商品列表head字段数据
        return [
            {
                id: "1",
                title: "名称1",
                ico: "../../images/faces-clipart/pic-1.png",
                price: "1666",
                isSale: "是",
                sort: "1",
                count: 0.18,
                createTime:"2018-12-13 18:40:22"
            },
            {
                id: "2",
                title: "名称2",
                ico: "../../images/faces-clipart/pic-1.png",
                price: "2666",
                isSale: "是",
                sort: "1",
                count: 1,
                createTime:"2018-12-13 18:40:22"
            },
            {
                id: "3",
                title: "名称3",
                ico: "../../images/faces-clipart/pic-1.png",
                price: "3666",
                isSale: "否",
                sort: "2",
                count: 0.59,
                createTime:"2018-12-13 18:40:22"
            },
            {
                id: "4",
                title: "名称4",
                ico: "../../images/faces-clipart/pic-1.png",
                price: "4666",
                isSale: "是",
                sort: "3",
                count: 0.78,
                createTime:"2018-12-13 18:40:22"
            },
            {
                id: "5",
                title: "名称5",
                ico: "../../images/faces-clipart/pic-1.png",
                price: "5666",
                isSale: "是",
                sort: "5",
                count: 0.36,
                createTime:"2018-12-13 18:40:22"
            }
        ];
    },
    initGoodsList: function (headData, bodyData) {
        $('#goodList').html("<thead><tr></tr></thead><tbody></tbody>");

        //head
        for (var i = 0; i < headData.length; i++) {
            $('#goodList thead tr').append("<th id='" + headData[i].field + "'><h6 class='font-weight-bold text-center'>" + headData[i].name + "</h6></th>");
        }
        $('#goodList thead tr').append("<th><h6 class='font-weight-bold text-center'>操作</h6></th>");
        //body
        for (var j = 0; j < bodyData.length; j++) {
            $('#goodList tbody').append("<tr id='" + bodyData[j].id + "'></tr>");
            for (var k = 0; k < headData.length; k++) {
                if (headData[k].type === "img") {
                    $('#goodList tbody #' + bodyData[j].id).append("<td class='text-center'><img src='" + bodyData[j][headData[k].field] + "' alt='image'></td>");
                } else if (headData[k].type === "progress") {
                    var flag = "bg-danger";//库存警戒色
                    if (bodyData[j][headData[k].field] >= 0.8) {
                        flag = "bg-success";
                    } else if (bodyData[j][headData[k].field] >= 0.6 && bodyData[j][headData[k].field] < 0.8) {
                        flag = "bg-info";
                    } else if (bodyData[j][headData[k].field] >=  0.4 && bodyData[j][headData[k].field] < 0.6) {
                        flag = "bg-primary";
                    } else if (bodyData[j][headData[k].field] >=  0.2 && bodyData[j][headData[k].field] < 0.4) {
                        flag = "bg-warning";
                    }else {
                        flag = "bg-danger";
                    }
                    $('#goodList tbody #' + bodyData[j].id).append("<td class='text-center'> <div class='progress'><div class='progress-bar "+flag+"' role='progressba' style='width: "+bodyData[j][headData[k].field]*100+"%' aria-valuenow='90' aria-valuemin='0' aria-valuemax='100'></div> </div> </td>");
                } else {
                    $('#goodList tbody #' + bodyData[j].id).append("<td class='text-center'>" + bodyData[j][headData[k].field] + "</td>");
                }
            }
            //增删改的按钮
            $('#goodList tbody #' + bodyData[j].id).append("<td class='text-center'><div class='btn-group' role='group' aria-label='Basic example'><button id='update"+bodyData[j].id+"' type='button' class='btn btn-gradient-primary btn-rounded btn-icon'> <i class='mdi mdi-lead-pencil'></i></button><button id='delete"+bodyData[j].id+"' type='button' class='btn btn-gradient-info btn-rounded btn-icon'> <i class='mdi mdi-delete'></i></button></div></td>");
            //增删改按钮事件
            $('#update'+bodyData[j].id).click(function () {
                $('#dialog_simple').dialog('open');
            });

        }

    }
};
