var Calculator = function(eq) {
	// private members ...
	var eqCtl = document.getElementById(eq);
	
	// public members ... 
	return {
		add: function (x, y) {
			var val = x + y;
			eqCtl.innerHTML = val;
		}
	}
};

// use
//var calc = new Calculator('eqCtl');
//calc.add(2,2);
