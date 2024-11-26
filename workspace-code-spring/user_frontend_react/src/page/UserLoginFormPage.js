/**********App.js에서 export한 UserContext import ********/
import { useContext, useRef, useState } from "react";
import { UserContext } from "../App";
import { Link, useNavigate } from "react-router-dom";
import * as userApi from "../api/userApi";
import * as responseStatusCode from "../api/responseStatusCode";
import * as responseMessage from "../api/responseMessage";

export const UserLoginFormPage = () => {
  const navigate=useNavigate();
  /**** Context객체사용****/
  const { setLoginStatus } = useContext(UserContext);
  const loginFormRef = useRef();
  const [user, setUser] = useState({
    userId: "",
    password: "",
    name: "",
    email: "",
  });
  const [message, setMessage] = useState({
    id: "",
    password: "",
  });
  const handleChangLoginForm = (e) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  };

  const userLoginAction = async () => {
    if (user.userId === "") {
      alert("사용자아이디를 입력하세요");
      loginFormRef.current.userId.focus();
      return;
    }
    if (user.password === "") {
      alert("비밀번호를 입력하세요");
      loginFormRef.current.password.focus();
      return;
    }
    const responseJsonObject = await userApi.userLoginAction(user);
    console.log(responseJsonObject);
    switch(responseJsonObject.status){
      case responseStatusCode.LOGIN_SUCCESS:
        setLoginStatus({
          isLogin:true,
          loginUser:responseJsonObject.data
        });
        navigate('/user_main');
    }
    
   
        
  };

  return (
    <table border="0" cellPadding="0" cellSpacing="0">
      <tbody>
        <tr>
          <td>
            <br />
            <table
              style={{ paddingLeft: "10px" }}
              border="0"
              cellPadding="0"
              cellSpacing="0"
            >
              <tbody>
                <tr>
                  <td bgcolor="f4f4f4" height="22">
                    &nbsp;&nbsp;<b>사용자 관리 - 로그인</b>
                  </td>
                </tr>
              </tbody>
            </table>
            <form name="f" method="post" ref={loginFormRef}>
              <table
                border="0"
                cellPadding="0"
                cellSpacing="1"
                bgcolor="BBBBBB"
              >
                <tbody>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      사용자 아이디
                    </td>
                    <td
                      width="490"
                      align="left"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                    >
                      <input
                        type="text"
                        style={{ width: 150 }}
                        name="userId"
                        value={user.userId}
                        onChange={handleChangLoginForm}
                      />
                      &nbsp;&nbsp;
                      <font color="red" id="idMessage">
                        {message.id}
                      </font>
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      비밀번호
                    </td>
                    <td
                      width="490"
                      align="left"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                    >
                      <input
                        type="password"
                        style={{ width: 150 }}
                        name="password"
                        value={user.password}
                        onChange={handleChangLoginForm}
                      />
                      &nbsp;&nbsp;
                      <font color="red" id="passwordMessage">
                        {message.password}
                      </font>
                    </td>
                  </tr>
                </tbody>
              </table>
            </form>{" "}
            <br />
            <table border="0" cellPadding="0" cellSpacing="1">
              <tbody>
                <tr>
                  <td align="center">
                    <input
                      type="button"
                      value="로그인"
                      id="btn_user_login_action"
                      onClick={userLoginAction}
                    />{" "}
                    &nbsp;
                    <Link to={"/user_write_form"}>
                      <input
                        type="button"
                        value="회원가입폼"
                        id="btn_user_write_form"
                        data-navigate="#/user_write_form"
                      />
                    </Link>
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