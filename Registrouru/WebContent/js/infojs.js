
function init(){
			  let url = location.search;
			  var xvalues = url.split("=");
			  sesionActual = xvalues[1];
			  document.getElementById("user").value=sesionActual;
			  document.getElementById("perfil").value=sesionActual;	
			  mostrarInfo();
			  		  			 
		}	
		
		function mostrarInfo(){
			var user = document.getElementById("user").value;
			var country = document.getElementById("country").value;
			var city = document.getElementById("city").value;
			var gender = document.getElementById("gender").value;
			var tlf = document.getElementById("tlf").value;
			var formData = new FormData();
			formData.append('user',user);
			formData.append('country',country);
			formData.append('city',city);
			formData.append('gender',gender);
			formData.append('tlf',tlf);

			 var init = {
				method: "DELETE",
				body: formData
			 }

			 fetch('http://localhost:8127/Registrouru/User', init)
				 .then(response => response.json())
				 .then(data => {
					 if(data.status == 200){
						 insertarInfo(data.user,country,city,gender,tlf);
					 }else{
						 alert("Error En Obtencion de Data");
					 }			
				 })
				  .catch(error => console.error('AAAAA  Error:', error));
		}
		
function insertarInfo(user,country,city,gender,tlf){
			 var info = document.getElementById("info");
			 
			  var parrafo1 = document.createElement("h3"); 
			  var texto1 = document.createTextNode(user);
			  parrafo1.appendChild(texto1);
			  parrafo1.style ="position: relative; left: 400px; top: -105px;  color: rgb(230, 235, 247); text-decoration: none;";
			  info.appendChild(parrafo1);
				
			  var parrafo2 = document.createElement("h3"); 
			  var texto2 = document.createTextNode("Usuario: "+user);
			  parrafo2.appendChild(texto2);
			  parrafo2.style ="position: relative; left: -245px; top: 38px;";
			  info.appendChild(parrafo2);
				
			  var parrafo3 = document.createElement("h3"); 
			  var texto3 = document.createTextNode("Pais: "+country);
			  parrafo3.appendChild(texto3);
			  parrafo3.style ="position: relative; left: -245px; top: 38px;";
			  info.appendChild(parrafo3);
			  
			   var parrafo4 = document.createElement("h3"); 
			  var texto4 = document.createTextNode("Ciudad: "+city);
			  parrafo4.appendChild(texto4);
			  parrafo4.style ="position: relative; left: -245px; top: 38px;";
			  info.appendChild(parrafo4);
			  
			   var parrafo5 = document.createElement("h3"); 
			  var texto5 = document.createTextNode("Genero: "+gender);
			  parrafo5.appendChild(texto5);
			  parrafo5.style ="position: relative; left: -245px; top: 38px;";
			  info.appendChild(parrafo5);
			  
			   var parrafo6 = document.createElement("h3"); 
			  var texto6 = document.createTextNode("tlf: "+tlf);
			  parrafo6.appendChild(texto6);
			  parrafo6.style ="position: relative; left: -245px; top: 38px;";
			  info.appendChild(parrafo6);
			  			  
		}