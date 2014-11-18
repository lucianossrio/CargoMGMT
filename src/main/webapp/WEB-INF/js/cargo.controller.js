cargoModule.controller('cargoController', function($scope, $http, $location) {

	var urlBase = "http://localhost:8080/CargoMGMT";

	$http.get(urlBase + '/cargo').success(function(data) {
		$scope.cargoes = data;
	});
	
	$scope.addCargo = function addCargo(){
		if ($scope.name == ""){
			alert("Fill data");
		} else {
			var cargo = {name:$scope.name, description:$scope.description, shippingDate:$scope.shippingDate, arrivalDate:$scope.arrivalDate};
			$http.post(urlBase + '/cargo/insert', cargo).
				success(function(data) {
					alert("Cargo added");
					$location.path("/");});
		}
	}
});