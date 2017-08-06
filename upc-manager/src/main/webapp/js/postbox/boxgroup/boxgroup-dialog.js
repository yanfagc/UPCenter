var datatable;
$(function() {
    var checkedId=$('#checkedId').val();

    // 定义操作变量
    var $groupName=$('#groupName'), $province=$('#province'), $city=$('#city'), $status=$('#status');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/postbox/boxgroup/dataList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"groupName",
                    "value":$groupName.val()
                });
                aodata.push({
                    "name":"province",
                    "value":$province.val()
                });
                aodata.push({
                    "name":"city",
                    "value":$city.val()
                });
                aodata.push({
                    "name":"status",
                    "value":$status.val()
                });
            },
            aoColumns:[
                {
                    mData:null,
                    mRender:function(data, display, record){
                        var html=[];
                        html.push('<input type="radio" name="lineCheck" value="');
                        html.push(record['boxGroupId']);
                        if(record['boxGroupId']==checkedId){
                            html.push('" checked="true');
                        }
                        html.push('" text="');
                        html.push(record['groupName']);
                        html.push('"/>');
                        console.log(html.join(''));
                        return html.join('');
                    }
                },
                {
                    mData:"groupCode",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"groupName",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"province",
                    mRender:function(data, display, record) {
                        var result=data?data:'';
                        if(record['city']){
                            result+=' / ';
                            result+=record['city'];
                        }
                        return result;
                    }
                },
                {
                    mData:"status",
                    mRender:function(data, display, record) {
                        if(data=='NOACTIVE'){
                            return '未激活';
                        }else if(data=='NORMAL'){
                            return '<label style="color:green">正常</label>';
                        }else if(data=='FROZEN'){
                            return '<label style="color:red">冻结</label>';
                        }else if(data=='DEMISE'){
                            return '<label style="color:gray;">注销</label>';
                        }
                        return (data==0||data)?data:'';
                    }
                }]
        })
    );

    $('#dataList').on('click','tr',function(){
        var value=$(this).find('input[name="lineCheck"]').val();
        $.each($('input[name="lineCheck"]'),function(i,v){
            if($(v).val()==value){
                $(v).prop('checked',true);
            }else{
                $(v).attr('checked',false);
            }
        });
    });

    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });

    // 确定按钮事件
    $('#okBtn').click(function(){
        var $input=$('input[name="lineCheck"]:checked'),
            value=$input.val(),
            text=$input.attr('text');
        if(value&&text){
            opener.$callback_selectBoxGroup(value,text);
            window.close();
        }
    });

    $('.form-inline').on('change','select[name="province"]',function(){
        var province=$(this).find(":selected").attr("area-node");
        if(!province){
            $('select[name="city"]').html('<option value="" area-node=""> --- 选择城市/地区 --- </option>');
            return;
        }
        $sessionAjax({
            url:$ctx+'/basic/area/findByParent?parent='+province,
            type:'get',
            success:function(rsp){
                var html=[];
                html.push('<option value="" area-node=""> --- 选择城市/地区 --- </option>');
                for(var i=0;i<rsp.body.length;i++){
                    html.push('<option value="');
                    html.push(rsp.body[i].name);
                    html.push('" area-node="');
                    html.push(rsp.body[i].node);
                    html.push('">');
                    html.push(rsp.body[i].name);
                    html.push('</option>');
                }
                $('select[name="city"]').html(html.join(''));
            }
        });
    });
});
function search() {
    datatable.fnClearTable(0);
    datatable.fnDraw();
}
