var pisentry = angular.module('pisentryApp', []);

pisentry.controller('AlarmController', function($scope, $http) {
	$scope.cmds = [ "arm_away", "arm_home", "disarm" ];

	$http.get('/pisentryweb/services/alarmManager/getState').success(
			function(data) {
				console.log(data);
				$scope.system = data;
			});

	$scope.execute = function() {
		$http.put('/pisentryweb/services/alarmManager/' + $scope.selectedItem)
				.success(function() {
				})
	}
});