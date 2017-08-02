/**
 * jQuery AutoComplete plugin
 * @author H.CAAHN
 * @date 2016-05-13 create 2016-05-17 modify
 */
(function($) {
	$.extend($,{
		jme:{}
	});
	$.extend($.jme, {
		autoComplete:function(options){
			var $this=this;
			$this.options={
				id:'autoc',
				url:null,
				type:'post',
				data:null, // 静态数据
				dynamicData:null, // 需要实时从表单中获取数据的字段
				beforeSend:null,
				complete:null,
				success:null,
				error:null,
				onclick:null,
				reader:null,// 页面查询数据来源，当用户点击确定后，数据将反写到该输入框内
				writer:null,// 实际数据输入框
				renderTo:null,
				keyProps:{
					data:null,//数据的属性名，如后台返回{"result":true,"data":[{"key":"001","title":"零零壹"}]}，那么该属性值应为："data"
					key:'key', // 实际需要的数据，一般为ID值
					title:'title', // 自动完成的下拉框显示的信息字段
					serverKey:'key'
				},
				properties:{
					width:155,
					top:26,
					left:0,
					fontSize:12
				}
			};

			this.server={
				result:null, // 当前服务器传回的数据
				data:null // 当前服务器数据存放
			}
			
			$.extend($this.options,options);
			
			$this.init=function(){
				var ops=$this.options
				if(!ops.reader){
					return;
				}
				var $reader=$(ops.reader);
				if($reader.length==0){
					return;
				}
				
				if(ops.writer){
					var $writer=$(ops.writer);
					if($writer.length>0){
						ops.writer=$writer;
					}
				}
				
				ops.reader=$reader;
				ops.reader.on('focus',function() {
					ops.finterval=setInterval(function() {
						$this.trigger();
					},100);
				});
				
				ops.reader.on('blur',function() {
					clearInterval(ops.finterval);
				});
			}
			
			$this.trigger=function(){
				var ops=$this.options;
				if(!ops.data){
					ops.data={};
				}
				if(ops.dynamicData){
					for(var key in ops.dynamicData){
						var jQObj;
						if(ops.dynamicData[key] instanceof jQuery){ // jQuery对象
                            jQObj=ops.dynamicData[key];
						}else if(typeof ops.dynamicData[key]=='string'){ // 字符串
							jQObj=$(':input[name="'+ops.dynamicData[key]+'"]');
						}
						ops.data[key]=jQObj.val();
					}
				}

				if(ops.data[ops.keyProps.serverKey]==ops.reader.val()){ //数据重复
					return;
				}
				ops.data[ops.keyProps.serverKey]=ops.reader.val();
				
				var oldtime=ops.ctime;
				ops.ctime=new Date().getTime();
				if(ops.ctime-oldtime<=500){ // 更改频率太快，取消上一次延迟执行函数
					clearInterval(ops.cinterval);
				}
				ops.cinterval=setInterval(function() {
					try{
						$('#'+ops.id).remove();
						$this.load();
					}catch(e){
					}
					clearInterval(ops.cinterval);
				},300);
			};
			
			$this.load=function(){
				var ops=$this.options;
				var server=$this.server;
				if(!ops.data[ops.keyProps.serverKey]){
					if(ops.writer){
						ops.writer.val('');
					}
					return;
				}
				
				if(ops.before && typeof ops.before=='function'){
					var result=ops.before();
					if(result==false){
						return false;
					}
				}
				
				$.ajax({
					url:ops.url,
					type:ops.type,
					data:ops.data,
					method:ops.method,
					beforeSend:ops.beforeSend,
					complete:ops.complete,
					success:function(result){
						server.result=result; // 缓存数据

						// 调用自定义success方法
						if(ops.success && typeof ops.success=='function'){
							ops.success(result);
						}
						onSuccess(ops,server,result);
					},
					error:ops.error
				});
			};
			
			function onSuccess(ops,server,result){
				if(!result){
					return;
				}
				var dp=ops.keyProps.data;
				if(dp){
					result=result[dp];
				}
				if(!result || result.length<=0){
					return;
				}
				
				buildComplete(ops,server,result);
			}
			
			function buildComplete(ops,server,result){
				var top=ops.properties.top;
				var left=ops.properties.left;
				var width=ops.properties.width;
				
				top+=ops.reader.offset().top;
				left+=ops.reader.offset().left;
				width=(!width||width<=0)?ops.reader.width():width;
				
				var key=ops.keyProps.key,title=ops.keyProps.title;
				var html='<div id="'+ops.id+'" ';
				html+='style="z-index:10000;position:fixed;border-radius:3px;border:1px solid #66afe9;background-color:#FFFFFF;cursor:pointer;';
				html+='top:'+top+'px;';
				html+='left:'+left+'px;';
				html+='width:'+width+'px;';
				
				if(ops.properties.fontSize){
					html+='font-size:'+ops.properties.fontSize+'px;';
				}
				
				html+='"';
				html+='>';

				server.data={};
				for(var i=0;i<result.length;i++){
					html+='<div class="jme_autocomplete_item"  rid="'+result[i][key]+'"';
                    html+=' style="height:25px;padding-left:5px;padding-top:5px;">';
					html+=result[i][title];
					html+='</div>';

					// 缓存数据
					server.data[result[i][key]]=result[i];
				}
				html+='</div>';
				$('body').append(html);

				// 鼠标响应事件
				$('.jme_autocomplete_item').mouseover(function(){
					this.style.backgroundColor='#DFDFDF';
				});
				$('.jme_autocomplete_item').mouseout(function(){
					this.style.backgroundColor='#FFFFFF';
				});
				$('.jme_autocomplete_item').on('click',function(){
					var $this=$(this),rid=$this.attr('rid'),rtext=$(this).html();
					ops.writer.val(rid);
					ops.reader.val(rtext);

					// 移除供用户选择的选择框
                    $('#'+ops.id).remove();

                    // 删除当前已记录的查询数据
					ops.data[ops.keyProps.serverKey]='';
					// 调用用户自定义响应函数
					if(ops.onclick && typeof ops.onclick=='function'){
						ops.onclick(rid,server.data[rid],server.result);
					}
				});
				$(document).on('click',function(){
					$('#'+ops.id).remove();
					ops.data[ops.keyProps.serverKey]='';
				});
			}
		}
	});
	
}(jQuery));

//$(function() {
//	var test=new $.jme.autoComplete({
//		id:'test',
//		url:$ctx+'/component/macros/ajaxUser',
//		reader:'input[for="user"]',
//		writer:'input[name="user"]',
//		keyProps:{
//			key:'id',
//			title:'name',
//			serverKey:'key'
//		}
//	});
//	test.init();
//})