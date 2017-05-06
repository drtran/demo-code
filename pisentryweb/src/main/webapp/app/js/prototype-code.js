var myNS = myNS || {}

myNS.Calculator = function(eq) {
	this.eqCtl = document.getElementById(eq);
};

myNS.Calculator.prototype = {
	add: function (x, y) {
		var val = x + y;
		this.eqCtl.innerHTML = val;
	}
}

// use
//var calc = new myNS.Calculator('eqCtl');
//calc.add(2,2);
