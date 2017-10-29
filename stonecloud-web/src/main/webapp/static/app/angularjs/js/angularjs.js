console.log("Refresh Page");
var app = angular.module("app", ["ngRoute"]);
app.config([
  "$routeProvider",
  function($routeProvider) {
    $routeProvider
      .when("/", {
        templateUrl: currentResource + "tpl/home.html",
        controller: "homeController"
      })
      .when("/computers", {
        templateUrl: currentResource + "tpl/computers.html",
        controller: "computersController"
      })
      .when("/printers", {
        templateUrl: currentResource + "tpl/printers.html",
        controller: "printersController"
      })
      .otherwise({ redirectTo: "/" });
  }
]);
app.controller("parentController", function($scope, sharedMessage) {
  $scope.common = "我是从父controller传递到子controller的变量";
});
app.controller("homeController", function($scope, sharedMessage) {
  $scope.viewName = "Home";
  sharedMessage.setMessage("我要买电脑");
});
app.controller("computersController", function($scope, sharedMessage) {
  $scope.viewName = "Computers";
  sharedMessage.setMessage("我还需要打印");
});

app.controller("printersController", function($scope, sharedMessage) {
  $scope.viewName = "Printers";
  $scope.sharedMessage = sharedMessage;
  console.log(sharedMessage.getMessage());
  console.log($scope.common);
});
app.service("sharedMessage", function() {
  var message = [];
  this.setMessage = function(message) {
    if(this.message == undefined){
        this.message = [];
    }
    this.message.push(message);
  };
  this.getMessage = function() {
    return this.message;
  };
});
function newFunction() {
    return "我要买电脑";
}

