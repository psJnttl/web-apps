var EmployerController = function EmployerController($scope, $stateParams, httpApi, naviSrv) {
	"ngInject";
	naviSrv.setActiveTab(2);
    $scope.employers = [];

    $scope.listEmployers = function() {
		httpApi.get('/api/employer/personnelcount')
		       .then(function(response) {
			           $scope.employers = response;
			       },
		           function(response) {
			           console.log('list employers failed, cause: ' +  response.status);
		           });
	};
    $scope.listEmployers();
  //---------------------------------------------------

    $scope.addEmployer = function() {
    	httpApi.post("/api/employer/", {
            		name: $scope.newEmplr.name, yCode: $scope.newEmplr.yCode})
            	.then(function(result) {
            		$scope.listEmployers();
            	}, 
            	function(error) {
            		console.log(error);
            	});
    };
//---------------------------------------------------
    $scope.employerTBDeleted = function (emplr) {
        $scope.emplrToDelete = emplr;
    };
    $scope.deleteEmployer = function() {
		httpApi.delete("/api/employer/" + $scope.emplrToDelete.id)
		       .then(function(response) {
		    	       $scope.listEmployers();
			       },
		           function(response) {
			           console.log(error);
		           });
	};
//---------------------------------------------------
    $scope.showEmployer = [];

    $scope.fetchEmployer = function(id) {
        $scope.showEmployer = { name: "Loading", yCode: "data" };
		httpApi.get("/api/employer/" + id)
		       .then(function(response) {
		    	   $scope.showEmployer = response;
			       },
		           function(response) {
			           console.log('fetch employer failed, cause: ' +  response.status);
		           });
	};
    $scope.updateEmployer = function () {
    	httpApi.put("/api/employer/" + $scope.showEmployer.id, $scope.showEmployer)
    	       .then(function(result) {
    	    	   $scope.listEmployers();
    	       }, function(error){
    	    	   console.log("ERROR");
    	           console.log(error);
    	       });
    };
//---------------------------------------------------
    $scope.sortByColumn = function (column) {
        if($scope.sortVar === column) {
            if($scope.sortOrder === "ASC") $scope.sortOrder = "DESC";
            else $scope.sortOrder = "ASC";
        }
        else {
        	$scope.sortOrder = "ASC";
        }
        $scope.sortVar = column;
        
    };

    $scope.sortVar = "name";
	$scope.sortOrder = "ASC";
//---------------------------------------------------
};
module.exports = EmployerController;
