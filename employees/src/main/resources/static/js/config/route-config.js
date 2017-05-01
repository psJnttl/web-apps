var employeeUrl = require('../components/employee/employee.html');
var employerUrl = require('../components/employer/employer.html');
var searchUrl = require('../components/search/search.html');

var routes = function($stateProvider, $urlRouterProvider) {
	"ngInject";
	$urlRouterProvider.otherwise("/home");

	$stateProvider
		.state('employee', {
			url: "/employee",
			templateUrl: employeeUrl,
			controller: require('../components/employee/employee.controller')
		})
		.state('employer', {
			url: "/employer",
			templateUrl: employerUrl,
			controller: require('../components/employer/employer.controller')
		})
		.state('search', {
			url: "/search",
			templateUrl: searchUrl,
			controller: require('../components/search/search.controller')
		});
};

module.exports = routes;
