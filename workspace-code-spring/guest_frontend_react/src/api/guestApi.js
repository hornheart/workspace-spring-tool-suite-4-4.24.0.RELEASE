import $ from 'jquery';
const BACKEND_SERVER = "";
/*
1. GET  	/guests       		  : 방명록리스트  (모든데이타요청)
2. GET  	/guests/{guest_no}  : 방명록상세보기(guest_no 데이타를요청)
3. POST 	/guests  	  		    : 방명록쓰기	  (데이타추가)
4. PUT  	/guests/{guest_no}  : 방명록수정    (guest_no 데이타를수정)
5. DELETE	/guests/{guest_no}  : 방명록삭제	  (guest_no 데이타를삭제)
*/
export const listGuest=async ()=>{
   const response=await fetch(`${BACKEND_SERVER}/guests`,{
      method:'GET'
   });
   const responseJsonObject= await response.json();
   return responseJsonObject;
}
export const viewGuest=async (guest_no)=>{
   const response=await fetch(`${BACKEND_SERVER}/guests/${guest_no}`,{
      method:'GET'
   });
   const responseJsonObject= await response.json();
   return responseJsonObject;
}
export const writeGuest_Fetch=async (sendJsonObject)=>{
   const response=await fetch(`${BACKEND_SERVER}/guests`,{
      method:'POST',
      headers:{
         'Content-Type':'application/json'
      },
      body:JSON.stringify(sendJsonObject)
   });
   const responseJsonObject=await response.json();
   return responseJsonObject;
}
export const writeGuest=async (sendJsonObject)=>{
   let returnResponseJsonObject=null;
   await $.ajax(
            {
               url:`${BACKEND_SERVER}/guests`,
               method:"POST",
               data:JSON.stringify(sendJsonObject),
               dataType:'json',
               contentType:'application/json;charset=UTF-8',
               success:function(responseJsonObject){
                  returnResponseJsonObject=responseJsonObject;
           }
      }

   );
   console.log('>>>>>>>>>>>>>>>>>>>>test:',returnResponseJsonObject);
   return returnResponseJsonObject;
}
export const modifyGuest=async (sendJsonObject)=>{
   const response=await fetch(`${BACKEND_SERVER}/guests/${sendJsonObject.guestNo}`,{
      method:'PUT',
      headers:{
         'Content-Type':'application/json'
      },
      body:JSON.stringify(sendJsonObject)
   });
   const responseJsonObject=await response.json();
   return responseJsonObject;
}


export const removeGuest=async (guest_no)=>{
   console.log(">>>>>>"+guest_no);
   const response=await fetch(`${BACKEND_SERVER}/guests/${guest_no}`,{
      method:'DELETE'
   });
   const responseJsonObject = await response.json();
   return responseJsonObject;
}