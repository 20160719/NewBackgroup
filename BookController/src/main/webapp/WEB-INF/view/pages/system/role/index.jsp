<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>角色管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../../../../../../url.jsp"%>
<%@include file="../../../../../../jquery.jsp"%>
<%@include file="../../../../../../layui.jsp"%>
<%@include file="../../../../../../ztree.jsp"%>
<script type="text/javascript" src="<%=basePath%>/resources/js/system/menuTree.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/system/role.js"></script>
</head>
<body>

	<div class="layui-form" style="margin-top: 20px;">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">角色名称</label>
				<div class="layui-input-inline">
					<input type="text" id="name" name="name" placeholder="请输入角色名称"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<button class="layui-btn" id="qryBtn">查询</button>
				<button class="layui-btn" id="addBtn">新增</button>
			</div>
		</div>
	</div>

	<table id="roleTab" lay-filter="roleTab" lay-data="{id: 'roleTab'}"></table>
	
	<script type="text/html" id="useTypeTmp">
    {{#  if(d.useType == 0){ }}
    	空目录
    {{#  } else if(d.useType == 1){ }}
    	页面跳转
    {{#  } else if(d.useType == 1){ }}
		数据操作
    {{#  } }}
	</script>

	<script type="text/html" id="opBar">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		<a class="layui-btn layui-btn-xs" lay-event="permAssig">权限分配</a>
	</script>

	<div id="operate" style="display: none; margin-top: 20px; margin-right: 40px;">
		<form id="form" class="layui-form" lay-filter="role">
			<input type="hidden" id="id" name="id">
			<input type="hidden" id="pId" name="pId">
			<div class="layui-form-item">
				<label class="layui-form-label">角色名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" lay-verify="required"
						placeholder="请输入角色名称" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">角色描述</label>
				<div class="layui-input-block">
					<input type="text" name="description" lay-verify="required"
						placeholder="请输入菜单描述" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="sub">保存</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	
	<div id="menuPanel" style="display: none;">
		<form id="from1" class="layui-form">
			<div class="layui-form-item">
				<div id="menuTree" class="ztree"></div>
				<input type="hidden" id="roleId" name="roleId">
				<input type="hidden" id="menuIds" name="menuIds">
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="subTree">保存</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>