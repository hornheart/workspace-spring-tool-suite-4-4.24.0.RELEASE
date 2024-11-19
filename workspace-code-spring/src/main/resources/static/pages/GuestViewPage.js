import * as guestApi from "../api/guestApi.js";
export const GuestViewPage = async (guest_no) => {
  /***************Guest삭제함수시작***************************/
  const guestRemoveAction = async (guest_no) => {
    if (!window.confirm("삭제하시겠습니까?")) {
      return;
    }
    console.log(guest_no);
    const responseJsonObject = await guestApi.removeGuest(guest_no);
    location.hash = `#/guest_list`;
  };
  /***************Guest삭제함수끝***************************/

  const responseJsonObject = await guestApi.viewGuest(guest_no);
  const guest = responseJsonObject.data[0];
  const template = `<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
				<!--contents--> <br>
				<table style="padding-left: 10px" border="0" cellpadding="0"
					cellspacing="0">
					<tbody>
						<tr>
							<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
									방명록 상세보기</b></td>
						</tr>
					</tbody>
				</table> <!-- view Form  -->
				<form name="f" method="post">
					<input type="hidden" name="guest_no" value="3">
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tbody>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">번호</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">${guest.guestNo}</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">이름</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">${guest.guestName}</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">날짜</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">${guest.guestDate.substring(0, 10)}</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">홈페이지</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">${guest.guestHomepage}</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="22">제목</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">${guest.guestTitle}</td>
							</tr>
							<tr>
								<td width="100" align="center" bgcolor="E6ECDE" height="110">내용</td>
								<td width="490" bgcolor="ffffff" align="left"
									style="padding-left: 10px">${guest.guestContent}</td>
							</tr>
						</tbody>
					</table>
				</form> <br>
				<table width="590" border="0" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td align="center">
							<input 	type="button" value="수정" 
									id="btn_guest_modify_form" 
									data-navigate="#/guest_modify_form/${guest_no}"  >
								&nbsp; 
							<input type="button" value="삭제" id="btn_guest_remove_action"">
								&nbsp; 
							<input type="button" value="목록" 
								id="btn_guest_list" 
								data-navigate='#/guest_list'>
							</td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
		</tbody>
	</table>`;

  $("#content").html(template);
  $("#btn_guest_remove_action").click(function () {
    guestRemoveAction(guest_no);
  });
};