function validate() {
	
	
	document.getElementById("form").addEventListener("submit",function(e){
		debugger;
		var form = document.getElementById("form");
		var error = document.getElementById("error");
		var name = document.getElementById("name");
		var birdth = document.getElementById("birdth");
		var tongthunhap = document.getElementById("tongthunhap");
		var thunhaptinhthue = document.getElementById("thunhaptinhthue");
		var ttn= Number(tongthunhap.value.replace(",","").replace(",",""));
		var tntt = Number(thunhaptinhthue.value.replace(",","").replace(",",""));
		var mess= [];
		if (name.value == ""|| birdth.value ==""||tongthunhap.value ==0||thunhaptinhthue.value==0) {
		    mess.push("khong duoc de trong");
		}
		if(Number.isNaN(ttn)==true||Number.isNaN(tntt)==true){
			mess.push("khong dung dang so");
		}
		if(ttn<tntt){
			mess.push("xem lai");
		}
		
		if (mess.length>0){
			e.preventDefault();
			error.innerText= mess.join(", ");
		}
	})
	
}		