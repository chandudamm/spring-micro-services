App.factory('UserService' ['$http', '$q', function($http, $q){
	return{
		fetchAllUsers: function(){
			return $http.get('http://localhost:8080/SpringMVC4AngularExample/user/')
			.then(
				function(response){
					return response.data;
				},
				function(errorResponse){
					error.console('Error while fetching users');
					return $q.reject(errorResponse);
				}
			);
		}
	}
}]);