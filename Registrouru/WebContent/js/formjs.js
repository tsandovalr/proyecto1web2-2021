var myForm = document.getElementById('form');
var myButton = document.getElementById('IdBoton');



const sendRegister = (e)=>{
 e.preventDefault();

const formData = new FormData(myForm);


fetch('http://ec2-35-174-118-71.compute-1.amazonaws.com/Registro', {
    method: 'post',
    body: formData        
}).then((Response)=>{
    return Response.text();
    
}).then((text)=>{
    console.log(text);
    alert("Registrado exitosamente");
}).catch((error)=>{
    console.error(error);
})

};

myButton.onclick = sendRegister;