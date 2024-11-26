
export const UserViewPage = () => {
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
                     guard1
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      이름
                    </td>
                    <td width="490" bgcolor="ffffff" style={{paddingLeft: '10px'}}>
                    김경호1
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      이메일 주소
                    </td>
                    <td width="490" bgcolor="ffffff" style={{paddinLeft:'10px'}}>
                    guard1@gmail.com
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
                      id="btn_user_modify_form"
                      type="button"
                      value="수정폼"
                    />
                    &nbsp;
                    <input
                      type="button"
                      value="탈퇴"
                      id="btn_user_delete_action"
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
