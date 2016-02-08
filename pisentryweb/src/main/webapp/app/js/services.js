var services = angular.module('myApp.services', [ 'ngResource' ]);
services.factory('userFactory', function($resource) {
	return $resource('/services/alarmManager/getState', {}, {
		query : {
			method : 'GET',
			params : {},
			isArray : false
		}
	})
});