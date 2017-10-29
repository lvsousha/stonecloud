<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html lang="en">

	<head>
	</head>

	<body>
		<!-- page content -->
		<div class="right_col" role="main" ng-app="app">
			<div ng-controller="parentController">
				<h2>AngularJS 路由应用</h2>
				<ul>
					<li><a href="#/">首页</a></li>
					<li><a href="#/computers">电脑</a></li>
					<li><a href="#/printers">打印机</a></li>
					<li><a href="#/blabla">其他</a></li>
				</ul>
				<div ng-view></div>
			</div>
		</div>
		<!-- /page content -->
	</body>

	</html>