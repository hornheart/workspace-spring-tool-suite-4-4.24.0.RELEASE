import * as guestApi from "../api/guestApi.js";

export const GuestModifyFormPage = async (guest_no) => {
  /***************방명록수정함수시작********************/
  const guestModifyAction=async ()=>{
    if (document.f.guest_name.value == "") {
        alert("이름을 입력하십시요.");
        document.f.guest_name.focus();
        return;
      }
      if (document.f.guest_email.value == "") {
        alert("이메일을 입력하십시요.");
        document.f.guest_email.focus();
        return;
      }
      if (document.f.guest_homepage.value == "") {
        alert("홈페이지를 입력하십시요.");
        document.f.guest_homepage.focus();
        return;
      }
  
      if (document.f.guest_title.value == "") {
        alert("제목을 입력하십시요.");
        document.f.guest_title.focus();
        return;
      }
      if (document.f.guest_content.value == "") {
        alert("내용을 입력하십시요.");
        document.f.guest_content.focus();
        return;
      }
      let sendJsonObject = {
        guestNo: document.f.guest_no.value,
        guestDate: "",
        guestName: document.f.guest_name.value,
        guestEmail: document.f.guest_email.value,
        guestHomepage: document.f.guest_homepage.value,
        guestTitle: document.f.guest_title.value,
        guestContent: document.f.guest_content.value,
      };

      const responseJsonObject = await guestApi.modifyGuest(sendJsonObject);
      console.log(responseJsonObject);
      location.hash=`#/guest_view/${sendJsonObject.guestNo}`;

  }
  /****************방명록수정함수끝*******************/
  let responseJsonObject = await guestApi.viewGuest(guest_no);
  let guest = responseJsonObject.data[0];
  const template = `
  <table border="0" cellpadding="0" cellspacing="0">
	    <tbody>
            <tr>
                <td><br>
                    <table style="padding-left: 10px" border="0" cellpadding="0"
                        cellspacing="0">
                        <tbody>
                            <tr>
                                <td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
                                        방명록 수정</b></td>
                            </tr>
                        </tbody>
                    </table> <!-- modify Form  -->
                    <form name="f" method="post">
                        <input type="hidden" name="guest_no" value="${guest.guestNo}">
                        <table border="0" cellpadding="0" cellspacing="1" width="590"
                            bgcolor="BBBBBB">
                            <tbody>
                                <tr>
                                    <td width="100" align="center" bgcolor="E6ECDE" height="22">번호</td>
                                    <td align="left" width="490" bgcolor="ffffff"
                                        style="padding-left: 10px">${guest.guestNo}</td>
                                </tr>
                                <tr>
                                    <td width="100" align="center" bgcolor="E6ECDE" height="22">이름</td>
                                    <td align="left" width="490" bgcolor="ffffff"
                                        style="padding-left: 10px"><input type="text"
                                        style="width: 150" name="guest_name" value="${guest.guestName}"></td>
                                </tr>
                                <tr>
                                    <td width="100" align="center" bgcolor="E6ECDE" height="22">홈페이지</td>
                                    <td align="left" width="490" bgcolor="ffffff"
                                        style="padding-left: 10px"><input type="text"
                                        style="width: 150" name="guest_homepage" value="${guest.guestHomepage}"></td>
                                </tr>
                                <tr>
                                    <td width="100" align="center" bgcolor="E6ECDE" height="22">이메일</td>
                                    <td align="left" width="490" bgcolor="ffffff"
                                        style="padding-left: 10px"><input type="text"
                                        style="width: 240" name="guest_email" value="${guest.guestEmail}"></td>
                                </tr>
                                <tr>
                                    <td width="100" align="center" bgcolor="E6ECDE" height="22">제목</td>
                                    <td align="left" width="490" bgcolor="ffffff"
                                        style="padding-left: 10px"><input type="text"
                                        style="width: 240" name="guest_title" value="${guest.guestTitle}"></td>
                                </tr>
                                <tr>
                                    <td width="100" align="center" bgcolor="E6ECDE" height="22">내용</td>
                                    <td align="left" width="490" bgcolor="ffffff"
                                        style="padding-left: 10px"><textarea wrap="soft"
                                            style="width: 240px" rows="10" name="guest_content">${guest.guestContent}</textarea>

                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>

                    <table width="590" border="0" cellpadding="0" cellspacing="0">
                        <tbody>
                            <tr>
                                <td align="center"><input type="button" value="수정"
                                    id="btn_guest_modify_action"> &nbsp; <input
                                    id="btn_guest_list" type="button" value="목록"></td>
                            </tr>
                        </tbody>
                    </table></td>
            </tr>
	    </tbody>
    </table>`;

  let pageObject = {
    template: template,
    render: function () {
      document.querySelector("#content").innerHTML = template;
      document.querySelector("#btn_guest_modify_action").onclick = guestModifyAction;
    },
  };
  return pageObject;
};
