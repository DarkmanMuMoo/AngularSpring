
define(['modules/myApp'], function (myApp) {
	myApp.run(['$rootScope', '$location', function ($rootScope, $location) {
	    $rootScope.$on('$routeChangeStart', function (event) {

	    console.log('routeChangeStart');
	    });
	}]);
});


