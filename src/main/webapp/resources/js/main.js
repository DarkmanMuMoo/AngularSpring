
requirejs.config({
  "baseUrl": "resources/js/app",
  "paths": {
    "jQuery": "//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min",
    "angular":"//ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular.min",
    "angular-route":"//ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular-route.min",
    "angular-resource":"//ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular-resource",
    "anguler-bootstrap":"../lib/ui-bootstrap-tpls-0.10.0.min"
  },
  shim:{
   'angular' : {'exports' : 'angular'},
   'angular-route':{deps:['angular']},
   'angular-resource':{deps:['angular']},
   'anguler-bootstrap':{deps:['angular']},
   'jQuery': {'exports' : 'jQuery'}
 }

});

require(['jQuery','angular','route','modules/myApp.init'], function ($, angular) {
	  $(function () { // using jQuery because it will run this even if DOM load already happened
     angular.bootstrap(document,['myApp']);
   });
});
