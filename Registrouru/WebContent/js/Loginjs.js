var myFormLogin = document.getElementById('form');
var myButtonLogin = document.getElementById('IdBotonLogin');

var h2 = document.getElementById('h2');


const sendLogin = (e)=>{
 e.preventDefault();

const formData = new FormData(myFormLogin);


fetch('http://ec2-35-174-118-71.compute-1.amazonaws.com/Login', {
    method: 'post',
    body: formData        
}).then((Response)=>{    
    return Response.text();
}).then((text)=>{
    
    
    console.log(text); 

   
    
    if(text == "success") location.href = 'http://ec2-35-174-118-71.compute-1.amazonaws.com/home.html';
            
    

 


    
}).catch((error)=>{
    console.error(error);
})

};
myButtonLogin.onclick = sendLogin;


