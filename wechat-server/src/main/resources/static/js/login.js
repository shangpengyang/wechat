function inputFile(){
    // 导入模板
    $('#userImport').click();
}
// 导入模板后上传附件
//当隐藏域input获取焦点后，触发onchange事件
function uploadFiles(){
    //判断文件是否为空
    if($('#userImport')[0].files.length==0){return}
    var file = new FormData();
     
    file.append('file', $('#userImport')[0].files[0]);
    //加载层  在文件上传中出现
    var load_cover =layer.load(0, {
        shade: [0.3,'#fff']
    });
    console.log(file);
    $.ajax({
        url: baseurl+'/project/projectUpload',
        type: 'POST',
        cache: false,
        data: file,
        processData: false,
        contentType: false
    }).done(function(res) {
        if(res.code==0){
            alert(res.msg);
            // layer.alert(res.message);
            //刷新
            jQuery("#list2").trigger("reloadGrid");
        }else{
            alert(res.msg);
        } 
        //ajax执行完成，即文件上传文成，关闭加载层
        layer.close(load_cover);
        //console.log(res);
    }).fail(function(res) {
    //ajax执行完成，即文件上传文成，关闭加载层
       layer.close(load_cover);
        layer.alert(res.message);
    });
}

function check123() {
	var a = document.getElementById('username').value;
	var b = document.getElementById('password').value;
	var c = document.getElementById('Username').value;
	var d = document.getElementById('Password').value;
	if (a != c)
		alert("name error!");
	else if (b != d)
		alert("password error!");
	else
		alert("Welcome!");
}


$("#import").click(function(){//点击导入按钮，使files触发点击事件，然后完成读取文件的操作。
    $("#files").click();
});

function import(){
var selectedFile = document.getElementById("files").files[0];//获取读取的File对象
var name = selectedFile.name;//读取选中文件的文件名
var size = selectedFile.size;//读取选中文件的大小
console.log("文件名:"+name+"大小："+size);

var reader = new FileReader();//这里是核心！！！读取操作就是由它完成的。
reader.readAsText(selectedFile);//读取文件的内容

reader.onload = function(){
    console.log(this.result);//当读取完成之后会回调这个函数，然后此时文件的内容存储到了result中。直接操作即可。
};
}