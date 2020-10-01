<%--
  Created by IntelliJ IDEA.
  User: 17191
  Date: 2020/9/29
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap-table.css">
    <script type="text/javascript" src="../js/jquery3.3.1.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap-table-export.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="../layer/layer.js"></script>
</head>
<body>
<div class="panel-body">
    <button id="btn_add" type="button" class="btn btn-info ml10" onclick="addEmployee()">新增</button>
    <table id="tb_employee"></table>
</div>
<!-- 添加用户模态框 -->
<div class="modal fade" id="addEmployeeModel" tabindex="-1" role="dialog" aria-labelledby="userModelLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="addUserInfoForm">
                    <input type="hidden" id="addInputEmployeeId" name="id">
                    <div class="form-group">
                        <label for="addInputEmployeeName" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="addInputEmployeeName" name="username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addInputEmployeePassword" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="addInputEmployeePassword" name="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addInputEmployeeAge" class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="addInputEmployeeAge" name="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="sex" value="male">男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" value="female">女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmployeePhone" class="col-sm-2 control-label">手机号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmployeePhone" name="tel">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmployeeAddress" class="col-sm-2 control-label">居住地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmployeeAddress" name="address">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="addEmployeeBtn">保存</button>
            </div>
        </div>
    </div>
</div>
<!-- 修改用户模态框 -->
<div class="modal fade" id="updateEmployeeModel" tabindex="-1" role="dialog" aria-labelledby="userModelLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="updateEmployeeInfoForm">
                    <input type="hidden" id="updateInputEmployeeId" name="id">
                    <div class="form-group">
                        <label for="updateInputEmployeeName" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="updateInputEmployeeName" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="updateInputEmployeePassword" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="updateInputEmployeePassword" name="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="updateInputEmployeeAge" class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="updateInputEmployeeAge" name="age">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="sex" value="male">男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" value="female">女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="updateInputEmployeePhone" class="col-sm-2 control-label">手机号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="updateInputEmployeePhone" name="phone">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="updateInputEmployeeAddress" class="col-sm-2 control-label">居住地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="updateInputEmployeeAddress" name="address">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="updateEmployeeBtn">保存</button>
            </div>
        </div>
    </div>
</div>
<script>
    function sexFormatter(value, row, index) {
        if (value === "female") {
            return "女";
        } else if (value === "male") {
            return "男";
        }

    }

    //点击添加按钮
    function addEmployee() {
        $("#addEmployeeModel").modal("show");
    }

    /*添加Employee*/
    $("#addEmployeeBtn").click(function () {
        var name = $('#addInputEmployeeName').val();
        var password = $('#addInputEmployeePassword').val();
        var age = $('#addInputEmployeeAge').val();
        var sex = $('input:radio:checked').val();
        var phone = $('#inputEmployeePhone').val();
        var address = $('#inputEmployeeAddress').val();
        $.ajax({
            type: "post",
            url: "/add",
            async: true,
            dataType: "json",
            data: {
                "name": name,
                "password": password,
                "age": age,
                "sex": sex,
                "phone": phone,
                "address": address
            },
            success: function (res) {
                if (res.status) {
                    layer.msg("添加成功");
                    $("#addEmployeeModel").modal("hide");
                    flushTable();
                } else {
                    layer.msg(res.info);
                }
            },
            error: function () {
                layer.msg("未知错误");
            }
        });
    });

    $('#tb_employee').bootstrapTable({
        url: 'getall',
        queryParams: "queryParams",
        toolbar: "#toolbar",
        sidePagination: "true",
        striped: true,
        uniqueId: "ID",
        pageSize: "5",
        pagination: true,
        sortable: true,
        columns: [{
            field: 'name',
            title: '名字'
        },
            {
                field: 'age',
                title: '年龄'
            },
            {
                field: 'sex',
                title: '性别',
                formatter: sexFormatter,
            },
            {
                field: 'phone',
                title: '手机号'
            },
            {
                field: 'address',
                title: '地址'
            },
            {
                field: 'id',
                title: '操作',
                width: 120,
                align: 'center',
                valign: 'middle',
                formatter: actionFormatter,
            },

        ]
    });

    //操作栏的格式化
    function actionFormatter(value, row, index) {
        var id = value;
        var result = "";
        result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
        result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"DeleteByIds('" + id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
        return result;
    }

    //编辑回显
    function EditViewById(id) {
        var str = "";
        $("#updateEmployeeModel").modal("show");
        $.ajax({
            type: "post",
            url: "/get",
            async: false,
            dataType: "json",
            data: {id: id},
            success: function (res) {
                if (res.status) {
                    $("#updateInputEmployeeId").attr("value", res.data.id);
                    $("#updateInputEmployeeName").attr("value", res.data.name);
                    $("#updateInputEmployeePassword").attr("value", res.data.password);
                    $("#updateInputEmployeeAge").attr("value", res.data.age);
                    $("#updateInputEmployeeAddress").attr("value", res.data.address);
                    $("#updateInputEmployeePhone").attr("value", res.data.phone);
                    $("input:radio[name='sex'][value=" + res.data.sex + "]").attr('checked', 'true')

                } else {
                    layer.msg("error");
                    $("#updateEmployeeModel").modal("hide");
                }
            },
            error: function () {
                layer.msg("error");
                $("#updateEmployeeModel").modal("hide");
            }
        });
    }

    //编辑修改
    $("#updateEmployeeBtn").click(function () {
        $.ajax({
            type: "post",
            url: "/update",
            async: true,
            dataType: "json",
            data: $("#updateEmployeeInfoForm").serialize(),
            success: function (res) {
                if (res.status) {
                    layer.msg("修改成功");
                    $("#updateEmployeeModel").modal("hide");
                    flushTable();
                } else {
                    layer.msg(res.info);
                }
            },
            error: function () {
                layer.msg("未知错误");
            }
        });
    });

    //删除
    function DeleteByIds(id) {
        $.ajax({
            url: "/delete",
            async: true,
            data: {id: id},
            dataType: "json",
            success: function (res) {
                if (!res.status) {
                    layer.msg("删除失败");
                } else {
                    layer.msg("删除成功");
                    flushTable();
                }

            }
        });
    }

    function flushTable() {
        $("#tb_employee").bootstrapTable('refresh', {url: '/getall'});
    }
</script>
</body>
</html>
