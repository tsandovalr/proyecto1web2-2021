var myButtonDelete = document.getElementById('IdBotonEstoySeguro');



const sendDelete = (e)=>{
 e.preventDefault();




fetch('http://ec2-35-174-118-71.compute-1.amazonaws.com/User', {
    method: 'delete',         
}).then((Response)=>{    
    return Response.text();
}).then((text)=>{
    
    console.log(text); 
   
    
    if(text == "success")
        location.href = 'index.html';
    

  


    
}).catch((error)=>{
    console.error(error);
})

};

myButtonDelete.onclick = sendDelete;
