<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>设备报修 | 智慧校园报修系统</title>
    <link rel="icon" href="../img/logo.ico">
    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap-Table core CSS -->
    <link href="../css/bootstrap-table.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../css/dashboard.css" rel="stylesheet">
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
                                    <a class="dropdown-item active" href="maintenanceList.jsp">
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
                                    <a class="dropdown-item" href="../equipment/areaList.jsp">
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
            <h2 align="center" style="margin-top: 16px">设备报修管理</h2>
            <!-- toolbar  -->
            <div class="panel panel-primary">
                <div class="panel-body">

                    <!--开始-->

                    <!--A的toolbar-->
                    <c:if test="${sessionScope.loginUser==1}">

                        <div id="toolbar">
                            <form class="form-inline" style="width:100%; margin-bottom: 20px;">
                                <div class="form-group" style="margin-left: 5px;">
                                    <input type="button" value="新增报修" id="addBtn"
                                           data-toggle="modal"
                                           data-target="#addMaintenanceModal" class="btn btn-primary" onclick="initModalPage();">
                                </div>
                                <div class="form-group" style="margin-left: 5px;">
                                    <input type="button" value="删除报修" id="deleteBtn" class="btn btn-info"
                                           onclick="deleteMaintenance()">
                                </div>
                                <div class="form-group" style="margin-left: 5px;">
                                    <input type="button" value="修改报修" id="UserEditBtn"
                                           onclick="updateMaintenanceA()"
                                           class="btn btn-danger">
                                </div>

                                <div class="form-group" style="margin-left: 5px;">
                                    <select class="form-control" id="statusA" name="statusA">
                                        <option value="3">全部</option>
                                        <option value="0">报修中</option>
                                        <option value="1">受理中</option>
                                        <option value="2">已完成</option>
                                    </select>
                                    <label for="queryEquipmentNameA"></label>
                                    <input type="text" id="queryEquipmentNameA" class="form-control" placeholder="设备名称">
                                    <label for="queryEquipmentTypeA"></label>
                                    <input type="text" id="queryEquipmentTypeA" class="form-control" placeholder="设备类型">
                                    <input type="button" class="btn btn-success" id="UserQueryBtn" value="查询"
                                           onclick="queryMaintenance()">
                                </div>
                            </form>
                        </div>

                    </c:if>

                    <!--B的toolbar-->
                    <c:if test="${sessionScope.loginUser==2}">

                    <div id="toolbar">
                        <form class="form-inline" style="width:100%; margin-bottom: 20px;">
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="维修分配" id="AssignEditBtn" class="btn btn-danger"
                                       onclick="updateMaintenanceB()">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <select class="form-control" id="statusB" name="statusB">
                                    <option value="3">全部</option>
                                    <option value="0">报修中</option>
                                    <option value="1">受理中</option>
                                    <option value="2">已完成</option>
                                </select>
                                <label for="queryMaintenanceSN"></label>
                                <input type="text" id="queryMaintenanceSN" class="form-control" placeholder="报修单号">
                                <input type="button" class="btn btn-success" id="AssignQueryBtn" value="查询"
                                       onclick="queryMaintenance()">
                            </div>
                        </form>
                    </div>
                </div>

                </c:if>


                <!--C的toolbar-->
                <c:if test="${sessionScope.loginUser==3}">
                <div>
                    <div id="toolbar">
                        <form class="form-inline" style="width:100%; margin-bottom: 20px;">
                            <div class="form-group" style="margin-left: 5px;">
                                <input type="button" value="更新状态" id="EndEditBtn" class="btn btn-danger"
                                       onclick="updateMaintenanceC()">
                            </div>
                            <div class="form-group" style="margin-left: 5px;">
                                <select class="form-control" id="statusC" name="statusC">
                                    <option value="3">全部</option>
                                    <option value="0">报修中</option>
                                    <option value="1">受理中</option>
                                    <option value="2">已完成</option>
                                </select>
                                <label for="queryEquipmentNameC"></label>
                                <input type="text" id="queryEquipmentNameC" class="form-control" placeholder="设备名称">
                                <label for="queryEquipmentTypeC"></label>
                                <input type="text" id="queryEquipmentTypeC" class="form-control" placeholder="设备类型">
                                <input type="button" class="btn btn-success" id="EndQueryBtn" value="查询"
                                       onclick="queryMaintenance()">
                            </div>
                        </form>

                    </div>

                    </c:if>
                    <!--结束-->

                    <div class="container" style="width:100%;margin-top: 20px;">
                        <!--放一个table元素-->
                        <table id="table" style="width: 1115px;text-align: center" data-detail-view="true"
                               data-detail-view-by-click="true"
                               data-detail-formatter="detailFormatter"></table>
                    </div>
                </div>
            </div>

            <!-- A的区域模态窗体 -->
            <c:if test="${sessionScope.loginUser==1}">
                <div class="modal fade" id="addMaintenanceModal" tabindex="-1" role="dialog"
                     aria-labelledby="addModalLabel">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-myHeader">
                                <h4 class="modal-myTitle">报修单信息</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"
                                        onclick="resetFormA()"><span
                                        aria-hidden="true">&times;</span></button>
                            </div>
                            <div class="modal-body">
                                <form id="addMaintenanceForm" class="form-horizontal" action="maintenance/add"
                                      method="post">
                                    <input type="hidden" name="id" id="maintenanceIdA">
                                    <table id="tableMaintenance" class="table table-bordered table-sm">
                                        <tbody>
                                        <tr>
                                            <td>报修单号</td>
                                            <td>
                                                <input type="text" id="maintenanceSN" name="maintenanceSN"
                                                       class="form-control" placeholder="报修单号">
                                            </td>
                                            <td>楼栋号</td>
                                            <td>
                                                <select class="form-control" id="building" name="building">
                                                    //js加载
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>楼层</td>
                                            <td>
                                                <input type="hidden" id="areaID" name="areaID">
                                                <select class="form-control" id="floor" name="floor">
                                                    <option disabled selected>---请选择楼栋号---</option>
                                                </select>
                                            </td>
                                            <td>设备类型</td>
                                            <td>
                                                <select class="form-control" id="equipmentType" name="equipmentType">
                                                    //js加载
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>设备名</td>
                                            <td>
                                                <input type="hidden" id="equipmentID" name="equipmentID">
                                                <select class="form-control" id="equipmentName" name="equipmentName">
                                                    <option disabled selected>---请选择设备类型---</option>
                                                </select>
                                            </td>
                                            <td>具体位置</td>
                                            <td>
                                                <input type="text" id="location" name="location" class="form-control"
                                                       placeholder="具体位置">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>图片</td>
                                            <td>
                                                <div class="col-sm-8">
                                                    <img id="image" name="image" class="cover-radius"
                                                         src="${pageContext.request.contextPath}/img/upload_img.png"
                                                         width="100%" style="cursor: pointer;">
                                                    <input type="file" id="imageURL" name="imageURL"
                                                           onchange="upload_cover(this)"
                                                           style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; opacity: 0; cursor: pointer;">
                                                    <small class="help-block cover-tips"
                                                           style="color: #dd4b39;display: none;">请上传图片</small>
                                                </div>
                                            </td>
                                            <td>故障描述</td>
                                            <td>
                                                <textarea id="reportContent" name="reportContent" cols="40"
                                                          rows="3"></textarea>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal"><span
                                        class="glyphicon glyphicon-remove" aria-hidden="true"
                                        onclick="resetFormA()"></span>关闭
                                </button>
                                <button type="button" id="addSaveBtn" onclick="addMaintenance()" class="btn btn-primary"
                                        data-dismiss="modal">
                                    <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

            </c:if>


            <!-- B的区域模态窗体 -->
            <c:if test="${sessionScope.loginUser==2}">
                <div class="modal fade" id="updateMaintenanceUserModal" role="dialog" tabindex="-1">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-myHeader ">
                                <h4 class="modal-myTitle">维修分配</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"
                                        onclick="resetFormB()"><span aria-hidden="true">&times;</span></button>
                            </div>
                            <div class="modal-body">
                                <form id="updateMaintenanceUserForm" class="form-horizontal" action="maintenance/add"
                                      method="post">
                                    <input type="hidden" name="id" id="maintenanceIdB">
                                    <div class="form-group">
                                        <label for="maintenanceSNB" class="col-sm-4 control-label">报修单号:</label>
                                        <div class="col-sm-10">
                                            <input type="text" readonly="readonly" name="maintenanceSNB"
                                                   id="maintenanceSNB" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input type="hidden" id="maintenanceUserID" name="maintenanceUserID">
                                        <label for="maintenanceUserName" class="col-sm-4 control-label">维修人:</label>
                                        <div class="col-sm-10">
                                            <select class="form-control" id="maintenanceUserName"
                                                    name="maintenanceUserName">
