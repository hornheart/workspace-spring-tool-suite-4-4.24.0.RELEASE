import { useContext, useEffect, useState } from "react";
/**App.js에서 export한UserContext import***/
import { UserConext } from "../App";
import { useNavigate, useParams } from "react-router-dom";
import * as userApi from "../api/userApi";
import * as responseStatusCode from '../api/responseStatusCode';
export const UserModifyFormPage = () => {

  const navigate=useNavigate();
  const [user, setUser] = useState({
    userId: "",
    password: "",
    password2: "",
    name: "",
    email: "",
  });
  
  const { userId } = useParams();
  useEffect(() => {
    userApi.userView(userId).then(
      (responseJsonObject) => {
        setUser({
          ...responseJsonObject.data,
          password2: responseJsonObject.data.password,
        });
      },
      (error) => {
        alert(error);
      }
    );
  }, [userId]);

  const onChangeUserModifyForm=(e)=>{
    setUser({
    ...user,
    [e.target.name]:e.target.value
  });
  };

  const userModifyAction=()=>{
    userApi.userModifyAction(user).then((responseJsonObject)=>{
      switch(responseJsonObject.status){
        case responseStatusCode.UPDATE_USER:
          navigate(`/user_view/${responseJsonObject.data.userId}`);
          break;
          default:
          alert('fail update user');
          break;
      }
    });

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
                    &nbsp;&nbsp;<b>사용자 관리 - 사용자수정</b>
                  </td>
                </tr>
              </tbody>
            </table>
            {/* <!-- write Form  --> */}
            <form name="f" method="post">
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
                      {user.userId}
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
                        onChange={onChangeUserModifyForm}
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
                        onChange={onChangeUserModifyForm}
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
                        onChange={onChangeUserModifyForm}
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
                        onChange={onChangeUserModifyForm}
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
                    <input type="button" value="수정" onClick={userModifyAction} />
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
