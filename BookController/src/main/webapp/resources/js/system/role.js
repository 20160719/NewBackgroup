
var layer;
var form;
var tableInfo;
var subIndex;
var act;

var setting = {
		check: {
			enable: true,
			chkStyle: "checkbox",
			chkboxType: { "Y": "p", "N": "" }
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: 0,
				level: 0
			}
		},
		callback: {
			onCheck: function(event, treeId, treeNode) {
//				console.log(treeNode)
//				if(treeNode.checked) {
//					treeNode.checked = false;
//				} else {
//					treeNode.checked = true;
//				}
//				zTreeObj.updateNode(treeNode);
			}
		}
	};

$(function(){
	
	initTree(setting);
	
	layui.use(['layer', 'form', 'table', 'laytpl'], function(){
		layer = layui.layer;
		form = layui.form;
		tableInfo = layui.table;
		  
		  //第一个实例
		tableInfo.render({
		    elem: '#roleTab',
		    height: 315,
		    method: 'post',
		    url: '/system/role/queries.action', //数据接口
		    page: true, //开启分页
		    limit: 20,
		    limits: [10, 20, 30],
		    cols: [[ //表头
		      {field: 'name', title: '角色名称', width:160},
//		      {field: 'value', title: 'URL', width:160},
//		      {field: 'useType', title: '角色类型', width:160, templet: useTypeTmp},
//		      {field: 'level', title: '层级', width:160},
//		      {field: 'seq', title: '序列', width: 160},
		      {field: 'description', title: '描述', width: 160},
		      {field: 'id', title: '操作', width: 200, templet: opBar}
		    ]]
		  });
		
		//监听工具条
		tableInfo.on('tool(roleTab)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; 
			if (layEvent === 'edit') {
			    form.val("role", data);
			    open("角色编辑", $("#operate"));
			    act = 1;
		    } else if (layEvent === 'del') {
		    	act = 2;
		    	sub(act, {id : data.id});
		    } else if (layEvent === 'permAssig') {
		    	act = 3;
		    	$("#roleId").val(data.id);
		    	open("请选择菜单", $("#menuPanel"));
		    	//sub(act, {id : data.id});
		    }
		});
		
		form.on('submit(sub)', function(data){
			sub(act, data.field);
		    return false;
		});
		
		form.on('submit(subTree)', function(data){
			var nodes = zTreeObj.getCheckedNodes(true);
			var menuIds = "";
			for(var i = 0, leg = nodes.length; i < leg; i++) {
				menuIds += nodes[i].id;
				if(i < leg - 1) {
					menuIds += ",";
				}
			}
			data.field.menuIds = menuIds;
			sub(act, data.field);
		    return false;
		});
		  
	});
	
	$("#qryBtn").click(function() {
		var name = $("#name").val();
		tableInfo.reload('roleTab', {
		  where: { //设定异步数据接口的额外参数，任意设
			  name: name
		  }
		});
	});
	
	$("#addBtn").click(function() {
		open("角色新增", $("#operate"));
		act = 0;
	});
	
});

function sub(act, data) {
	var url = "/system/role/"
	if(act == 0) {
		url += "inserts.action";
	} else if(act == 1) {
		url += "updates.action";
	} else if(act == 2) {
		url += "deletes.action";
	} else if(act == 3) {
		url = "/system/privilege/inserts.action";
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
	if(undefined == area) area = ['500px', '400px'];
	subIndex = layer.open({
		title: title,
		type: 1,
		 //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
		content: dom,
		area: area,
//		//btn: ['确定', '取消'],
//	    //yes: function(index, layero){
//	    	console.log("aaa");
//	    	var nodes = zTreeObj.getCheckedNodes(true);
//	    	var ids = "";
//    		for(var i = 0, leg = nodes.length; i < leg; i++) {
//    			ids += nodes[i].id;
//    			if(i < leg - 1) {
//    				ids += ",";
//    			}
//    		}
//    		console.log(ids)
//	    },
//	    btn2: function(index, layero){
//	        //按钮【按钮二】的回调
//	        
//	        //return false 开启该代码可禁止点击该按钮关闭
//	    },
//	    cancel: function(){ 
//	    //右上角关闭回调
//	    
//	    //return false 开启该代码可禁止点击该按钮关闭
//	   }
	});
}

