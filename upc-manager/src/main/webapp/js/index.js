$.browser={};
$.browser.mozilla = /firefox/.test(navigator.userAgent.toLowerCase());
$.browser.webkit = /webkit/.test(navigator.userAgent.toLowerCase());
$.browser.opera = /opera/.test(navigator.userAgent.toLowerCase());
$.browser.msie = /msie/.test(navigator.userAgent.toLowerCase());

$(function() {
    var iframe = document.getElementById("content-iframe");
    if (iframe.attachEvent) {
        iframe.attachEvent("onload", function () {
            resetSize();
        });
    } else {
        iframe.onload = function () {
            resetSize();
        };
    }

    $(window).resize(function () {
        resetSize();
    });

    $('.user-footer').on('click','.modifyPassword',function(){
        openWindow($ctx+'/modifyPw',550,300);
    });
});

function goPage(url) {
    document.getElementById('content-iframe').src=url;
}

function relogin(){
    location.href=$ctx+'/logout';
}

function resetSize() {
    var $window=$(window);
    var h1=$window.height() - 60;
    $('#content-iframe').css("height",h1);//.css("width",w1);
    var doc=getDocument("content-iframe");
    if(doc){
        var h2=getScrollHeight(doc);
        var contentdiv=$(doc.getElementById('content'));
        if(contentdiv[0]){
            contentdiv.css("height", h2);
        }
    }
}
function getDocument(id) {
    if($.browser.msie){
        return document.frames[id].document;
    }

    var iframe=document.getElementById(id);
    if(iframe.document){
        return iframe.document;
    }else{
        return iframe.contentWindow.document;
    }
}
function getWindow(id){
    var iframe=document.getElementById(id);
    if(iframe.window){
        return iframe.window;
    }else{
        return iframe.contentWindow;
    }
}
function getScrollHeight(doc)
{
    var scrollHeight=0;
    if(doc.documentElement&&doc.documentElement.scrollHeight)
    {
        scrollHeight=doc.documentElement.scrollHeight;
    }
    else if(doc.body)
    {
        scrollHeight=doc.body.scrollHeight;
    }
    return scrollHeight;
}