define([ 'angular', 'angular-resource','angular-route','anguler-bootstrap' ], function(angular) {

	var myApp = angular.module('myApp', ['ngResource', 'ngRoute','ui.bootstrap']);

	myApp.value('contextPath', $('body').data('contextpath'));

	return myApp;
});
