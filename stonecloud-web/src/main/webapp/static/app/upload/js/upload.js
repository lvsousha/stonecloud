var startUpload = function() {
	uploader.start();
}
var uploader;
var uploadingTable;
$(document).ready(function(){
	 
	uploader = new plupload.Uploader({
		browse_button : 'upload_btn', // 触发文件选择对话框的按钮，为那个元素id
		url : context + '/content/upload/upload.do', // 服务器端的上传页面地址
		flash_swf_url : 'js/Moxie.swf', // swf文件，当需要使用swf方式进行上传时需要配置该参数
		silverlight_xap_url : 'js/Moxie.xap', // silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
		multipart : true,
		chunk_size : "1kb",
		filters : {
			mime_types : [{
				title : "Zip files",
				extensions : "zip" 
			},{
				title : "Txt files",
				extensions : "txt"
			}],
			prevent_duplicates : true
		}
	});
	uploader.init();
	uploader.bind('FilesAdded', function(uploader, files) {
		console.log("FilesAdded:" + uploader.files.length);
		for(var i=0; i<files.length; i++){
			var file = {
					fileId:files[i].id,
					fileName:files[i].name,
					fileSize:(files[i].size/1024).toFixed(2)+"KB",
					progress:0
			};
			console.log(file);
			uploadingTable.row.add(file).draw();
//			uploadingTable.draw();
		}
	});
	uploader.bind('QueueChanged', function(uploader) {
		for (var i = 0; i < uploader.files.length; i++) {
			var file = uploader.files[i];
		}
	});
	uploader.bind('ChunkUploaded', function(uploader, file, response) {
		var percent = file.percent;
		var data = uploadingTable.row(file.id).data();
		data.progress = percent;
		uploadingTable.row(file.id).data(data).draw();
	});
	uploader.bind('UploadFile', function(uploader, file) {
		console.log("start");
	});
	uploader.bind('FileUploaded', function(uploader, file) {
		var percent = file.percent;
		var data = uploadingTable.row("#"+file.id).data();
		console.log(data);
		data.progress = percent;
		uploadingTable.row("#"+file.id).data(data).draw();
	});

	console.log(context + '/content/upload/getUploadedData.do');
	uploadingTable=$("#uploading_table").DataTable({
			serverSide:false,
			ajax:{
				url:context + '/content/upload/getUploadedData.do',
				type:"GET",
			    contentType: "application/json",
				data:function(d){
					return {
						params:JSON.stringify(d)
					};
				},
				dataSrc:function(json){
					console.log(json);
					return json.data;
				}
			},
			rowId:"fileId",
			columns:[{
				data:"fileId"
			},{
				data:"fileName"
			},{
				data:"fileSize"
			},{
				data:"progress",
				render:function(data, type, row, meta){
					var percent = data*10;
					var html = "<div class='progress progress-striped'>"+
							   "	<div class='progress-bar progress-bar-success' style='width:"+percent+"%'>"+percent+"%</div>"+
							   "</div>"
					return html;
				}
			}],
			language:{
				info:"当前页第一条记录的下标:_START_," +
						"当前页面最后一条记录的下标:_END_," +
						"过滤后的记录数:_TOTAL_," +
						"未过滤的记录数量:_MAX_," +
						"当前页数:_PAGE_," +
						"总页数:_PAGES_",
				lengthMenu: "显示" +
								"<select>"+
							        "<option value='10'>10</option>"+
							        "<option value='20'>20</option>"+
							        "<option value='30'>30</option>"+
							        "<option value='40'>40</option>"+
							        "<option value='50'>50</option>"+
							        "<option value='-1'>所有</option>"+
						        "</select>" +
						    "记录",
				infoEmpty:"未查询到相关记录"
			}
		});
});


