function validate() {
	
	
	document.getElementById("form").addEventListener("submit",function(e){
		debugger;
		var form = document.getElementById("form");
		var error = document.getElementById("error");
		var name = document.getElementById("name");
		var birdth = document.getElementById("birdth");
		var tongthunhap = document.getElementById("tongthunhap");
		var thunhaptinhthue = document.getElementById("thunhaptinhthue");
		var mess= [];
		if (name.value == ""|| birdth.value ==""||tongthunhap.value ==0||thunhaptinhthue.value==0) {
		    mess.push("khong duoc de trong");
		}
		if(tongthunhap.value<thunhaptinhthue.value){
			  mess.push("xem lai");
		}
		
		if (mess.length>0){
			e.preventDefault();
			error.innerText= mess.join(", ");
		}
	})
	
}		