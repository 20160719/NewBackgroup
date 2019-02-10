
var layer;
var form;
var tableInfo;
var laydate;
var subIndex;
var act;

$(function(){
	
	layui.use(['layer', 'form', 'table', 'laytpl', 'laydate'], function(){
		layer = layui.layer;
		form = layui.form;
		laydate = layui.laydate;
		tableInfo = layui.table;
		
		laydate.render({
		    elem: '#birthday' //指定元素
		});
		  
		  //第一个实例
		tableInfo.render({
		    elem: '#userTab',
		    height: 315,
		    method: 'post',
		    url: '/system/user/queries.action', //数据接口
		    page: true, //开启分页
		    limit: 20,
		    limits: [10, 20, 30],
		    cols: [[ //表头
		      {field: 'account', title: '账号', width:160},
		      {field: 'name', title: '姓名', width:100},
		      {field: 'sex', title: '性别', width:80},
		      {field: 'birthday', title: '出生日期', width:160},
		      {field: 'phone', title: '电话', width: 160},
		      {field: 'email', title: '邮箱', width: 160},
		      {field: 'address', title: '地址', width: 160},
		      {field: 'id', title: '操作', width: 200, templet: opBar}
		    ]]
		  });
		
		//监听工具条
		tableInfo.on('tool(userTab)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; 
		    if (layEvent === 'del') {
		    	act = 2;
		    	sub(act, {id : data.id});
		    } else if (layEvent === 'edit') {
			    form.val("user", data);
			    open("菜单编辑", $("#operate"));
			    act = 1;
		   }
		});
		
		form.on('submit(sub)', function(data){
			sub(act, data.field);
		    return false;
		});
		  
	});
	
	$("#qryBtn").click(function() {
		var name = $("#name").val();
		tableInfo.reload('userTab', {
		  where: { //设定异步数据接口的额外参数，任意设
			  account: name
		  }
		});
	});
	
	$("#addBtn").click(function() {
		open("菜单新增", $("#operate"));
		act = 0;
	});
	
});

function sub(act, data) {
	var url = "/system/user/"
	if(act == 0) {
		url += "inserts.action";
	} else if(act == 1) {
		url += "updates.action";
	} else if(act == 2) {
		url += "deletes.action";
	}
	$.ajax({
        url: url,
        type: "post",
        data: data,
        success:function(res){
        	layer.msg(res.msg);
        	layer.close(subIndex);
        },
        error:function(e){
            alert("错误！！");
           
        }
    });  
}

function open(title, dom, area) {
	if(undefined == area) area = ['500px', '600px'];
	subIndex = layer.open({
		title: title,
		type: 1,
		 //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
		content: dom,
		area: area
	});
}

