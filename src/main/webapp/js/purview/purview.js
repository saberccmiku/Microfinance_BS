/**
 * Created by saber on 2018/12/27
 */
var purview = {
    getEmployeeListHead: function () {
        //商品列表head字段数据
        return [//tye img显示图片地址  text文本 progress进度条文本
            {field: "id", name: "序号", type: "text"},
            {field: "userId", name: "账号", type: "text"},
            {field: "name", name: "姓名", type: "text"},
            {field: "telephone", name: "电话号码", type: "text"},
            {field: "phone", name: "手机号码", type: "text"},
            {field: "weChat", name: "微信", type: "progress"},
            {field: "qq", name: "QQ", type: "text"},
            {field: "email", name: "邮箱", type: "email"},
            {field: "createTime", name: "创建时间", type: "date"}
        ];
    },
    getEmployeeListBody: function () {
        //商品列表head字段数据
        return [
            {
                id: "1",
                userId: "zhangsan",
                password: "123456",
                ico: "../../images/faces-clipart/pic-1.png",
                name: "张三",
                telephone: "是",
                phone: "1",
                weChat: "10086",
                email: "123456@qq.com",
                createTime: "2018-12-13 18:40:22"
            },
            {
                id: "2",
                userId: "lisi",
                password: "123456",
                ico: "../../images/faces-clipart/pic-1.png",
                name: "李四",
                telephone: "是",
                phone: "1",
                weChat: "10086",
                email: "123456@qq.com",
                createTime: "2018-12-13 18:40:22"
            },
            {
                id: "3",
                userId: "wanagwu",
                password: "123456",
                ico: "../../images/faces-clipart/pic-1.png",
                name: "王五",
                telephone: "是",
                phone: "1",
                weChat: "10086",
                email: "123456@qq.com",
                createTime: "2018-12-13 18:40:22"
            },
            {
                id: "4",
                userId: "zhaoliu",
                password: "123456",
                ico: "../../images/faces-clipart/pic-1.png",
                name: "赵六",
                telephone: "是",
                phone: "1",
                weChat: "10086",
                email: "123456@qq.com",
                createTime: "2018-12-13 18:40:22"
            },
            {
                id: "5",
                userId: "maqi",
                password: "123456",
                ico: "../../images/faces-clipart/pic-1.png",
                name: "马七",
                telephone: "是",
                phone: "1",
                weChat: "10086",
                email: "123456@qq.com",
                createTime: "2018-12-13 18:40:22"
            }
        ];
    },
    initEmployeeList: function (tableId, headData, bodyData) {

        $('#' + tableId).html("<thead><tr></tr></thead><tbody></tbody>");
        //head
        for (var i = 0; i < headData.length; i++) {
            $('#' + tableId + ' thead tr').append("<th id='" + headData[i].field + "'><h6 class='font-weight-bold text-center'>" + headData[i].name + "</h6></th>");
        }
        $('#' + tableId + ' thead tr').append("<th><h6 class='font-weight-bold text-center'>操作</h6></th>");
        //body
        for (var j = 0; j < bodyData.length; j++) {
            var colors = ["table-info", "table-warning", "table-danger", "table-success", "table-primary"];
            $('#' + tableId + ' tbody').append("<tr class='" + colors[j % 5] + "' id='" + bodyData[j].id + "'><form><div>可以哟打啊</div></form></tr>");
            for (var k = 0; k < headData.length; k++) {
                //$('#' + tableId + ' tbody  form').append("<td class='text-center'>" + bodyData[j][headData[k].field] + "</td>");
                 $('#' + tableId + ' tbody  #' + bodyData[j].id).append("<td class='text-center'>" + bodyData[j][headData[k].field] + "</td>");
            }
            //增删改的按钮
            $('#' + tableId + ' tbody #' + bodyData[j].id).append("<td class='text-center'><div class='btn-group' role='group' aria-label='Basic example'><button id='update" + bodyData[j].id + "' type='button' class='btn btn-gradient-primary btn-rounded btn-icon'><i class='mdi mdi-pencil'></i></button><button id='delete" + bodyData[j].id + "' type='button' class='btn btn-gradient-info btn-rounded btn-icon'> <i class='mdi mdi-delete'></i></button></div></td>");

        }
        //增删改按钮事件
        for (var m = 0; m < bodyData.length; m++) {
            $('#update' + bodyData[m].id).click(function () {
                var toEdit = this.innerHTML.indexOf("mdi mdi-pencil") !== -1;
                this.innerHTML = toEdit ? "<i class='mdi mdi-content-save'></i>" : "<i class='mdi mdi-pencil'></i>";
                $(this).closest('tr').find('td').not(':last').each(function () {
                    if (this.cellIndex !== 0 && this.cellIndex !== 9) {
                        if (toEdit) {
                            this.innerHTML = '<input class="text-center" type="text" value="' + this.innerHTML.replace(/"/g, '&quot;') + '"/>';
                        } else {
                            this.innerHTML = this.firstChild.value.replace(/</g, '&lt;').replace(/>/g, '&gt;');

                        }
                    }
                });
            });
        }
    },
    //保存
    saveUserInfo:function () {
        $.ajax({
            url:"",
            type:"POST",
            dataType:"json",
            success:function (data) {//data是默认的，接收前台返回的数据

                alert(JSON.stringify(data));

            }
        });
    }
};
