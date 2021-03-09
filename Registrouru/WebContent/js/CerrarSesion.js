


fetch('http://ec2-35-174-118-71.compute-1.amazonaws.com/Login', {
    method: 'put',         
}).then((Response)=>{    
    return Response.text();
}).then((text)=>{
    
    console.log(text); 
   
    
    
        location.href = 'index.html';
    

    
}).catch((error)=>{
    console.error(error);
})


