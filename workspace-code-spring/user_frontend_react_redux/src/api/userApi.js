//const BACKEND_SERVER='http://localhost:8080';
const BACKEND_SERVER='';
export const userDeleteAction=async(userId)=>{
	const response= await fetch(`${BACKEND_SERVER}/user/${userId}`,
    {
        method:"DELETE"
    });
    const responseJsonObject= await response.json();
	return responseJsonObject;
}
export const userView=async(userId)=>{
	const response= await fetch(`${BACKEND_SERVER}/user/${userId}`);
	const responseJsonObject= await response.json();
	return responseJsonObject;
}
export const userWriteAction = async (user)=>{
    const response= await fetch(`${BACKEND_SERVER}/user`,{
        method:'POST',
        headers:{
            'Content-type':'application/json'
        },
        body:JSON.stringify(user)
    });
    const resultJsonObject=await response.json();
    return resultJsonObject;
}
export const userModifyAction = async (user)=>{
    const response= await fetch(`${BACKEND_SERVER}/user/${user.userId}`,{
        method:'PUT',
        headers:{
            'Content-type':'application/json'
        },
        body:JSON.stringify(user)
    });
    const resultJsonObject=await response.json();
    return resultJsonObject;
}
export const userLoginCheck=async()=>{
    const response= await fetch(`${BACKEND_SERVER}/user/login`,{
        method:'GET'
    });
    const resultJsonObject=await response.json();
    return resultJsonObject;
}

export const userLogoutAction=async()=>{
    const response= 
    	await fetch(`${BACKEND_SERVER}/user/logout`,{
        method:'GET'
    });
    const resultJsonObject=await response.json();
    return resultJsonObject;
}
export const userLoginAction=async(user)=>{
    const response= await fetch(`${BACKEND_SERVER}/user/login`,{
        method:'POST',
        headers:{
            'Content-type':'application/json'
        },
        body:JSON.stringify(user)
    });
    const resultJsonObject=await response.json();
    return resultJsonObject;
}
