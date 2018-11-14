var sorts=[{sort:'frontend',name:'前端'},{sort:'backend',name:'后端'},{sort:'database',name:'数据库'},{sort:'operation',name:'运维'},{sort:'essay',name:'随笔'}]
var app=angular.module("app",['ngRoute']);
app.config(['$routeProvider','$locationProvider',function($routeProvider,$locationProvider){
    $routeProvider
    .when('/',{template:'我是前端'})
    .when('/:headSort',{templateUrl:'html/main.html',controller:'branch'})
    .otherwise({redirectTo:'/'});
    $locationProvider.html5Mode(true);
   }]);
app.controller('sort',function($scope,$routeParams){
    $scope.sorts=sorts;
});
app.controller("branch",function($scope,$http,$routeParams,$timeout){
	 var headSort=$routeParams.headSort;
	 $http({
	  		method:"post",
	  		url:"blog/"+headSort,
	  		dataType:'json',
	  	}).then(function(request){
	            console.log(request.data);
	            $scope.navs=request.data;
	            
	  	});
});
