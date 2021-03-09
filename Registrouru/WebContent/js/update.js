


var myFormUpdate = document.getElementById('FormUpdate');
var myButtonUpdate = document.getElementById('IdBotonGuardar');
var message = document.getElementById('mensaje');






const sendUpdate = (e)=>{
 e.preventDefault();

const formData = new FormData(myFormUpdate);


fetch('http://ec2-35-174-118-71.compute-1.amazonaws.com/User', {
    method: 'put',
    body: formData        
}).then((Response)=>{    
    return Response.text();
}).then((text)=>{
    
    
   
    if(text == "ninguna")message.innerHTML = "Rellene los campos...";

    else if(text == "success"){
        message.innerHTML = "Exito...";
    }else{
        message.innerHTML = "Las contraseñas no coinciden...";
    }

  


    
}).catch((error)=>{
    console.error(error);
})

};

myButtonUpdate.onclick = sendUpdate;
