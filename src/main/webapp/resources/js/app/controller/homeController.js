
define(['modules/myApp','service/userService'], function (myApp) {
	myApp.controller('homeController', ['$scope','user',function ($scope,user) {

    
		var fetch=function(pageNo){
			user.get({page:pageNo}).$promise.then(function(response) {
				$scope.users = response.results;
				$scope.totalItems=response.totalAmount;
			});
		}

        $scope.init=function(){
        	fetch(1);
        }
		$scope.setPage = function (pageNo) {
			fetch(pageNo);
		};

		$scope.init();

	}]);
});


