<%--
  Created by IntelliJ IDEA.
  User: saber
  Date: 2019/1/3
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!--bootstrap css-->
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="../../bootstrap/validator/css/bootstrapValidator.css"/>
    <!--bootstrap js-->
    <script src="../../jquery/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../bootstrap/validator/js/bootstrapValidator.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            /**
             * 下面是进行插件初始化
             * 你只需传入相应的键值对
             * */
            $('#defaultForm').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {/*输入框不同状态，显示图片的样式*/
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {/*验证*/
                    username: {/*键名username和input name值对应*/
                        message: 'The username is not valid',
                        validators: {
                            notEmpty: {/*非空提示*/
                                message: '用户名不能为空'
                            },
                            stringLength: {/*长度提示*/
                                min: 6,
                                max: 30,
                                message: '用户名长度必须在6到30之间'
                            }/*最后一个没有逗号*/
                        }
                    },
                    password: {
                        message:'密码无效',
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            },
                            stringLength: {
                                min: 6,
                                max: 30,
                                message: '用户名长度必须在6到30之间'
                            }
                        }
                    },
                    email: {
                        validators: {
                            notEmpty: {
                                message: 'The email address is required and can\'t be empty'
                            },
                            emailAddress: {
                                message: 'The input is not a valid email address'
                            }
                        }
                    }
                }
            });

        });
    </script>
</head>
<body>

    <div >
        <div >
            <!-- class都是bootstrap定义好的样式，验证是根据input中的name值 -->
            <form id="defaultForm" method="post" class="form-horizontal" action="ajaxSubmit.php">
                <!-- 下面这个div必须要有，插件根据这个进行添加提示 -->
                <div class="form-group">
                    <label class="col-sm-1 control-label">账号</label>
                    <div class="col-lg-1">
                        <input type="text" class="form-control" name="account" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">姓名</label>
                    <div class="col-lg-5">
                        <input type="text" class="form-control" name="name" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">电话号码</label>
                    <div class="col-lg-5">
                        <input type="text" class="form-control" name="telephone" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">手机号码</label>
                    <div class="col-lg-5">
                        <input type="text" class="form-control" name="phone" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">微信</label>
                    <div class="col-lg-5">
                        <input type="text" class="form-control" name="weChat" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">QQ</label>
                    <div class="col-lg-5">
                        <input type="text" class="form-control" name="qq" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">邮箱地址</label>
                    <div class="col-lg-5">
                        <input type="text" class="form-control" name="email" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Password</label>
                    <div class="col-lg-5">
                        <input type="password" class="form-control" name="password" />
                    </div>
                </div>

                <div class="form-group hidden">
                    <div class="col-lg-9 col-lg-offset-3">
                        <button id="submit" type="submit" class="btn btn-primary">Sign up</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
