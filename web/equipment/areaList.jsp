<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>区域管理 | 智慧校园报修系统</title>
    <link rel="icon" href="../img/logo.ico">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="../css/dashboard.css">
</head>
<body>
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
    <a href="#">
        <c:if test="${sessionScope.loginUser == null}">
            <span><a class="navbar-brand col-sm-3 col-md-2 mr-0" href="../login.jsp">还未登录，请登录</a></span>
        </c:if>
        <c:if test="${sessionScope.loginUser != null}">
            <span><a class="navbar-brand col-sm-3 col-md-2 mr-0" href="../main.jsp">Welcome: ${loginUser}</a></span>
        </c:if>
    </a>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="${pageContext.request.contextPath}/servlet/logoutServlet">Sign out</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="../main.jsp">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-home">
                                <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                                <polyline points="9 22 9 12 15 12 15 22"></polyline>
                            </svg>
                            <span data-feather="home"></span>
                            首页 <span class="sr-only">(current)</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <div id="accordion" class="panel-group">
                            <!-- 主菜单 -->
                            <a class="nav-link active" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseOne">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                     stroke-linejoin="round" class="feather feather-layers">
                                    <polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>
                                    <polyline points="2 17 12 22 22 17"></polyline>
                                    <polyline points="2 12 12 17 22 12"></polyline>
                                </svg>
                                设备报修管理
                            </a>
                            <div id="collapseOne" class="panel-collapse collapse show">
                                <div class="panel-body">
                                    <a class="dropdown-item" href="../equipment/maintenanceList.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                             viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                             stroke-linecap="round" stroke-linejoin="round"
                                             class="feather feather-file-text">
                                            <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                                            <polyline points="14 2 14 8 20 8"></polyline>
                                            <line x1="16" y1="13" x2="8" y2="13"></line>
                                            <line x1="16" y1="17" x2="8" y2="17"></line>
                                            <polyline points="10 9 9 9 8 9"></polyline>
                                        </svg>
                                        设备报修</a>
                                    <a class="dropdown-item" href="../equipment/equipmentList.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                             viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                             stroke-linecap="round" stroke-linejoin="round"
                                             class="feather feather-file-text">
                                            <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                                            <polyline points="14 2 14 8 20 8"></polyline>
                                            <line x1="16" y1="13" x2="8" y2="13"></line>
                                            <line x1="16" y1="17" x2="8" y2="17"></line>
                                            <polyline points="10 9 9 9 8 9"></polyline>
                                        </svg>
                                        设备管理</a>
                                    <a class="dropdown-item active" href="areaList.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                             viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                             stroke-linecap="round" stroke-linejoin="round"
                                             class="feather feather-file-text">
                                            <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                                            <polyline points="14 2 14 8 20 8"></polyline>
                                            <line x1="16" y1="13" x2="8" y2="13"></line>
                                            <line x1="16" y1="17" x2="8" y2="17"></line>
                                            <polyline points="10 9 9 9 8 9"></polyline>
                                        </svg>
                                        区域管理</a>
                                </div>
                            </div>
                        </div>
                    </li>

                    <li class="nav-item">
                        <div id="systemmgr" class="panel-group">
                            <a class="nav-link" data-toggle="collapse" data-parent="#systemmgr"
                               href="#collapseThree2">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                     stroke-linejoin="round" class="feather feather-users">
                                    <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                                    <circle cx="9" cy="7" r="4"></circle>
                                    <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                                    <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                                </svg>
                                系统管理
                            </a>

                            <div id="collapseThree2" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <a class="dropdown-item" href="../system/userList.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                             viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                             stroke-linecap="round" stroke-linejoin="round"
                                             class="feather feather-file-text">
                                            <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                                            <polyline points="14 2 14 8 20 8"></polyline>
                                            <line x1="16" y1="13" x2="8" y2="13"></line>
                                            <line x1="16" y1="17" x2="8" y2="17"></line>
                                            <polyline points="10 9 9 9 8 9"></polyline>
                                        </svg>
                                        用户管理</a>
                                    <a class="dropdown-item" href="../system/roleList.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                             viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                             stroke-linecap="round" stroke-linejoin="round"
                                             class="feather feather-file-text">
                                            <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                                            <polyline points="14 2 14 8 20 8"></polyline>
                                            <line x1="16" y1="13" x2="8" y2="13"></line>
                                            <line x1="16" y1="17" x2="8" y2="17"></line>
                                            <polyline points="10 9 9 9 8 9"></polyline>
                                        </svg>
                                        角色管理</a>
                                    <a class="dropdown-item" href="../system/permissionList.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                             viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                             stroke-linecap="round" stroke-linejoin="round"
                                             class="feather feather-file-text">
                                            <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
                                            <polyline points="14 2 14 8 20 8"></polyline>
                                            <line x1="16" y1="13" x2="8" y2="13"></line>
                                            <line x1="16" y1="17" x2="8" y2="17"></line>
                                            <polyline points="10 9 9 9 8 9"></polyline>
                                        </svg>
                                        权限管理</a>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <h2 align="center" style="margin-top: 16px">区域管理</h2>
            <!-- toolbar  -->
            <div class="panel panel-primary">
                <div class="panel-body">
                    <div id="toolbar">
                        <form class="form-inline" style="width:100%; margin-bottom: 20px;">
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="新增区域" id="addBtn" data-toggle="modal"
                                       data-target="#addAreaModal" class="btn btn-primary">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="删除区域" id="deleteBtn" class="btn btn-info"
                                       onclick="deleteArea()">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="修改区域" id="editBtn" class="btn btn-danger"
                                       onclick="editArea()">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <label for="queryName"></label>
                                <input type="text" id="queryName" class="form-control" placeholder="楼栋名">
                                <input type="button" class="btn btn-success" id="queryBtn" value="查询"
                                       onclick="queryArea()">
                            </div>
                        </form>

                    </div>
                    <div class="container" style="width:100%;margin-top: 20px;">
                        <!--放一个table元素-->
                        <table id="table" style="width: 1115px;text-align: center"></table>
                    </div>
                </div>
            </div>

            <!-- 新增区域模态窗体 -->
            <div class="modal fade" id="addAreaModal" role="dialog" tabindex="-1">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-myHeader">
                            <h4 class="modal-myTitle">区域信息</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"
                                    onclick="resetForm()"><span aria-hidden="true">&times;</span></button>

                        </div>
                        <div class="modal-body">

                            <form id="addAreaForm" class="form-horizontal" action="area/add" method="post">
                                <input type="hidden" name="id" id="areaId">
                                <div class="form-group">
                                    <label for="building" class="col-sm-4 control-label">楼栋名称：</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="building" id="building" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="floor" class="col-sm-4 control-label">楼层：</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="floor" id="floor" class="form-control">
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="resetForm()">
                                取消
                            </button>
                            <button type="button" class="btn btn-primary" onclick="addArea()">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<!-- jQuery -->
