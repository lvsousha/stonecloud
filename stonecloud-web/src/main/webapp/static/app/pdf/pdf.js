console.log("PDF");
console.log(localhostPath);
console.log(context);
var option = {
    "height": "600px",
    "page":1
};
if(PDFObject.supportsPDFs){
    console.log("可喜可贺，您目前使用的浏览器支持PDFObject");
    PDFObject.embed("/stonecloud/office/toPdf/preview", "#pdfContent", option);
 } else {
    console.log("大事不妙，您目前使用的浏览器不支持PDFObject");
 }
// $(".previewBtn").click(function () {
//     var url = localhostPath+resource + "/app/pdf/pdfjs/web/viewer.html?file=/stonecloud/office/toPdf/preview";
//     console.log(url);
//     window.open(url);

// });