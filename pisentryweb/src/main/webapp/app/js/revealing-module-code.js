var calculator = function(eq) {
	// private members ...
	var eqCtl = document.getElementById(eq);
	var add = function (x, y) {
		var val = x + y;
		eqCtl.innerHTML = val;
	}
	
	// public members ... 
	return {
		add: add
	};
} ('eqCtl');
 
// use
calculator.add(2,2);