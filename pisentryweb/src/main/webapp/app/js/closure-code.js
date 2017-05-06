function myClosure() { 
	var date = new Date();
	
	// nested function 
	return function() {
		return date.getMilliseconds(); 
	};
}
