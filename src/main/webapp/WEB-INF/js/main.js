var cargoModule = angular.module('cargoModule', ['ngRoute']);

cargoModule.config(function($routeProvider){
	
	$routeProvider.when('/',{
		templateUrl: 'static/partials/list.html'
	});
	
	$routeProvider.when('/new',{
		templateUrl: 'static/partials/new.html'
	});
	
	$routeProvider.otherwise({redirectTo:"/"});
});