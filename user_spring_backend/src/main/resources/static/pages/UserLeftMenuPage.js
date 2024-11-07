import * as userApi from "../api/userApi.js";
import * as ResponseStatusCode from "./ResponseStatusCode.js";
import * as ResponseMessage from "./ResponseMessage.js";

export const UserLeftMenuPage = async () => {
  /******로그아웃함수***********/

  /****************************/
  const resultJsonObject = await userApi.userLoginCheck();
  console.log(resultJsonObject);
  const template = ` 
    <p>
    <strong>메뉴</strong>
    </p>
    <ul>
     ${
       resultJsonObject.status == ResponseStatusCode.LOGIN_SUCCESS
         ? `<!-- 로그인후 -->
      <il><a href="#">guard1님</a></li>
      <li><a href="">내정보</a></li>
      <li><a href="#" id="a_user_logout">로그아웃</a></li>`
         : `<!-- 로그인전 -->
      <li><a href="#/user_login_form">로그인</a></li>
      <li><a href="#/user_write_form">회원가입</a></li>
     
      `
     }
     <li><a href='http://localhost:8080/swagger-ui/index.html'>Swagger</a></li>
    </ul>`;
  document.querySelector("#navigation").innerHTML = template;
};