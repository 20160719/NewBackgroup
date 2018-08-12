

var tableInfo;
var subIndex;

$(function(){
	
	layui.use('table', function(){
		tableInfo = layui.table;
		  
		  //第一个实例
		tableInfo.render({
		    elem: '#menuTab',
		    height: 315,
		    method: 'post',
		    //url: '/system/menu/queries.action', //数据接口
		    page: true, //开启分页
		    cols: [[ //表头
		      {field: 'name', title: '菜单名称', width:160},
		      {field: 'value', title: 'URL', width:160},
		      {field: 'useType', title: '菜单类型', width:160},
		      {field: 'level', title: '层级', width:160},
		      {field: 'seq', title: '序列', width: 160},
		      {field: 'description', title: '描述', width: 160},
		      {field: 'id', title: '操作', width: 160}
		    ]]
		  });
		  
	});
	
	$("#qryBtn").click(function() {
		var name = $("#name").val();
		alert(name)
	});
	
	$("#addBtn").click(function() {
		open("菜单新增", $("#operate"));
	});
	
});

function open(title, dom, area) {
	if(undefined == area) area = ['500px', '400px'];
	subIndex = layer.open({
		title: title,
		type: 1,
		 //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
		content: dom,
		area: area
	});
}

