import { useRef, useState } from "react";
import * as userApi from "../api/userApi";
import * as responseStatusCode from "../api/responseStatusCode";
import * as responseMessage from "../api/responseMessage";
import { useNavigate } from "react-router-dom";

export const UserWriteFormPage = () => {
  const navigate=useNavigate();
  const formRef = useRef();
  const [user, setUser] = useState({
    userId: "",
    password: "",
    password2: "",
    name: "",
    email: "",
  });
  const [message,setMessage]=useState("");
  
  const handleChangeUserWriteForm = (e) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  };
  const userWriteAction = async () => {
    if (formRef.current.userId.value === "") {
      alert("사용자 아이디를 입력하십시요.");
      formRef.current.userId.focus();
      return;
    }
    if (formRef.current.password.value === "") {
      alert("비밀번호를 입력하십시요.");
      formRef.current.password.focus();
      return;
    }
    if (formRef.current.password2.value === "") {
      alert("비밀번호확인을 입력하십시요.");
      formRef.current.password2.focus();
      return;
    }
    if (formRef.current.name.value === "") {
      alert("이름을 입력하십시요.");
      formRef.current.name.focus();
      return;
    }
    if (formRef.current.email.value === "") {
      alert("이메일 주소를 입력하십시요.");
      formRef.current.email.focus();
      return;
    }
    if (formRef.current.password.value !== formRef.current.password2.value) {
      alert("비밀번호와 비밀번호확인은 일치하여야합니다.");
      formRef.current.password.focus();
      formRef.current.password.select();
      return;
    }

    const responseJsonObject = await userApi.userWriteAction(user);
    console.log(responseJsonObject);
    switch (responseJsonObject.status) {
      case responseStatusCode.CREATED_USER:
        navigate('/user_login_form');
        break;
      case responseStatusCode.CREATE_FAIL_EXISTED_USER:
        setMessage(responseMessage.CREATE_FAIL_EXISTED_USER);
        break;
      default:
    }
  };

  return (
    <table width="0" border="0" cellPadding="0" cellSpacing="0">
      <tbody>
        <tr>
          <td>
            {/* <!--contents--> */}
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
                    &nbsp;&nbsp;<b>사용자 관리 - 회원 가입</b>
                  </td>
                </tr>
              </tbody>
            </table>
            {/* <!-- write Form  --> */}
            <form name="f" method="post" ref={formRef}>
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
                    <td
                      width="490"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                      align="left"
                    >
                      <input
                        type="text"
                        style={{ width: "150px" }}
                        name="userId"
                        value={user.userId}
                        onChange={handleChangeUserWriteForm}
                      />
                      &nbsp;&nbsp;<font color="red">{message}</font>
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      비밀번호
                    </td>
                    <td
                      width="490"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                      align="left"
                    >
                      <input
                        type="password"
                        style={{ width: "150px" }}
                        name="password"
                        value={user.password}
                        onChange={handleChangeUserWriteForm}
                      />
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      비밀번호 확인
                    </td>
                    <td
                      width="490"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                      align="left"
                    >
                      <input
                        type="password"
                        style={{ width: "150px" }}
                        name="password2"
                        value={user.password2}
                        onChange={handleChangeUserWriteForm}
                      />
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      이름
                    </td>
                    <td
                      width="490"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                      align="left"
                    >
                      <input
                        type="text"
                        style={{ width: "150px" }}
                        name="name"
                        value={user.name}
                        onChange={handleChangeUserWriteForm}
                      />
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      이메일 주소
                    </td>
                    <td
                      width="490"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                      align="left"
                    >
                      <input
                        type="text"
                        style={{ width: "150px" }}
                        name="email"
                        value={user.email}
                        onChange={handleChangeUserWriteForm}
                      />
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
                    <input
                      type="button"
                      id="btn_user_write_action"
                      value="회원 가입"
                      onClick={userWriteAction}
                    />{" "}
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
