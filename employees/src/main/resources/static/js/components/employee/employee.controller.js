var EmployeeController = function EmployeeController($scope, $stateParams, httpApi, naviSrv) {
	"ngInject";
	naviSrv.setActiveTab(1);
    $scope.employees = [];
//---------------------------------------------------
    $scope.listEmployees = function() {
    	httpApi.get("/api/employee/list")
    	       .then(function(result) {
    	    	   $scope.employees = result;
    	        }, function(error) {
    	        	console.log("ERROR!");
    	        	console.log(error);
    	        });
    };

    $scope.listEmployees();
//---------------------------------------------------
    $scope.addEmployee = function() {
    	httpApi.post("/api/employee", {
            		firstName: $scope.newEmp.firstName, familyName: $scope.newEmp.familyName,
            		title: $scope.newEmp.title, salary: $scope.newEmp.salary,
            		employer: $scope.newEmp.employer, city: $scope.newEmp.city })
               .then(function(result) {
            	   $scope.listEmployees();
               },
               function(error){
            	   console.log(error);
               });
    };
//---------------------------------------------------
    $scope.employeeTBDeleted = function (emp) {
        $scope.empToDelete = emp;
    };
    $scope.deleteEmployee = function() {
    	httpApi.delete("/api/employee/" + $scope.empToDelete.id)
    	       .then(function(result) {
                   $scope.listEmployees();
    	       }, function(error){
    	    	   console.log("ERROR!");
    	    	   console.log(error);
    	       });
    };
  //---------------------------------------------------
    $scope.showEmployee = [];
    $scope.fetchEmployee = function(id) {
    	httpApi.get("/api/employee/" + id)
    	       .then(function(result) {
    	    	   $scope.showEmployee = result;
    	       }, function(error){
    	    	   console.log("ERROR!");
    	    	   console.log(error);
    	       });
    };
    $scope.updateEmployee = function () {
    	httpApi.put("/api/employee/" + $scope.showEmployee.id, $scope.showEmployee)
    	       .then(function(result) {
    	    	   $scope.listEmployees();
    	       }, function(error){
    	    	   console.log("ERROR");
    	           console.log(error);
    	       });
    };
//---------------------------------------------------
    $scope.reverse = function (column) {
        if($scope.sortVar === column) {
           	$scope.sortOrder = !$scope.sortOrder;
        }
    };
	$scope.sortVar = "id";
	$scope.sortOrder = true;
};
//---------------------------------------------------

module.exports = EmployeeController;
