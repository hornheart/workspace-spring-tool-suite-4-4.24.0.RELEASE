import "../css/styles.css";
import "../css/guest.css";
import { useRef, useState } from "react";
import * as guestApi from '../api/guestApi';
import { useNavigate } from "react-router-dom";

function GuestWriteForm() {
  const writeFormRef=useRef();
  const navigate=useNavigate();
  const initGuest={
      guestNo:0,
      guestName:"",
      guestEmail:"",
      guestHomepage:"",
      guestTitle:"",
      guestDate:"",
      guestContent:""
 };
 const [guest,setGuest]=useState(initGuest);
 
 const onChangeGuestForm=(e)=>{
    setGuest({
      ...guest,
      [e.target.name]:e.target.value
    });
    console.log(guest);
 }
 const guestWriteAction=async(e)=>{
    if(guest.guestName===''){
      alert('이름을입력하세요');
      writeFormRef.current.guestName.focus();
      
      return;
    }

    const responseJsonObject=await guestApi.writeGuest(guest);
    navigate(`/guest_view/${responseJsonObject.data[0].guestNo}`);
    
 }

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
              <form ref={writeFormRef} id="guest_write_form" name="f" method="post">
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
                          type="text"
                          style={{ width: 150 }}
                          name="guestName"
                          onChange={onChangeGuestForm}
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
                          type="text"
                          style={{ width: 150 }}
                          name="guestEmail"
                          onChange={onChangeGuestForm}
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
                          type="text"
                          style={{ width: 150 }}
                          name="guestHomepage"
                          onChange={onChangeGuestForm}
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
                          type="text"
                          style={{ width: 240 }}
                          name="guestTitle"
                          onChange={onChangeGuestForm}
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
                          wrap="soft"
                          style={{ width: 240 }}
                          rows="10"
                          name="guestContent"
                          onChange={onChangeGuestForm}
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
                        onClick={guestWriteAction}
                        id="btn_guest_write_action"
                      />
                      &nbsp;
                    
                        <input
                          type="button"
                          id="btn_guest_list_btn"
                          value="방명록목록"
                        />
                    
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