<script src="../js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../js/bootstrap.bundle.min.js"></script>
<script src="../js/feather.min.js"></script>
<!-- Bootstrap-table -->
<script src="../js/bootstrap-table.min.js"></script>
<script src="../js/bootstrap-table-zh-CN.min.js"></script>
<!-- Font-Awesome -->
<script src="../js/font-awesome.min.js"></script>

<script type="text/javascript">
    /*$('#table').bootstrapTable({
        url: 'data1.json',
        pagination: true,
        search: true,
        columns: [{
            field: 'id',
            title: 'ID'
        }, {
            field: 'building',
            title: '楼栋'
        }, {
            field: 'floor',
            title: '楼层'
        }]
    });*/
    /*当页面加载完成后，立刻执行这个函数*/
    $(function () {
        initTable();
    });

    function initTable() {
        $("#table").bootstrapTable('destroy');
        $("#table").bootstrapTable({
            method: "POST",
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            url: "${pageContext.request.contextPath}/servlet/area/queryList",
            queryParams: queryParam,
            striped: true,
            pagination: true,
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 5,                       //每页的记录行数（*）
            pageList: [5, 10, 25],        //可供选择的每页的行数（*）
            uniqueId: "id",
            sidePagination: "server", 			//server表示服务端分页，client客户端分页
            singleSelect: true,
            clickToSelect: true,
            showRefresh: true,
            showToggle: true,
            toolbar: "#toolbar",
            columns: [{
                field: "state",
                checkbox: "true"
            }, {
                field: "id",
                title: "ID"
            }, {
                field: 'building',
                title: '楼栋'
            }, {
                field: 'floor',
                title: '楼层'
            }],
        });
    }

    function queryParam(params) {
        var param = {
            queryName: $("#queryName").val(),
            limit: params.limit, // 页面大小
            offset: params.offset, // 页码
            pageNumber: this.pageNumber,
            pageSize: this.pageSize
        };
        return param;

    }

    //新增区域
    function addArea() {
        var param = $("#addAreaForm").serializeArray();
        var id = $("#areaId").val();
        var url = "${pageContext.request.contextPath}/servlet/area/add";
        if (id != '') {
            url = "${pageContext.request.contextPath}/servlet/area/update"
        }
        $.ajax({
            url: url,
            method: "post",
            data: param,
            dataType: "json",
            success: function (data) {
                if (data.status = "success") {
                    $("#table").bootstrapTable("refresh");
                    $("#addAreaModal").modal("hide");
                    resetForm();
                }
                alert(data.message);
            },
            error: function (data) {
                alert("服务器异常！");
            }
        });

    }

    //清空表单数据
    function resetForm() {
        document.getElementById("addAreaForm").reset();
        $("#addAreaForm").find('input[type=text],input[type=hidden]').each(function () {
            // 清除 value值
            $(this).val('');
        });
    }

    //删除区域
    function deleteArea() {

        var rows = $("#table").bootstrapTable('getSelections');
        if (rows.length <= 0) {
            alert("请选择一条记录！");
            return;
        }
        var id = rows[0].id;
        var building = rows[0].building;
        var data = {"id": id, "building": building};
        $.ajax({
            url: "${pageContext.request.contextPath}/servlet/area/delete",
            method: "post",
            dataType: "json",
            //contentType: "application/json;charset=UTF-8",
            contentType: "application/x-www-form-urlencoded",
            data: data,
            success: function (data) {
                alert(data.message);
                $("#table").bootstrapTable("refresh");
            },
            error: function (data) {
                alert("服务器异常！！");
            }

        });
    }

    //修改用户
    function editArea() {
        var rows = $("#table").bootstrapTable('getSelections');
        if (rows.length <= 0) {
            alert("请选择一条记录！");
            return;
        }

        var row = rows[0];
        $("#areaId").val(row.id);
        $("#building").val(row.building);
        $("#floor").val(row.floor);

        $("#addAreaModal").modal("show");

    }

    //查询用户
    function queryArea() {
        $("#table").bootstrapTable("refresh");
    }

</script>

</body>
</html>
