var js=document.scripts;
var url=js[js.length-1].src;
var $ctx=getQueryString(url,'contextPath');
function getQueryString(url, name) {
    var reg=new RegExp("(\\?|&)"+name+"=([^&]*)(&|$)");
    var r=url.substr(1).match(reg);
    if(r!=null)
        return unescape(r[2]);
    return null;
}
var pageParams={
    bPaginate:true,
    bProcessing:true,
    bLengthChange:false,
    bServerSide:true,
    bSort:false,
    bFilter:false,
    sServerMethod:"POST",
    sPaginationType:"full_numbers",
    sAjaxSource:'aaa',
    iDisplayLength:10,
    oLanguage:{
        sProcessing:"正在加载数据...",
        sSearch:"数据筛选",
        sLengthMenu:"每页显示 _MENU_ 条记录",
        sZeroRecords:"没有符合条件的数据...",
        sInfo:"显示 _START_ 到 _END_；共 _TOTAL_ 条数据",
        sInfoEmpty:"显示 0 至 0 共 0 条数据",
        sInfoFiltered:"(_MAX_)",
        oPaginate:{
            sFirst:"首页",
            sLast:"末页",
            sNext:"下一页",
            sPrevious:"上一页"
        }
    }
};
function openWindow(url, width, height) {
    if(!height){
        height=500;
    }
    if(!width){
        width=750;
    }
    var left=(screen.width-width)/2;
    var top=(screen.height-height)/2;
    var arguments=[];
    arguments.push("height="+height);
    arguments.push(",width="+width);
    arguments.push(",top="+top);
    arguments.push(",left="+left);
    arguments.push(",height="+height);
    arguments.push(",toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
    window.open(url,"openWindow",arguments.join(""));
}
function showTipsDialog(title, message, yesFn, noFn) {
    // 操作结果提示框
    easyDialog.open({
        container:{
            header:'<div style="font-size:15px;">'+title+'</div>',
            content:'<div style="font-size:15px;">'+message+'</div>',
            yesFn:yesFn==true?function(){
                closeDialog();
            }:yesFn,
            noFn:noFn?noFn:false
        }
    });
}

function closeDialog(){
    easyDialog.close();
}

function $sessionAjax(params){
    if(!params){
        return;
    }
    $.ajax({
        url:params.url,
        type:params.type?params.type:'post',
        data:params.data?params.data:{},
        success:function(rsp){
            try {
                if (typeof rsp === 'string') {
                    rsp = eval("("+rsp+")");
                }

                if(rsp.code=='2000'){
                    showTipsDialog('系统提示','登录超时，请重新登录',function(){
                        location.href=$ctx+'/login';
                    });
                }
                else if(params.success && typeof params.success == 'function'){
                    params.success(rsp);
                }
            }catch(e){
                showTipsDialog("错误信息","前端JS错误，请联系管理员",true);
            }
        },
        error:function(data){
            if(params.error && typeof params.error == 'function'){
                params.error(data);
            }
        }
    });
}

function $sessionAjaxSubmit($element,params){
    if(!$element||!params){
        return;
    }
    var options={
        beforeSubmit:function(){
        	if(params.beforeSubmit&&(typeof params.beforeSubmit=='function')){
        		var r=params.beforeSubmit();
        		if(r==false){
        			return r;
        		}
        	}
        },
        success:function(rsp){
            try {
                if (typeof rsp === 'string') {
                    rsp = eval("("+rsp+")");
                }
                if(rsp.code=='2000'){
                    showTipsDialog('系统提示','登录超时，请重新登录',function(){
                        location.href=$ctx+'/login';
                    });
                }
                else if(params.success && typeof params.success == 'function'){
                    params.success(rsp);
                }
            }
            catch (e) {
                showTipsDialog("错误信息","前端JS错误，请联系管理员",true);
            }
        },
        error:function(rsp){
            if(params.error && typeof params.error == 'function'){
                params.error(rsp);
            }
        }
    };
    $element.ajaxSubmit(options);
}

function formatDatetime(datetime) {
    try{
        var date=new Date(datetime),m=date.getMonth()+1,d=date.getDate(),h=date.getHours(),min=date.getMinutes(),s=date.getSeconds();
        var html = [];
        html.push(date.getFullYear());
        html.push('-');
        html.push(m>9?m:('0'+m));
        html.push('-');
        html.push(d>9?d:('0'+d));
        html.push(' ');
        html.push(h>9?h:('0'+h));
        html.push(':');
        html.push(min>9?min:('0'+min));
        html.push(':');
        html.push(s>9?s:('0'+s));
        return html.join('');
    }
    catch(e){
        return '无法格式化: ' + datetime;
    }
}
