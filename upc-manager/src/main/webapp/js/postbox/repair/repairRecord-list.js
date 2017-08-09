var datatable;
$(function() {
    // 定义操作变量
    var $boxGroupId=$('#boxGroupId'), $province=$('#province'), $city=$('#city'), $status=$('#status');
    // 构造datatable对象
    datatable=$('#dataList').dataTable(
        $.extend({},pageParams,{
            sAjaxSource:$ctx+"/postbox/repair/dataList",
            fnServerParams:function(aodata) {
                aodata.push({
                    "name":"history",
                    "value":0
                });
                aodata.push({
                    "name":"boxGroupId",
                    "value":$boxGroupId.val()
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
                    mData:"boxUniqueCode",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"boxCode",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"province",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"city",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"boxGroupName",
                    mRender:function(data, display, record) {
                        return data?data:'';
                    }
                },
                {
                    mData:"status",
                    mRender:function(data, display, record) {
                        if(data=='CHECKING'){
                            return '<label style="color:red">待审核</label>';
                        }else if(data=='PENDING'){
                            return '待处理';
                        }else if(data=='REPAIRING'){
                            return '<label style="color:blue">修理中</label>';
                        }else if(data=='COMPLETE'){
                            return '<label style="color:green;">修理完成</label>';
                        }else if(data=='CANCEL'){
                            return '<label style="color:gray;">修理完成</label>';
                        }
                        return (data==0||data)?data:'';
                    }
                },
                {
                    mData:"applytime",
                    mRender:function(data, display, record) {
                        return data?formatDatetime(data):'';
                    }
                },
                {
                    mData:null,
                    sClass:"text-center",
                    sWidth:null,
                    mRender:function(data, display, record) {
                        var html="";
                        if(record.status=='CHECKING'){
                            html+='<a class="btn btn-primary btn-xs toAudit" fid="'+record.repairRecordId+'" href="javascript:void(0);">&nbsp;审核&nbsp;</a>&nbsp;';
                            html+='<a class="btn btn-success btn-xs toFocusEdit" fid="'+record.repairRecordId+'" href="javascript:void(0);">&nbsp;强制修改&nbsp;</a>&nbsp;';
                        }

                        // if(record.status=='NOACTIVE'){
                        //     html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.boxInfoId+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                        //     html+='<a class="btn btn-success btn-xs toActive" fid="'+record.boxInfoId+'" href="javascript:void(0);">&nbsp;激活&nbsp;</a>&nbsp;';
                        //     html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.boxInfoId+'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        // }else if(record.status=='NORMAL'){
                        //     html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.boxInfoId+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                        //     html+='<a class="btn btn-warning btn-xs toRepair" fid="'+record.boxInfoId+'" href="javascript:void(0);">&nbsp;维修&nbsp;</a>&nbsp;';
                        //     html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.boxInfoId+'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        // }else if(record.status=='DEMISE'){
                        //     html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.boxInfoId+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                        //     html+='<a class="btn btn-success btn-xs toNoActive" fid="'+record.boxInfoId+'" href="javascript:void(0);">&nbsp;恢复&nbsp;</a>&nbsp;';
                        //     html+='<a class="btn btn-warning btn-xs" fid="'+record.boxInfoId+'" style="visibility:hidden">&nbsp;隐藏&nbsp;</a>';
                        // }else if(record.status=='REPAIR'){
                        //     html+='<a class="btn btn-primary btn-xs toEdit" fid="'+record.boxInfoId+'" href="javascript:void(0);">&nbsp;编辑&nbsp;</a>&nbsp;';
                        //     html+='<a class="btn btn-success btn-xs toNormal" fid="'+record.boxInfoId+'" href="javascript:void(0);">&nbsp;恢复&nbsp;</a>&nbsp;';
                        //     html+='<a class="btn btn-danger btn-xs toDemise" fid="'+record.boxInfoId+'" href="javascript:void(0);">&nbsp;注销&nbsp;</a>';
                        // }
                        return html;
                    }
                }]
        })
    );
    // 搜索按钮事件
    $('.search').click(function() {
        search();
    });

    // 弹出箱子组查询界面
    $('form').on('click','#groupName',function(){
        var params='',$province=$('#province').val(),$city=$('#city').val(),$boxGroupId=$('#boxGroupId').val();
        if($province){
            params+='?';
            params+='province='+$province;
        }
        if($city){
            params+=params?'&':'?';
            params+='city='+$city;
        }
        if($boxGroupId){
            params+=params?'&':'?';
            params+='id='+$boxGroupId;
        }
        openWindow($ctx+'/postbox/boxgroup/dialogfind'+params,780,480);
    });

    // 清除箱子组的选择数据
    $('form').on('click','.input-group-addon',function(){
        $('#boxGroupId').val('');
        $('#groupName').val('');
    });

    // 审核
    $('tbody').on("click", '.toAudit', function() {
        var id=$(this).attr("fid");
        openWindow($ctx+'/postbox/repair/toAudit?id='+id,750,420);
    });

    // 强制修改

    // 选择省份，自动级联出城市/地区
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

// 选择箱子组的回调函数
function $callback_selectBoxGroup(id,name){
    $('#boxGroupId').val(id);
    $('#groupName').val(name);
}

function search() {
    datatable.fnClearTable(0);
    datatable.fnDraw();
}
