app.controller('checkInController', function($scope, $http) {
	$scope.checkInRegister = function(checkinId) {
		var serssionUserId = 113;
		$http({
			method : "post",
			url : "http://localhost:9999/v1/checkins/register/"+serssionUserId,
			data : checkinId
		}).then(function(data, status, headers, config) {
			alert("success")
		}, function(data, status, headers, config) {
			alert("fail")
		});
	};
	
	$scope.checkInCreate = function() {
		var serssionUserId = 1;
		$http({
			method : "post",
			url : "http://localhost:9999/v1/checkins",
			data : {
				"userId": serssionUserId,
				"subject": $scope.subject,
				"classType": $scope.classType
			}
		}).then(function(data, status, headers, config) {
			alert("success")
		}, function(data, status, headers, config) {
			alert("error")
		});
	};
	
	$scope.viewCheckedUsers = function(clickedCheckInId){
		$http({
			method: "get",
			url: "http://localhost:9999/v1/checkins/" + clickedCheckInId,
		}).then(function(response) {
			$scope.users = response.data.simpleUsers;
		}, function(data, status, headers, config) {
			alert("error")
		});
	};
	
	$scope.viewCheckIns = function(){
		$http({
			method: "get",
			url: "http://localhost:9999/v1/checkins/"
		}).then(function(response) {
			$scope.checkins = response.data
		}, function(data, status, headers, config) {
			alert("error")
		});
	};
	
	$scope.deleteFromCheckedUsers = function(userId, checkinId){
		$http({
			method: "delete",
			url: "http://localhost:9999/v1/checkins/" + checkinId +'/'+ userId,
		}).then(function(response) {
			alert("success")
		}, function(data, status, headers, config) {
			alert("error")
		});
	};
	
	$scope.endCheckin = function (checkinId){
		var userSessionId = 1;
		$http({
			method: "post",
			url: "http://localhost:9999/v1/checkins/" + checkinId + '/end/' + userSessionId,
		}).then(function(response) {
			alert("success")
		}, function(data, status, headers, config) {
			alert("error")
		});
	};
	
	 jQuery(document).ready(function(){
	        jQuery('.modal').appendTo("body");
	    });
	 
});