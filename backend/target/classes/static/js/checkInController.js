app.controller('checkInController', function($scope, $http) {

	$scope.checkInRegister = function() {
		var userId = 46;
		$http({
			method : "post",
			url : "http://localhost:9999/v1/checkins/register/"+userId,
			data : $scope.checkInId
		}).then(function(data, status, headers, config) {
			alert("success")
		}, function(data, status, headers, config) {
			alert("error")
		});
	};
	
	$scope.checkInCreate = function() {
		var userId = 1;
		$http({
			method : "post",
			url : "http://localhost:9999/v1/checkins",
			data : {
				"userId": userId,
				"subject": $scope.subject,
				"classType": $scope.classType
			}
		}).then(function(data, status, headers, config) {
			alert("success")
		}, function(data, status, headers, config) {
			alert("error")
		});
	};

});