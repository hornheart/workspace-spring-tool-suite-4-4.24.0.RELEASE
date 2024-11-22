import "../css/styles.css";
import "../css/guest.css";
import * as guestApi from "../api/guestApi";
import { useEffect, useState } from "react";
import {GuestItem} from "./GuestItem";
function GuestList() {
  const [guests, setGuests] = useState([]);

  useEffect(() => {
    (async () => {
      const responseJsonObject = await guestApi.listGuest();
      console.log(responseJsonObject);
      setGuests(responseJsonObject.data);
    })();
  }, []);

  return (
    <table border="0" cellPadding="0" cellSpacing="0">
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
                    &nbsp;&nbsp;<b>방명록 관리 - 리스트</b>
                  </td>
                </tr>
              </tbody>
            </table>
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
                    <td width="50" align="center" bgcolor="E6ECDE" height="22">
                      번호
                    </td>
                    <td width="300" align="center" bgcolor="E6ECDE">
                      제목
                    </td>
                    <td width="120" align="center" bgcolor="E6ECDE">
                      이름
                    </td>
                    <td width="120" align="center" bgcolor="E6ECDE">
                      날짜
                    </td>
                  </tr>
                  {/*  GuestItem.js start */}
                  {
                  
                  guests.map((guest)=>{return <GuestItem key={guest.guestNo} guest={guest}/>})
                 
                  /*
                  guests.map((guest) =>{return (
                      <tr className="guest_item" key={guest.guestNo}>
                        <td
                          width="50"
                          align="center"
                          bgcolor="ffffff"
                          height="20">
                          {guest.guestNo}
                        </td>
                        <td
                          width="300"
                          bgcolor="ffffff"
                          style={{ paddingLeft: 10 }}>
                          <a
                            href="#guest_view/1"
                            className="user guest_item_a"
                            guest_no="124"
                          >
                            {guest.guestTitle}
                          </a>
                        </td>
                        <td width="120" align="center" bgcolor="ffffff">
                          {guest.guestName}
                        </td>
                        <td width="120" align="center" bgcolor="ffffff">
                          {guest.guestDate.substring(0, 10)}
                        </td>
                      </tr>
                    )})
                      */
                  }
                    
                  {/*  GuestItem.js end   */}
                </tbody>
              </table>
            </form>
            <table border="0" cellPadding="0" cellSpacing="1" width="590">
              <tbody>
                <tr>
                  <td align="right">
                    <input
                      type="button"
                      id="btn_guest_write_form"
                      value="방명록 쓰기"
                    />
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
export { GuestList };