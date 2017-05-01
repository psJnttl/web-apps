var NavigationController = function ($scope, naviService) {
	"ngInject";
	$scope.getActiveSection = function(tab) {
		if (tab === naviService.getActiveTab()) {
			return true;
		}
		else return false;
	};
};
module.exports = NavigationController;