<%--                                                <option selected disabled>---请分配维修人员---</option>--%>
                                            </select>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal"
                                        onclick="resetFormB()">
                                    取消
                                </button>
                                <button type="button" class="btn btn-primary" onclick="updateMaintenanceUser()">分派人员
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>


            <!-- C的区域模态窗体 -->
            <c:if test="${sessionScope.loginUser==3}">
                <div class="modal fade" id="endMaintenanceModal" role="dialog" tabindex="-1">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-myHeader">
                                <h4 class="modal-myTitle">完成报修</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"
                                        onclick="resetFormC()"><span aria-hidden="true">&times;</span></button>
                            </div>
                            <div class="modal-body">

                                <form id="endMaintenanceForm" class="form-horizontal" action="maintenance/add"
                                      method="post">
                                    <input type="hidden" name="id" id="maintenanceIdC">
                                    <div class="form-group">
                                        <label for="maintenanceSNC" class="col-sm-4 control-label">报修单号：</label>
                                        <div class="col-sm-10">
                                            <input type="text" readonly="readonly" name="status" id="maintenanceSNC"
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="maintenanceContent" class="col-sm-4 control-label">维修详情：</label>
                                        <div class="col-sm-10">
                                            <textarea id="maintenanceContent" name="maintenanceContent" cols="40"
                                                      rows="3"></textarea>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal"
                                        onclick="resetFormC()">
                                    取消
                                </button>
                                <button type="button" class="btn btn-primary" onclick="endMaintenance()">完成订单</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>

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
<!-- ajaxfileupload -->
<script src="../js/ajaxfileupload.js"></script>
<!-- Font-Awesome -->
<script src="../js/font-awesome.min.js"></script>

