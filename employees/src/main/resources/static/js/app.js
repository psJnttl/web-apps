require('angular');
require('angular-ui-router');
require('angular-ui-bootstrap');
require('bootstrap-webpack');
require('font-awesome-webpack');

var httpApiFactory = require('./components/api/httpApi.js');
var columnSorter = require('./components/filters/ColumnSorter.js');
var naviController = require('./components/home/naviController.js');
var naviService = require('./components/home/naviService.js');

var templateUrl = require('./app.html');

angular.module('app', [
	'ui.router',
	'ui.bootstrap'
])
.directive('app', function() {
	return {
		restrict: 'E',
   		templateUrl: templateUrl
   	};
})
.factory('naviSrv', naviService)
.controller('naviCtrl', ['$scope', 'naviSrv', naviController])
.factory('httpApi', httpApiFactory)
.filter('columnSorter', columnSorter)
.config(['$stateProvider', '$urlRouterProvider', require('./config/route-config')]);
