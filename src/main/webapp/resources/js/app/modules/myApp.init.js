
define(['modules/myApp'], function (myApp) {
	myApp.config(['$provide', function ($provide) {
	
		 $provide.decorator("$exceptionHandler", function($delegate,$injector){
		        return function(exception, cause){
		        	 var location =$injector.get("$location");
		             var message = exception.message;
		             console.log(message);
		             if(message == "can not connect to Server"){
		            	
		            	 location.path('/error');
		             }
		          
		            $delegate(exception, cause);
		        };
		    });
		
	}]);
});


