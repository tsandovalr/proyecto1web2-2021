

var div = document.getElementById('div');
var h2 = document.getElementById('h2');



fetch('http://ec2-35-174-118-71.compute-1.amazonaws.com/Login', {
    method: 'get',
          
}).then((Response)=>{    
    return Response.text();
}).then((text)=>{
    
    
    console.log(text+" ha iniciado sesion."); 

   
    
    h2.innerHTML = "Bienvenido a tu página, "+text+"."
            
    

 


    
}).catch((error)=>{
    console.error(error);
})
