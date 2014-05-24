define(['modules/myApp','controller/homeController','controller/userDetailController'], function (myApp) {
var templateBasePath='resources/js/app/template'	;
  return myApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
    when('/user', {controller: 'homeController', templateUrl: templateBasePath+'/List.html'}).
    when('/user/:id', {controller: 'userDetailController', templateUrl: templateBasePath+'/userDetail.html'}).
    when('/error',{ templateUrl: templateBasePath+'/error.html'}).
    otherwise({
    	templateUrl: templateBasePath+'/404.html'
      });
  }]);

});