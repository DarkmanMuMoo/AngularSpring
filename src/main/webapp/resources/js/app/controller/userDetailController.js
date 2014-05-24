
define(['modules/myApp','service/userService'], function (myApp) {
	myApp.controller('userDetailController', ['$scope','user','$routeParams',function ($scope,userService,$routeParams) {

		$scope.id=$routeParams.id;
		
		var renderUser =function(){
			userService.get({id: $scope.id},function(user){
				$scope.user=user;
				$scope.updateuser=angular.copy(user); 
			});
		};
		
		renderUser();
		
		$scope.showEdit=false;
		
		$scope.EditText=($scope.showEdit)?'Cancle':'Edit Info';
		
		$scope.toggleEdit=function(showEdit){
			$scope.showEdit=!showEdit;
			$scope.EditText=($scope.showEdit)?'Cancle':'Edit Info';
			
		};
		
		$scope.submitForm=function(valid){
			
			if(valid){
				
				userService.update(null,$scope.updateuser,function(result){

                  console.log(result);

				});
				
			}else{
				alert("hey somthing miss");
			}
			
			
		};
	}]);
});


