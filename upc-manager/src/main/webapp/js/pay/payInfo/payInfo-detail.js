$(function () {
    $("#submitForm").validate({
        focusCleanup: true,
        focusInvalid: false,
        ignore: '',
        showText: true,
        rules: {
            appId: {
                required: true
            },
            apikey: {
                required: true
            },
            appName: {
                required: true
            },
            whiteList: {
                required: true
            },
            status: {
                required: true
            }
        },
        messages: {
            appId: {
                required: "APP_ID编码不允许为空！"
            },
            apikey: {
                required: "APIKEY编码不允许为空！"
            },
            appName: {
                required: "APP_NAME不允许为空！"
            },
            whiteList: {
                required: "白名单列表不允许为空！"
            },
            status: {
                integer: "账号状态不允许为空！"
            }
        }
    });
    $(".submit").on("click", function () {
        var options = {
            beforeSubmit: function () {
                var check = $.fn.validForm();
                if (!check) {
                    return false;
                }
                showTipsDialog("操作提示", "服务器处理中，请稍候...");
            },
            success: function (rsp) {
                if (rsp.code == '1000') {
                    showTipsDialog("保存成功", "数据保存成功！", function () {
                        closeDialog();
                        window.close();
                    });
                    if (window.opener) {
                        opener.search();
                    }
                } else {
                    var msg = rsp.msg ? rsp.msg : "数据保存失败，请联系管理员或稍后再试！";
                    showTipsDialog("错误信息", msg, true);
                }
            },
            error: function (rsp) {
                if (rsp.status == 404 || rsp.status == '404') {
                    showTipsDialog("错误信息", "数据保存失败，无法访问目标地址！", true);
                } else {
                    showTipsDialog("错误信息", "数据保存失败，请联系管理员或稍后再试！", true);
                }
            }
        };
        $sessionAjaxSubmit($("#submitForm"), options);
    });
});

