var Closure2 = function () { 
	var date = new Date();
	var func = function () {
		return date.getMilliseconds();
	};
	
	return {
		func: func
	};
}