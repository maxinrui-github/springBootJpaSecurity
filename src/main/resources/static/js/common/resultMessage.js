//提示信息
var hintResultMessage = function (result) {
    if(result.status == "success"){
        layer.msg('操作成功!', {icon: 1});
    }else{
        layer.msg('操作失败!', {icon: 2});
    }
}
