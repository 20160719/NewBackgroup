<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>菜单管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../../../../../../url.jsp"%>
<%@include file="../../../../../../jquery.jsp"%>
<%@include file="../../../../../../layui.jsp"%>
<script type="text/javascript"
	src="<%=basePath%>/resources/js/system/menu.js"></script>
</head>
<body>

	<div class="layui-form" style="margin-top: 20px;">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">菜单名称</label>
				<div class="layui-input-inline">
					<input type="text" id="name" name="name" placeholder="请输入菜单名称"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<button class="layui-btn" id="qryBtn">查询</button>
				<button class="layui-btn" id="addBtn">新增</button>
			</div>
		</div>
	</div>

	<table id="menuTab" lay-filter="menuTab"></table>

	<div id="operate" style="display: none; margin-top: 20px; margin-right: 40px;">
		<form id="form" class="layui-form">
			<div class="layui-form-item">
				<label class="layui-form-label">菜单名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" lay-verify="required"
						placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单URL</label>
				<div class="layui-input-block">
					<input type="text" name="url" lay-verify="required"
						placeholder="请输入菜单URL" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单类型</label>
				<div class="layui-input-block">
					<select name="useType" lay-filter="useType">
						<option value="0">空目录</option>
						<option value="1" selected="">页面跳转</option>
						<option value="2">数据操作</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单序列</label>
				<div class="layui-input-block">
					<input type="text" name="seq" lay-verify="required"
						placeholder="请输入菜单序列" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单描述</label>
				<div class="layui-input-block">
					<input type="text" name="description" lay-verify="required"
						placeholder="请输入菜单描述" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="sub">保存</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>