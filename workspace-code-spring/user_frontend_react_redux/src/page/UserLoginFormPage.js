import {  useRef, useState } from "react";
import * as responseMessage from "../api/responseMessage";
import * as responseStatusCode from "../api/responseStatusCode";
import * as userApi from "../api/userApi";
import { Link, useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { userLoginActionAsync } from "../slices/loginSlice";
export const UserLoginFormPage = () => {
  const dispatch=useDispatch();
 
  const navigate=useNavigate();
  const formRef = useRef();
  const [message,setMessage]=useState({
    id:'',
    password:''
});
  const [user, setUser] = useState({
    userId: "",
    password: "",
    name: "",
    email: "",
  });
  const handleChangeLoginForm = (e) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  };
  const userLoginAction = async () => {
    if (user.userId=== "") {
      alert("사용자 아이디를 입력하십시요.");
      formRef.current.userId.focus();
      return;
    }
    if (user.userId.password === "") {
      alert("비밀번호를 입력하십시요.");
      formRef.current.password.focus();
      return;
    }
    const responseJsonObject = await dispatch(userLoginActionAsync(user));
    
    console.log(responseJsonObject);
    switch (responseJsonObject.status) {
      case responseStatusCode.LOGIN_SUCCESS:
        navigate('/user_main',{replace:true});
        break;
      case responseStatusCode.LOGIN_FAIL_NOT_FOUND_USER:
        setMessage({id:responseMessage.LOGIN_FAIL_NOT_FOUND_USER});
        break;
      case responseStatusCode.LOGIN_FAIL_PASSWORD_MISMATCH_USER:
        setMessage({password:responseMessage.LOGIN_FAIL_PASSWORD_MISMATCH_USER});
        break;
      default:
        break;
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
            <form name="f" method="post" ref={formRef}>
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
                        onChange={handleChangeLoginForm}
                        value={user.userId}
                      />
                      &nbsp;&nbsp;
                      <font color="red" id="idMessage">{message.id}</font>
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
                        onChange={handleChangeLoginForm}
                        value={user.password}
                      />
                      &nbsp;&nbsp;
                      <font color="red" id="passwordMessage">{message.password}</font>
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
                      onClick={userLoginAction}
                    />{" "}
                    &nbsp;
                    <Link to={'/user_write_form'}>
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
