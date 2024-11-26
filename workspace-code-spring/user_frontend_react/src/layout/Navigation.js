import React, { useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import * as userApi from "../api/userApi";
/**********App.js에서 export한 UserContext import ********/
import {UserContext} from '../App';

export default function Navigation() {
 const navigate=useNavigate();
 const {loginStatus,setLoginStatus}=useContext(UserContext);
 console.log(loginStatus);
 const userLogoutAction=async()=>{
  await userApi.userLogoutAction();
  setLoginStatus({
    isLogin:false,
    loginUser:{}
  });
  navigate('/user_main');
  //window.location.href='/user_main'
 }
  return (
    <div id="navigation">
      <p>
        <strong>메뉴</strong>
      </p>
      <ul>
         {/* 로그인전 */}
        {!loginStatus.isLogin?(
          <>
            <li>
              <Link to={"/user_login_form"}>로그인</Link>
            </li>
            <li>
              <Link to={"/user_write_form"}>회원가입</Link>
            </li>
          </>)
          :
          (<>  
            {/* 로그인후 */}
            <li>
             <Link to={''}>{loginStatus.loginUser.userId} 님</Link>
            </li>
            <li>
              <Link to={`/user_view/${loginStatus.loginUser.userId}`}>내정보</Link>
            </li>
            <li>
              <Link to={''} onClick={userLogoutAction}>로그아웃</Link>
            </li>
          </>
          )}
        <li>
          <a href="http://192.168.15.31:8080/swagger-ui/index.html">swagger</a>
        </li>
      </ul>
    </div>
  );
}