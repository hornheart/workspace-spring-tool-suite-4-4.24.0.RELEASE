import "../css/styles.css";
import "../css/guest.css";
import { Link, useNavigate } from "react-router-dom";
import { useRef, useState } from "react";
import * as FetchGuest from '../api/fetchGuest';
function GuestWriteForm() {
  const navigate = useNavigate();
  const formRef = useRef();
  const [guest, setGuest] = useState({
    guestNo: 0,
    guestName: "",
    guestEmail: "",
    guestHomepage: "",
    guestTitle: "",
    guestContent: "",
  });

  const onChangeGuestForm = (e) => {
    setGuest({
      ...guest,
      [e.target.name]: e.target.value,
    });
  };
  const guestWriteAction = async () => {
    if (guest.guestName === "") {
      alert("이름을 입력하세요");
      formRef.current.guestName.focus();
      return;
    }
    if (guest.guestEmail === "") {
      alert("이메일을 입력하십시요.");
      formRef.current.guestEmail.focus();
      return;
    }
    if (guest.guestHomepage === "") {
      alert("홈페이지를 입력하십시요.");
      formRef.current.guestHomepage.focus();
      return;
    }
    if (guest.guestTitle === "") {
      alert("제목을 입력하십시요.");
      formRef.current.guestTitle.focus();
      return;
    }
    if (guest.guestContent === "") {
      alert("내용을 입력하십시요.");
      formRef.current.guestContent.focus();
      return;
    }
    const jsonResultObject=await FetchGuest.writeGuest(guest);
    console.log(jsonResultObject);
    navigate(`/guest_view/${jsonResultObject.data[0].guestNo}`);

  };

  return (
    <>
      <table width="0" border="0" cellPadding="0" cellSpacing="0">
        <tbody>
          <tr>
            <td>
              <br />
              <table
                style={{ paddingLeft: 10 }}
                border="0"
                cellPadding="0"
                cellSpacing="0"
              >
                <tbody>
                  <tr>
                    <td bgcolor="f4f4f4" height="22">
                      &nbsp;&nbsp;<b>방명록 관리 - 방명록 쓰기</b>
                    </td>
                  </tr>
                </tbody>
              </table>
              <form id="guest_write_form" name="f" method="post" ref={formRef}>
                <table
                  border="0"
                  cellPadding="0"
                  cellSpacing="1"
                  width="590"
                  bgcolor="BBBBBB"
                >
                  <tbody>
                    <tr>
                      <td
                        width="100"
                        align="center"
                        bgcolor="E6ECDE"
                        height="22"
                      >
                        이름
                      </td>
                      <td
                        width="490"
                        align="left"
                        bgcolor="ffffff"
                        style={{ paddingLeft: 10 }}
                      >
                        <input
                          onChange={onChangeGuestForm}
                          type="text"
                          style={{ width: 150 }}
                          name="guestName"
                          value={guest.guestName}
                        />
                      </td>
                    </tr>
                    <tr>
                      <td
                        width="100"
                        align="center"
                        bgcolor="E6ECDE"
                        height="22"
                      >
                        이메일
                      </td>
                      <td
                        width="490"
                        align="left"
                        bgcolor="ffffff"
                        style={{ paddingLeft: 10 }}
                      >
                        <input
                          onChange={onChangeGuestForm}
                          type="text"
                          style={{ width: 150 }}
                          name="guestEmail"
                          value={guest.guestEmail}
                        />
                      </td>
                    </tr>
                    <tr>
                      <td
                        width="100"
                        align="center"
                        bgcolor="E6ECDE"
                        height="22"
                      >
                        홈페이지
                      </td>
                      <td
                        width="490"
                        align="left"
                        bgcolor="ffffff"
                        style={{ paddingLeft: 10 }}
                      >
                        <input
                          onChange={onChangeGuestForm}
                          type="text"
                          style={{ width: 150 }}
                          name="guestHomepage"
                          value={guest.guestHomepage}
                        />
                      </td>
                    </tr>
                    <tr>
                      <td
                        width="100"
                        align="center"
                        bgcolor="E6ECDE"
                        height="22"
                      >
                        타이틀
                      </td>
                      <td
                        width="490"
                        align="left"
                        bgcolor="ffffff"
                        style={{ paddingLeft: 10 }}
                      >
                        <input
                          onChange={onChangeGuestForm}
                          type="text"
                          style={{ width: 240 }}
                          name="guestTitle"
                          value={guest.guestTitle}
                        />
                      </td>
                    </tr>
                    <tr>
                      <td
                        width="100"
                        align="center"
                        bgcolor="E6ECDE"
                        height="22"
                      >
                        내용
                      </td>
                      <td
                        width="490"
                        align="left"
                        bgcolor="ffffff"
                        style={{ paddingLeft: 10 }}
                      >
                        <textarea
                          onChange={onChangeGuestForm}
                          wrap="soft"
                          style={{ width: 240 }}
                          rows="10"
                          name="guestContent"
                          value={guest.guestContent}
                        ></textarea>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </form>{" "}
              <br />
              <table width="590" border="0" cellPadding="0" cellSpacing="0">
                <tbody>
                  <tr>
                    <td align="center">
                      <input
                        type="button"
                        value="방명록쓰기"
                        id="btn_guest_write_action"
                        onClick={guestWriteAction}
                      />
                      &nbsp;
                      <Link to="/guest_list">
                        <input
                          type="button"
                          id="btn_guest_list_btn"
                          value="방명록목록"
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
    </>
  );
}
export { GuestWriteForm };
