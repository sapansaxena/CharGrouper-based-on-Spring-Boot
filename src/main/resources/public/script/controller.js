angular.module('myApp', []).controller('taskCtrl', function($scope, $http) {
	 $scope.$watch('input', function(newValue, oldValue) {
		 $scope.status="";
		 $scope.outputStatus="";
		 $scope.output="";
	   });
$scope.reset = function(){
	$scope.input = "";
}
	$scope.convertChar = function(){
		if($scope.input == "" || typeof $scope.input ==="undefined"){
			$scope.output = "Input Required";
			$scope.outputStatus = "Error"
				  $scope.status = "alert alert-danger"; 
				return;
		}
		var letters = /^[a-zA-Z ]+$/;
		if(!$scope.input.match(letters)){
			$scope.output ="Only alphabetical characters allowed";
			 $scope.outputStatus = "Error"
				  $scope.status = "alert alert-danger";
			 return;
		}
		$http.get('/rest/chargroup/'+$scope.input)
		.then(function(response) {
		  $scope.output = response.data;
		  $scope.outputStatus = "Success"
		  $scope.status = "alert alert-success"; 
		})
		.catch(function(response) {
			$scope.output ="Internal Error";
			$scope.outputStatus = "Result:"
				  $scope.status = "alert alert-success"; 
		  console.error('Error', response.status, response.data);
		});
		
	}
	
});