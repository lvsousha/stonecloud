<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    <%@include file="../../head.jsp"%>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Meta, title, CSS, favicons, etc. -->
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <title>Gentelella Alela! | </title>
        </head>

        <body class="nav-md">
            <div class="container body">
                <div class="main_container">
                    <%@include file="../../left/left.jsp"%>
                        <%@include file="../../top/top.jsp"%>

                            <!-- page content -->
                            <%@include file="pdf.jsp"%>
                                <!-- /page content -->

                                <!-- footer content -->
                                <footer>
                                    <div class="pull-right">
                                        Gentelella - Bootstrap Admin Template by Colorlib. More Templates
                                        <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from
                                        <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
                                    </div>
                                    <div class="clearfix"></div>
                                </footer>
                                <!-- /footer content -->
                </div>
            </div>

        </body>
        <%@include file="../../foot.jsp"%>
            <script>
                var curWwwPath = window.document.location.href;
                var pathName = window.document.location.pathname;
                var pos = curWwwPath.indexOf(pathName);
                var localhostPath = curWwwPath.substring(0, pos);
                var context = "${context}";
                var resource = "${resource}";
                </script>
            <script src="${resource}/app/pdf/pdfobject/pdfobject.js?rand=${rand}"></script>
            <script src="${resource}/app/pdf/pdf.js?rand=${rand}"></script>

    </html>