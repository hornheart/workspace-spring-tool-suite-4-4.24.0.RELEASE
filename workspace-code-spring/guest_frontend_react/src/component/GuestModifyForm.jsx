import "../css/styles.css";
import "../css/guest.css";

function GuestModifyForm() {

  
  return (
    <table border="0" cellpadding="0" cellspacing="0">
      <tbody>
        <tr>
          <td>
            <br />
            <table
              style={{ paddingLeft: 10 }}
              border="0"
              cellpadding="0"
              cellspacing="0"
            >
              <tbody>
                <tr>
                  <td bgcolor="f4f4f4" height="22">
                    &nbsp;&nbsp;<b>방명록 관리 - 방명록 수정</b>
                  </td>
                </tr>
              </tbody>
            </table>
            <form name="f" method="post">
              <input
                type="hidden"
                name="guestNo"
             
              />
              <table
                border="0"
                cellpadding="0"
                cellspacing="1"
                width="590"
                bgcolor="BBBBBB"
              >
                <tbody>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      번호
                    </td>
                    <td
                      align="left"
                      width="490"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                    >
                      1
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      이름
                    </td>
                    <td
                      align="left"
                      width="490"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                    >
                      <input
                        type="text"
                        style={{ width: "150px" }}
                        name="guestName"
                        value="김경호"
                     
                      />
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      홈페이지
                    </td>
                    <td
                      align="left"
                      width="490"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                    >
                      <input
                        type="text"
                        style={{ width: "150px" }}
                        name="guestHomepage"
                        value="www.google.com"
                      />
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      이메일
                    </td>
                    <td
                      align="left"
                      width="490"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                    >
                    <input
                        type="text"
                        style={{ width: "240px" }}
                        name="guestEmail"
                        value="guard@gmail.com"
                    />
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      제목
                    </td>
                    <td
                      align="left"
                      width="490"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                    >
                      <input
                        type="text"
                        style={{ width: "240px" }}
                        name="guestTitle"
                        value="오늘은 어린이날"
                       
                      />
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      내용
                    </td>
                    <td
                      align="left"
                      width="490"
                      bgcolor="ffffff"
                      style={{ paddingLeft: "10px" }}
                    >
                      <textarea
                        wrap="soft"
                        style={{ width: "240px" }}
                        rows="10"
                        name="guestContent"
                      >
                       우리들세상
                      </textarea>
                    </td>
                  </tr>
                </tbody>
              </table>
            </form>

            <table width="590" border="0" cellpadding="0" cellspacing="0">
              <tbody>
                <tr>
                  <td align="center">
                    <input
                      type="button"
                      value="수정"
                      id="btn_guest_modify_action"
                    />{" "}
                    &nbsp;{" "}
                    <input id="btn_guest_list" type="button" value="목록" />
                  </td>
                </tr>
              </tbody>
            </table>
          </td>
        </tr>
      </tbody>
    </table>
  );
}
export { GuestModifyForm };