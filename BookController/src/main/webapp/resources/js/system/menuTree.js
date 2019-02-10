

function loadTreeData() {
	var data;
	$.ajax({
        url: "/system/menu/queries.action",
        type: "post",
        async: false,
        data: {
        	dataReturnType: 1
        },
        success:function(res){
        	data = res.data;
        },
        error:function(e){
            alert("错误！！");
           
        }
    }); 
	return data;
}

var zTreeObj;

function initTree(setting) {
	var zNodes = loadTreeData();
	zTreeObj = $.fn.zTree.init($("#menuTree"), setting, zNodes);
	zTreeObj.expandAll(true);
}