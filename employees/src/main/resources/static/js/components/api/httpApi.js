var httpApiFactory = function($http) {
	"ngInject";
    var factoryObject = {};
    factoryObject.get = function(url) {
    	return $http.get(url).then(function (result) {
    		return result.data;
    	}, function(error) {
    		return error.status;
    	});
    };
    
    factoryObject.delete = function(url) {
    	return $http.delete(url).then(function(result){
    		return result.status;
    	}, function(error){
    		return error.status;
    	});
    };
    factoryObject.post = function(url, obj) {
    	return $http.post(url, obj).then(function(result) {
    		return result.status;
    	}, function(error){
    		return error.status;
    	});
    };
    factoryObject.put = function(url, obj) {
    	return $http.put(url, obj).then(function(result) {
    		return result.status;
    	}, function(error){
    		return error.status;
    	});
    };
    return factoryObject;
};

module.exports = httpApiFactory;
