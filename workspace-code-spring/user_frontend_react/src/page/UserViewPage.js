import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import * as userApi from '../api/userApi';
import * as resonseStausCode from "../api/responseStatusCode";
import * as responseMessage from "../api/responseMessage";

export const UserViewPage = ({userLogoutAction}) => {
  const navigate=useNavigate();
  const {userId}=useParams();
  const [user,setUser]=useState({
    userId:'',
    password:'',
    name:'',
    email:''
  });
  useEffect(()=>{
  let userViewPromise=userApi.userView(userId)
   userViewPromise.then(function(responseJsonObject){
      console.log(responseJsonObject);
      if(responseJsonObject.status===resonseStausCode.READ_USER){
        setUser(responseJsonObject.data);
      }else if(responseJsonObject.status===resonseStausCode.UNAUTHORIZED_USER){
        alert(responseMessage.UNAUTHORIZED_USER);
        navigate(`/user_main`);
      }
   }).catch(function(e){
      alert('view error!!');
   });
  },[]);
  const userDeleteAction=()=>{
    userApi.userDeleteAction(userId).then(function(responseJsonObject){
      userLogoutAction();
    })
  };

 return (
    <table border="0" cellPadding="0" cellSpacing="0">
      <tbody>
        <tr>
          <td>
            {/* <!--contents--> */}
            <br />
            <table
              style={{paddingLeft: '10px'}}
              border="0"
              cellPadding="0"
              cellSpacing="0"
            >
              <tbody>
                <tr>
                  <td bgcolor="f4f4f4" height="22">
                    &nbsp;&nbsp;<b>사용자 관리 - 사용자 정보보기</b>
                  </td>
                </tr>
              </tbody>
            </table>
            {/* <!-- view Form  --> */}
            <form name="f" method="post">
              <input type="hidden" name="userId" value='guard1' />
              <table
                border="0"
                cellPadding="0"
                cellSpacing="1"
                width="590"
                bgcolor="BBBBBB"
              >
                <tbody>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      사용자 아이디
                    </td>
                    <td width="490" bgcolor="ffffff" style={{paddingLeft: '10px'}}>
                     {user.userId}
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      이름
                    </td>
                    <td width="490" bgcolor="ffffff" style={{paddingLeft: '10px'}}>
                    {user.name}
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      이메일 주소
                    </td>
                    <td width="490" bgcolor="ffffff" style={{paddinLeft:'10px'}}>
                    {user.email}
                    </td>
                  </tr>
                </tbody>
              </table>
            </form>
            <br />
            <table border="0" cellPadding="0" cellSpacing="1">
              <tbody>
                <tr>
                  <td align="center">
                  <Link to={`/user_modify_form/${user.userId}`}>
                    <input
                      id="btn_user_modify_form"
                      type="button"
                      value="수정폼"
                    />
                  </Link>
                    &nbsp;
                    <input
                      type="button"
                      value="탈퇴"
                      id="btn_user_delete_action"
                      onClick={userDeleteAction}
                    />
                    &nbsp;
                  </td>
                </tr>
              </tbody>
            </table>
          </td>
        </tr>
      </tbody>
    </table>
  );
};