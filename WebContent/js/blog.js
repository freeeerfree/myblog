var sorts=[{sort:'',name:'首页'},{sort:'frontend',name:'前端'},{sort:'backend',name:'后端'},{sort:'database',name:'数据库'},{sort:'operation',name:'运维'},{sort:'essay',name:'随笔'}]
var sort=["所有","热门","最新"];
var app=angular.module("app",['ngRoute']);
app.config(['$routeProvider','$locationProvider',function($routeProvider,$locationProvider){
    $routeProvider
    .when('/',{templateUrl:'html/main.html',controller:'sort'})
    .when('/:headSort',{templateUrl:'html/main.html',controller:'branch'})
    .when('/article/id/:id',{templateUrl:'html/article.html',controller:'article'})
    .otherwise({redirectTo:'/'});
    $locationProvider.html5Mode(true);
   }]);
app.controller('sort',function($scope,$routeParams,$http){
    $('nav ul li').removeClass('active');
    $('nav ul li:eq(0)').addClass('active');
    $scope.sorts=sorts;
    $scope.hdefault=0;	
	$scope.navs=sort;
	$scope.getActive=function(index){
	$scope.hdefault=index;
	console.log("我在运行");
	};
	$scope.default=0;
    $scope.onClick=function(index){
    $scope.default=index;
	};
    $http({
    	 method:"post",
    	 url:"main/",
    	 dataType:'json'
     }).then(function(request){
    	 $scope.articles=request.data;                  	 
     });
});
app.controller("branch",function($scope,$http,$routeParams,$timeout){
	    $scope.default=0;
		$scope.onClick=function(index){
		$scope.default=index;
		};
	 var headSort=$routeParams.headSort;
	 $http({
	  		method:"post",
	  		url:"sort/"+headSort,
	  		dataType:'json',
	  	}).then(function(request){
	            $scope.navs=request.data;
                $timeout(function(){
                 	var leftSort=$('.left_nav ul li.active').text();
                     $http({
                     	 method:"post",
                     	 url:"blog/"+leftSort,
                     	 dataType:'json'
                      }).then(function(request){
                     	 $scope.articles=request.data;
                      });
                 	},2);     
	  	});
});
app.controller('article',function($http,$scope){
	 $http({
    	 method:"post",
    	 url:"article/id/1",
    	 dataType:'json'
     }).then(function(request){
    	 $scope.articles=request.data;
    	 var article= $scope.articles;
    	 console.log(article[0].id);
     });
});
