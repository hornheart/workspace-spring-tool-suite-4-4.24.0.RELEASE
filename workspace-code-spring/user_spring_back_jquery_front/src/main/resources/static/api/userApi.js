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
export const userWriteAction = async (sendJsonObject)=>{
    let resultJsonObject=null;
    await $.ajax({
            url:`${BACKEND_SERVER}/user`,
            method:'POST',
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify(sendJsonObject),
            success:function(result){
                resultJsonObject=result;
                console.log(resultJsonObject);
            }
    });
    return resultJsonObject;
}
export const userModifyAction = async (sendJsonObject)=>{
    let resultJsonObject=null;
    await $.ajax({
            url:`${BACKEND_SERVER}/user/${sendJsonObject.userId}`,
            method:'PUT',
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify(sendJsonObject),
            type:'json',
            success:function(response){
                resultJsonObject=response;
            }
    });
    return resultJsonObject;
}
export const userLoginCheck=async()=>{
    let resultJsonObject=null;
    await $.ajax({
        url:`${BACKEND_SERVER}/user/login`,
        method:'GET',
        type:'json',
        success:function(response){
            resultJsonObject=response;
        }
    });
    return resultJsonObject;
}
export const userLogoutAction=async()=>{
    let resultJsonObject=null;
    await $.ajax({
            url:`${BACKEND_SERVER}/user/logout`,
            method:'GET',
            success:function(response){
                resultJsonObject=response;
            }
    });
    return resultJsonObject;
}
export const userLoginAction=async(sendJsonObject)=>{
    let resultJsonObject=null;
    await $.ajax({
            url:`${BACKEND_SERVER}/user/login`,
            method:'POST',
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify(sendJsonObject),
            success:function(result){
                resultJsonObject=result;
            }
    });
    return resultJsonObject;
}