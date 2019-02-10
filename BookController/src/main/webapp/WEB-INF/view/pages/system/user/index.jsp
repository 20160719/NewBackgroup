<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>用户管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../../../../../../url.jsp"%>
<%@include file="../../../../../../jquery.jsp"%>
<%@include file="../../../../../../layui.jsp"%>
<script type="text/javascript" src="<%=basePath%>/resources/js/system/user.js"></script>
</head>
<body>

	<div class="layui-form" style="margin-top: 20px;">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">账号</label>
				<div class="layui-input-inline">
					<input type="text" id="name" name="name" placeholder="请输入账号"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<button class="layui-btn" id="qryBtn">查询</button>
				<button class="layui-btn" id="addBtn">新增</button>
			</div>
		</div>
	</div>

	<table id="userTab" lay-filter="userTab" lay-data="{id: 'userTab'}"></table>

	<script type="text/html" id="opBar">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		<a class="layui-btn layui-btn-xs" lay-event="permAssig">角色分配</a>
	</script>

	<div id="operate" style="display: none; margin-top: 20px; margin-right: 40px;">
		<form id="form" class="layui-form" lay-filter="user">
			<input type="hidden" id="id" name="id">
			<div class="layui-form-item">
				<label class="layui-form-label">账号</label>
				<div class="layui-input-block">
					<input type="text" name="account" lay-verify="required"
						placeholder="请输入账号" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-block">
					<input type="text" name="password" lay-verify="required"
						placeholder="请输入密码" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-block">
					<input type="text" name="name" lay-verify="required"
						placeholder="请输入姓名" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-block">
					<select name="sex" lay-filter="sex">
						<option value="男">男</option>
						<option value="女" selected="">女</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">出生日期</label>
				<div class="layui-input-block">
					<input type="text" name="birthday" id="birthday" lay-verify="required"
						placeholder="请输入出生日期" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">电话号码</label>
				<div class="layui-input-block">
					<input type="text" name="phone" lay-verify="required"
						placeholder="请输入电话号码" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-block">
					<input type="text" name="email" lay-verify="required"
						placeholder="请输入邮箱" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-block">
					<input type="text" name="address" lay-verify="required"
						placeholder="请输入地址" autocomplete="off" class="layui-input">
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
</body>
</html>