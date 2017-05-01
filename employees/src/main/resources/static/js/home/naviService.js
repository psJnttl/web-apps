var naviService = function() {
	"ngInject";
	var factoryObject = {};
	
	factoryObject.getActiveTab = function() {
    	return factoryObject.activeTab;
    };
    
	factoryObject.setActiveTab = function(tab) {
    	factoryObject.activeTab = tab;
    };
    return factoryObject;
};
module.exports = naviService;