<script type="text/javascript">
    /*$('#table').bootstrapTable({
        url: 'data1.json',
        striped: true,
        pagination: true,
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
            field: 'maintenanceSN',
            title: '报修单号'
        }, {
            field: 'areaID',
            title: '区域'
        }, {
            field: 'equipmentID',
            title: '设备名称'
        }, {
            field: 'reportUserID',
            title: '报修人'
        }, {
            field: 'status',
            title: '报修状态'
        }]
    });*/
    /*当页面加载完成后，立刻执行这个函数*/
    $(function () {
        initModalPage();
        initTable();
    });

    function initTable() {
        $("#table").bootstrapTable('destroy');
        $("#table").bootstrapTable({
            method: "POST",
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            url: "${pageContext.request.contextPath}/servlet/maintenance/queryList",
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
                checkbox: "true",
            }, {
                field: "id",
                title: "ID",
            }, {
                field: 'maintenanceSN',
                title: '报修单号',
            }, {
                field: 'building',
                title: '楼栋',
            }, {
                field: 'floor',
                title: '楼层',
            }, {
                field: 'equipmentType',
                title: '设备类型',
            }, {
                field: 'equipmentName',
                title: '设备名称',
            }, {
                field: 'reportUserName',
                title: '报修人',
            }, {
                field: 'status',
                title: '报修状态',
                formatter: function (value, row, index) {
                    if (row['status'] === 0) {
                        return '报修';
                    }
                    if (row['status'] === 1) {
                        return '受理';
                    }
                    if (row['status'] === 2) {
                        return '完成';
                    }
                    return value;
                },
            }],
        });
    }

    function queryParam(params) {
        var param = {
            queryStatusA: $("#statusA").val(),
            queryStatusB: $("#statusB").val(),
            queryStatusC: $("#statusC").val(),
            queryEquipmentNameA: $("#queryEquipmentNameA").val(),
            queryEquipmentTypeA: $("#queryEquipmentTypeA").val(),
            queryMaintenanceSN: $("#queryMaintenanceSN").val(),
            queryEquipmentNameC: $("#queryEquipmentNameC").val(),
            queryEquipmentTypeC: $("#queryEquipmentTypeC").val(),
            queryName: $("queryName").val(),
            limit: params.limit, // 页面大小
            offset: params.offset, // 页码
            pageNumber: this.pageNumber,
            pageSize: this.pageSize
        };
        return param;
    }

    //新增报修单
    function addMaintenance() {
        var param = $("#addMaintenanceForm").serializeArray();
        param.push({"name": "imageURL", "value": $("#image").attr("src")});
        console.log(param);
        var id = $("#maintenanceIdA").val();
        var url = "${pageContext.request.contextPath}/servlet/maintenance/add";
        if (id != '') {
            url = "${pageContext.request.contextPath}/servlet/maintenance/update"
        }
        $.ajax({
            url: url,
            method: "post",
            data: param,
            dataType: "json",
            success: function (data) {
                if (data.status = "success") {
                    $("#table").bootstrapTable("refresh");
                    $("#addMaintenanceModal").modal("hide");
                    resetFormA();
                }
                alert(data.message);
            },
            error: function (data) {
                alert("服务器异常！");
            }
        });

    }

    //修改维修人员
    function updateMaintenanceUser() {
        var param = $("#updateMaintenanceUserForm").serializeArray();
        // $.each(param, function (i, field) {
        //     console.log(field.name + ":" + field.value)
        // });
        var url = "${pageContext.request.contextPath}/servlet/maintenance/updateMaintenanceUser";
        $.ajax({
            url: url,
            method: "post",
            data: param,
            dataType: "json",
            success: function (data) {
                if (data.status = "success") {
                    $("#table").bootstrapTable("refresh");
                    $("#updateMaintenanceUserModal").modal("hide");
                    resetFormB();
                }
                alert(data.message);
            },
            error: function (data) {
                alert("服务器异常！");
            }
        });
    }

    //完成维修
    function endMaintenance() {
        var maintenanceContent = $("#maintenanceContent").val();
        var param = $("#endMaintenanceForm").serializeArray();
        if (maintenanceContent === null || maintenanceContent === undefined || maintenanceContent === '') {
            alert("维修描述不能为空！");
            return;
        } else {
            var url = "${pageContext.request.contextPath}/servlet/maintenance/endMaintenance";
        }
        $.ajax({
            url: url,
            method: "post",
            data: param,
            dataType: "json",
            success: function (data) {
                if (data.status = "success") {
                    $("#table").bootstrapTable("refresh");
                    $("#endMaintenanceModal").modal("hide");
                    resetFormC();
                }
                alert(data.message);
            },
            error: function (data) {
                alert("服务器异常！");
            }
        });
    }

    //清空A表单数据
    function resetFormA() {
        document.getElementById("addMaintenanceForm").reset();
        $("#addMaintenanceForm").find('input[type=text],input[type=hidden]').each(function () {
            // 清除 value值
            $(this).val('');
        });
        $(":input","#addMaintenanceForm")
            .not(":button",":reset","hidden","submit")
            .val("")
            .removeAttr("checked")
            .removeAttr("selected");
    }

    //清空B表单数据
    function resetFormB() {
        document.getElementById("updateMaintenanceUserForm").reset();
        $("#updateMaintenanceUserForm").find('input[type=text],input[type=hidden]').each(function () {
            // 清除 value值
            $(this).val('');
        });
    }

    //清空C表单数据
    function resetFormC() {
        document.getElementById("endMaintenanceForm").reset();
        $("#endMaintenanceForm").find('input[type=text],input[type=hidden]').each(function () {
            // 清除 value值
            $(this).val('');
        });
    }

    //删除报修单
    function deleteMaintenance() {
        var rows = $("#table").bootstrapTable('getSelections');
        if (rows.length <= 0) {
            alert("请选择一条记录！");
            return;
        }
        if (rows[0].status === 1) {
            alert("此报修单已在受理中，不可删除！");
            return;
        }
        if (rows[0].status === 2) {
            alert("此报修单已完成，不可删除！");
            return;
        }
        var id = rows[0].id;
        var data = {"id": id};
        $.ajax({
            url: "${pageContext.request.contextPath}/servlet/maintenance/delete",
            method: "post",
            dataType: "json",
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

    //修改报修单
    function updateMaintenanceA() {
        var rows = $("#table").bootstrapTable('getSelections');
        if (rows.length <= 0) {
            alert("请选择一条记录！");
            return;
        }
        if (rows[0].status === 1) {
            alert("此报修单已在受理中，不可修改！！");
            return;
        }
        if (rows[0].status === 2) {
            alert("此报修单已完成，不可修改！！");
            return;
        }
        var row = rows[0];
        console.log(row);
        $("#maintenanceIdA").val(row.id);
        $("#maintenanceSN").val(row.maintenanceSN);
        //$("#building").val(row.building);
        $("#areaID").val(row.areaID);
        //$("#floor option[value='"+row.floor+"']").attr("selected","selected");
        //$("#equipmentType").val(row.equipmentType);
        $("#equipmentID").val(row.equipmentID);
        //$("#equipmentName option[value='"+row.equipmentName+"']").attr("selected","selected");
        $("#reportContent").val(row.reportContent);
        console.log("imageURL: "+row.imageURL);
        if (row.imageURL === undefined){
            $("#image").attr('src',"${pageContext.request.contextPath}/img/upload_img.png");
        } else{
            $("#image").attr('src', row.imageURL);
        }
        $("#location").val(row.location);

        /* 处理update的下拉列表绑定和选择的处理 */
        if (row.id != ''){
            editInitModalPage(row);
        }

        $("#addMaintenanceModal").modal("show");
    }

    //修改指派人
    function updateMaintenanceB() {
        var rows = $("#table").bootstrapTable('getSelections');
        if (rows.length <= 0) {
            alert("请选择一条记录！");
            return;
        }
        if (rows[0].status === 1) {
            alert("此报修单已在受理中，不可重复受理！！");
            return;
        }
        if (rows[0].status === 2) {
            alert("此报修单已完成，不可受理！！");
            return;
        }
        var row = rows[0];
        $("#maintenanceIdB").val(row.id);
        $("#maintenanceSNB").val(row.maintenanceSN);
        $("#maintenanceUserID").val(row.maintenanceUserID);
        //$("#maintenanceUserName").val(row.maintenanceUserName);
        $("#updateMaintenanceUserModal").modal("show");
    }

    //完成报修
    function updateMaintenanceC() {
        var rows = $("#table").bootstrapTable('getSelections');
        if (rows.length <= 0) {
            alert("请选择一条记录！");
            return;
        }
        if (rows[0].status === 0) {
            alert("此报修单还未受理，不可完成！！");
            return;
        }
        if (rows[0].status === 2) {
            alert("此报修单已完成，不可重复完成！！");
            return;
        }
        var row = rows[0];
        $("#maintenanceIdC").val(row.id);
        $("#maintenanceSNC").val(row.maintenanceSN);
        $("#maintenanceContent").val(row.maintenanceContent);

        $("#endMaintenanceModal").modal("show");
    }

    //查询报修单
    function queryMaintenance() {
        $("#table").bootstrapTable("refresh");
    }

    //详细视图
    function detailFormatter(index, row) {
        var id = row.id;
        var maintenanceSN = row.maintenanceSN;
        var building = row.building;
        var floor = row.floor;
        var equipmentType = row.equipmentType;
        var equipmentName = row.equipmentName;
        var reportUserName = row.reportUserName;
        var reportContent = row.reportContent;
        if (reportContent === undefined) {
            reportContent = '';
        }
        var imageURL = row.imageURL;
        var location = row.location;
        var area = building + floor + location;
        var status = row.status;
        if (status === 0) {
            status = '报修';
        }
        if (status === 1) {
            status = '受理';
        }
        if (status === 2) {
            status = '完成';
        }
        var startTime = row.startTime;
        var maintenanceUserName = row.maintenanceUserName;
        var acceptTime = row.acceptTime;
        if (maintenanceUserName === undefined || maintenanceUserName === '') {
            acceptTime = '';
            maintenanceUserName = '';
        }
        if (acceptTime === undefined) {
            acceptTime = '';
        }
        var maintenanceContent = row.maintenanceContent;
        var endTime = row.endTime;
        if (maintenanceContent === undefined || maintenanceContent === '') {
            endTime = '';
            maintenanceContent = '';
        }
        if (endTime === undefined) {
            endTime = '';
        }
        var html = ['<table style="text-align: left" class="table table-bordered table-sm">']
        html.push('<tr><td style="width: 50%"><span><small><b>' + "ID" + ':</b></small> <small>' + id + '</small></span></td>')
        html.push('<td><span><small><b>' + "报修单号" + ':</b></small> <small>' + maintenanceSN + '</small></span></td></tr>')
        html.push('<tr><td><span><small><b>' + "楼栋" + ':</b></small> <small>' + building + '</small></span></td>')
        html.push('<td><span><small><b>' + "楼层" + ':</b></small> <small>' + floor + '</small></span></td></tr>')
        html.push('<tr><td><span><small><b>' + "设备类型" + ':</b></small> <small>' + equipmentType + '</small></span></td>')
        html.push('<td><span><small><b>' + "设备名称" + ':</b></small> <small>' + equipmentName + '</small></span></td></tr>')
        html.push('<tr><td><span><small><b>' + "报修人" + ':</b></small> <small>' + reportUserName + '</small></span></td>')
        html.push('<td><span><small><b>' + "故障描述" + ':</b></small> <small>' + reportContent + '</small></span></td></tr>')
        if (imageURL === undefined) {
            html.push('<tr><td><span><small><b>' + "图片" + ':</b></small> <small>' + "未上传！" + '</small></span></td>')
        } else {
            html.push('<tr><td><span><small><b>' + "图片" + ':</b></small> <img id="imageTable" name="imageTable" class="cover-radius" src="' + imageURL + '"  width="20%"/></a></div></span></td>')
        }
        html.push('<td><span><small><b>' + "详细地址" + ':</b></small> <small>' + area + '</small></span></td></tr>')
        html.push('<tr><td><span><small><b>' + "报修状态" + ':</b></small> <small>' + status + '</small></span></td>')
        html.push('<td><span><small><b>' + "报修时间" + ':</b></small> <small>' + startTime + '</small></span></td></tr>')
        html.push('<tr><td><span><small><b>' + "指派人员" + ':</b></small> <small>' + maintenanceUserName + '</small></span></td>')
        html.push('<td><span><small><b>' + "受理时间" + ':</b></small> <small>' + acceptTime + '</small></span></td></tr>')
        html.push('<tr><td><span><small><b>' + "维修描述" + ':</b></small> <small>' + maintenanceContent + '</small></span></td>')
        html.push('<td><span><small><b>' + "完成时间" + ':</b></small> <small>' + endTime + '</small></span></td></tr></table>')
        return html.join('')
    }
</script>

<script type="text/javascript">
    //修改订单页面的数据回显和下拉列表的选择
    function editInitModalPage(row) {
        if (row == undefined) {
            return;
        }
        $.ajax({
            url: "${pageContext.request.contextPath}/servlet/maintenance/queryEditDataList",
            method: "post",
            data: {
                building: row.building,
                equipmentType: row.equipmentType
            },
            success: function (result) {
                if (result.building != null) {
                    var buildingArray = result.building;
                    if (buildingArray.length != 0) {
                        $("#building").empty()
                            .append("<option disabled selected>---请选择---</option>");
                    }
                    for (var i = 0; i < buildingArray.length; i++) {
                        $("#building")
                            .append("<option value='" + buildingArray[i] + "'>" + buildingArray[i] + "</option>");
                    }
                    $("#building option[value='"+row.building+"']").attr("selected","selected");
                }
                if (result.equipmentType != null) {
                    var equipmentTypeArray = result.equipmentType;
                    if (equipmentTypeArray.length != 0) {
                        $("#equipmentType").empty()
                            .append("<option disabled selected>---请选择---</option>");
                    }
                    for (var i = 0; i < equipmentTypeArray.length; i++) {
                        $("#equipmentType")
                            .append("<option value='" + equipmentTypeArray[i] + "'>" + equipmentTypeArray[i] + "</option>");
                    }
                    $("#equipmentType option[value='"+row.equipmentType+"']").attr("selected","selected");

                }
                if (result.areaInfo) {
                    var areaInfoArray = result.areaInfo;
                    if (areaInfoArray.length != 0) {
                        $("#floor").empty()
                            .append("<option disabled selected>---请选择---</option>");
                    }
                    for (var i = 0; i < areaInfoArray.length; i++) {
                        $("#floor")
                            .append("<option value='" + areaInfoArray[i].floor + "'>" + areaInfoArray[i].floor + "</option>");
                    }
                    $("#floor option[value='"+row.floor+"']").attr("selected","selected");

                }
                if (result.equipmentName) {
                    var equipmentNameArray = result.equipmentName;
                    if (equipmentNameArray.length != 0) {
                        $("#equipmentName").empty()
                            .append("<option disabled selected>---请选择---</option>");
                    }
                    for (var i = 0; i < equipmentNameArray.length; i++) {
                        $("#equipmentName")
                            .append("<option value='" + equipmentNameArray[i].equipmentName + "'>" + equipmentNameArray[i].equipmentName + "</option>");
                    }
                    $("#equipmentName option[value='"+row.equipmentName+"']").attr("selected","selected");

                }
            },
            error: function (error) {
                console.log(error);
            }
        });
        $("#addMaintenanceModal").modal("show");
    }

    //初始化模态框中的数据，下拉列表
    function initModalPage() {
        //楼栋号下拉列表
        //设备类型下拉列表
        $("#floor").empty().append("<option disabled selected>---请选择楼栋号---</option>");
        $("#equipmentName").empty().append("<option disabled selected>---请选择设备类型---</option>");
        $("#maintenanceUserName").empty().append("<option disabled selected>---请分配维修人员---</option>");
        $("#image").attr('src',"${pageContext.request.contextPath}/img/upload_img.png");

        $.ajax({
            url: "${pageContext.request.contextPath}/servlet/maintenance/queryAreaAndEquipList",
            method: "post",
            success: function (result) {
                var r = result;
                if (result.building != null) {
                    var buildingArray = result.building;
                    if (buildingArray.length != 0) {
                        $("#building").empty().append("<option disabled selected>---请选择---</option>");
                    }
                    for (var i = 0; i < buildingArray.length; i++) {
                        $("#building").append(("<option value='" + buildingArray[i] + "'>" + buildingArray[i] + "</option>"));
                    }
                }
                if (result.equipmentType != null) {
                    var equipmentTypeArray = result.equipmentType;
                    if (equipmentTypeArray.length != 0) {
                        $("#equipmentType").empty().append("<option disabled selected>---请选择---</option>");
                    }
                    for (var i = 0; i < equipmentTypeArray.length; i++) {
                        $("#equipmentType").append(("<option value='" + equipmentTypeArray[i] + "'>" + equipmentTypeArray[i] + "</option>"));
                    }
                }
                if (result.maintenanceUser != null && result.maintenanceUserId != null) {
                    var maintenanceUserArray = result.maintenanceUser;
                    var maintenanceUserIdArray = result.maintenanceUserId;
                    if (maintenanceUserIdArray.length != 0) {
                        $("#maintenanceUserName").empty().append("<option disabled selected>---请选择---</option>");
                    }
                    for (var i = 0; i < maintenanceUserArray.length; i++) {
                        $("#maintenanceUserName").append(("<option value='" + maintenanceUserIdArray[i] + "'>ID：" + maintenanceUserIdArray[i] + "维修人：" + maintenanceUserArray[i] + "</option>"));
                    }
                }
            }
        })
    }

    //根据选择的楼栋名/设备类型更新楼层/设备名称
    $(document).ready(function () {
        //building select的change事件
        $("#building").change(function () {
            var item = $("#building").val();
            $.ajax({
                url: "${pageContext.request.contextPath}/servlet/maintenance/queryFloorByBuilding",
                method: "post",
                data: {
                    building: item
                },
                success: function (result) {
                    if (result) {
                        $("#floor").empty().append("<option disabled selected>---请选择楼栋号---</option>");
                        for (var i = 0; i < result.length; i++) {
                            $("#floor").append(("<option value='" + result[i].id + "'>" + result[i].floor + "</option>"));
                        }
                    }
                }
            })
        })
        //equipmentType select的change事件
        $("#equipmentType").change(function () {
            var item = $("#equipmentType").val();
            $.ajax({
                url: "${pageContext.request.contextPath}/servlet/maintenance/queryEquipNameByEquipType",
                method: "post",
                data: {
                    equipmentType: item
                },
                success: function (result) {
                    if (result) {
                        $("#equipmentName").empty().append("<option disabled selected>---请选择设备类型---</option>");
                        for (var i = 0; i < result.length; i++) {
                            $("#equipmentName").append(("<option value='" + result[i].id + "'>" + result[i].equipmentName + "</option>"));
                        }
                    }
                }
            })
        })
    })

</script>
<script>
    function upload_cover(obj) {
        ajax_upload(obj.id, function (data) {
            var basePath = '${pageContext.request.contextPath}';
            var isrc = data.relatPath.replace(/\/\//g, '/');
            var imgSrc = basePath + isrc;
            $('#image').attr('src', basePath + isrc).data('img-src', isrc);
        });
    }

    function ajax_upload(feid, callback) {
        if (image_check(feid)) {
            $.ajaxFileUpload({
                fileElementId: feid,
                url: '${pageContext.request.contextPath}/servlet/maintenance/upload',
                type: 'post',
                dataType: 'json',
                secureuri: false,
                async: true,
                success: function (data) {
                    if (callback) callback.call(this, data);
                },
                error: function (data, status, e) {
                    console.error(e);
                }

            })
        }
    }

    function image_check(feid) {
        var img = document.getElementById(feid);
        return /.(jpg|png|gif|bmp)$/.test(img.value) ? true : (function () {
            modals.info('图片格式仅支持jpg、png、gif、bmp');
            return false;
        })();
    }
</script>
</body>
</html>
