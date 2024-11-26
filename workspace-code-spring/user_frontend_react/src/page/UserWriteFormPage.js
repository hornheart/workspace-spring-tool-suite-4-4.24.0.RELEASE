
export const UserWriteFormPage = () => {
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
            <form name="f" method="post" >
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
                       
                      />
                      &nbsp;&nbsp;<font color="red">{'message.id'}</font>
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