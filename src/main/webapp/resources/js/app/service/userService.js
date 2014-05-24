define(['modules/myApp'], function (myApp) {

myApp.factory('user' ,['$resource','contextPath',function ($resource,contextPath) {
	
 var getallUrl=contextPath+'/service/user/:id';
	return $resource(getallUrl,null, { 'update': { method:'PUT' } });
	
}]);


});