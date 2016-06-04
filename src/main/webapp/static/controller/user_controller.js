App.controller('UserController' ['$scope', 'UserService', function($scope, UserService){
	var self = this;
	self.user={id:null,username:'',address:'',email:''};
    self.users=[];
	self.fetchAllUsers= function(){
		UserService.fetchAllUsers()
		.then(
			function(data){
				self.users=data;
			},
			function(errorResponse){
				error.console('Error while fetching users');
			}
		);
	};
	
}]);