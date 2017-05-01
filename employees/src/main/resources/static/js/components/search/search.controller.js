var SearchController = function SearchController($scope, $stateParams, httpApi, naviSrv) {
	"ngInject";
	naviSrv.setActiveTab(3);
    $scope.employersEmployees = [];
    $scope.averageSalaries = [];

    $scope.getEmployeeCount = function() {
		httpApi.get('/api/employer/personnelcount')
		       .then(function(response) {
			           $scope.employersEmployees = response;
			       },
		           function(response) {
			           console.log('list employers failed, cause: ' +  response.status);
		           });
	};
    
    $scope.getAverageSalaryPerEmployer = function() {
		httpApi.get('/api/employer/averagesalary')
			   .then(function(response) {
				   $scope.averageSalaries = response;
			   },
			   function(error) {
				   console.log(error);
			   });
	};

    $scope.getEmployeeCount();
    $scope.getAverageSalaryPerEmployer();
//---------------------------------------------------
    $scope.reverse = function (column) {
        if($scope.sortVar === column) {
           	$scope.sortOrder = !$scope.sortOrder;
        }       
    };
	$scope.sortVar = "id";
	$scope.sortOrder = true;

};
module.exports = SearchController;
