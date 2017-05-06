var Calculator = function(eq) {
	this.eqCtl = document.getElementById(eq);
};

Calculator.prototype = function() {
	var add = function (x, y) {
		var val = x + y;
		this.eqCtl.innerHTML = val;
	};
	
	return { add: add }; // public member
} ();

// use
var calc = new Calculator('eqCtl');
calc.add(2,2);