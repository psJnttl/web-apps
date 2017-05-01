var ColumSorter = function() {
	"ngInject";
    return function(x, sortVar, sortOrder) {
		if (sortVar !== 'id' && sortVar !== 'salary' && sortVar !== 'employees' && sortVar != 'averageSalary' && sortVar != 'yCode') {
        	x.sort( function (a, b) {
				var left, right;
        		if (sortVar === 'firstName') {
                	left = a.firstName.toLowerCase();
                	right = b.firstName.toLowerCase();
        		}
        		else if (sortVar === 'familyName') {
                	left = a.familyName.toLowerCase();
                	right = b.familyName.toLowerCase();
        		}
        		else if (sortVar === 'city') {
                	left = a.city.toLowerCase();
                	right = b.city.toLowerCase();
        		}
        		else if (sortVar === 'title') {
                	left = a.title.toLowerCase();
                	right = b.title.toLowerCase();
        		}
        		else if (sortVar === 'employer') {
                	left = a.employer.toLowerCase();
                	right = b.employer.toLowerCase();
        		}
        		else if (sortVar === 'name') {
                	left = a.name.toLowerCase();
                	right = b.name.toLowerCase();
        		}
        		if (left < right) { 
                    if(sortOrder =="ASC") return -1;
                    else return 1;
                }
                if (left > right) { 
                    if(sortOrder == "ASC") return 1;
                    else return -1;
                }
                return 0;
			});
		}
		else if (sortVar === 'id') {
			x.sort( function (a, b) {
				if(sortOrder == "ASC") return parseInt(a.id) - parseInt(b.id);
				else return parseInt(b.id) - parseInt(a.id);
			});
		}
        else if (sortVar === 'salary') {
        	x.sort( function (a, b) {
                if(sortOrder == "ASC") return parseFloat(a.salary) - parseFloat(b.salary);
                else return parseFloat(b.salary) - parseFloat(a.salary);
            });
        }
        else if (sortVar === 'employees') {
        	x.sort( function (a, b) {
                if(sortOrder == "ASC") return parseInt(a.employees) - parseInt(b.employees);
                else return parseInt(b.employees) - parseInt(a.employees);
            });
        }
        else if (sortVar === 'averageSalary') {
        	x.sort( function (a, b) {
                if(sortOrder == "ASC") return parseFloat(a.averageSalary) - parseFloat(b.averageSalary);
                else return parseFloat(b.averageSalary) - parseFloat(a.averageSalary);
            });
        }
        else if (sortVar === 'yCode') {
        	x.sort( function (a, b) {
        		var aStr = a.yCode.substr(0, a.yCode.length-2); // Y-tunnuksen 
            	var bStr = b.yCode.substr(0, b.yCode.length-2); // tarkistenumero
                if(sortOrder == "ASC") return parseInt(aStr) - parseInt(bStr);
                else return parseInt(bStr) - parseInt(aStr);
            });
        }
		return x;
	};
};

module.exports = ColumSorter;
