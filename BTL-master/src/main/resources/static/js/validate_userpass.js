//
//			function validate() {
//				var username= document.getElementById("username");
//				var password= document.getElementById("password");
//				var form = document.getElementById("form");
//				var error = document.getElementById("error");
//				debugger;
//				var mess= [];
//				if(username.value ==""||username.value ==null){
//					mess.push("username không được để rỗng");
//				}
//				
//				if(password.value.length<8 || password.value.length>20){
//					mess.push("password lớn hơn 8 kí tự và nhở hơn 20 kí tự");
//				}
//				
//				
//				if (mess.length>0){
//					error.innerText= mess.join(", ");
//					return false;
//				}
//			}
//				
//			

function validate() {
	
		
			document.getElementById("form").addEventListener("submit",function(e){
				debugger;
				var username= document.getElementById("username");
				var password= document.getElementById("password");
				var form = document.getElementById("form");
				var error = document.getElementById("error");
				var name = document.getElementById("name");
				var birdth = document.getElementById("birdth");
				var tongthunhap = document.getElementById("tongthunhap");
				var thunhaptinhthue = document.getElementById("thunhaptinhthue");
				var mess= [];
				if(username.value ==""|| username.value ==null){
					mess.push("username không được để rỗng");
				}
				
				if(password.value.length<8 || password.value.length>20){
					mess.push("password lớn hơn 8 kí tự và nhở hơn 20 kí tự");
				}
				if (name == ""|| birdth==""||tongthunhap==0||thunhaptinhthue==0) {
				    mess.push("khong duoc de trong");
				}
				if(tongthunhap<thunhaptinhthue){
					  mess.push("xem lai");
				}
				
				if (mess.length>0){
					e.preventDefault();
					error.innerText= mess.join(", ");
				}
			})
			
}		
			
			
			