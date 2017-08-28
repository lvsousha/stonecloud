var startUpload = function() {
	uploader.start();
}
var uploader = new plupload.Uploader({
	browse_button : 'upload_btn', // 触发文件选择对话框的按钮，为那个元素id
	url : context + '/content/upload/upload.do', // 服务器端的上传页面地址
	flash_swf_url : 'js/Moxie.swf', // swf文件，当需要使用swf方式进行上传时需要配置该参数
	silverlight_xap_url : 'js/Moxie.xap', // silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
	multipart : true,
	chunk_size : "10MB",
	filters : {
		mime_types : [ {
			title : "Zip files",
			extensions : "zip"
		} ],
		prevent_duplicates : true
	}
});
uploader.init();
uploader.bind('FilesAdded', function(uploader, files) {
	console.log("FilesAdded:" + uploader.files.length);
});
uploader.bind('QueueChanged', function(uploader) {
	for (var i = 0; i < uploader.files.length; i++) {
		var file = uploader.files[i];
	}
});
uploader.bind('ChunkUploaded', function(uploader, file, response) {
	
});
uploader.bind('UploadFile', function(uploader, file) {
	console.log("start");
});
uploader.bind('FileUploaded', function(uploader, file) {

});