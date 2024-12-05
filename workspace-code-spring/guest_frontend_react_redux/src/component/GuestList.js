import "../css/styles.css";
import "../css/guest.css";
import { GuestItem } from "./GuestItem";
import { useEffect } from "react";
import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { listGuestAsync } from "../slice/guestSlice";
function GuestList() {
  const guests = useSelector(state => state.data);
  const dispatch=useDispatch();
  useEffect(()=>{
    (async ()=>{
      dispatch(listGuestAsync());
    })(); 
  },[dispatch]);
 

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
                  {guests.map((guest) => (
                    <GuestItem key={guest.guestNo} guest={guest} />
                  ))}
                  {/*  GuestItem.js end   */}
                </tbody>
              </table>
            </form>
            <table border="0" cellPadding="0" cellSpacing="1" width="590">
              <tbody>
                <tr>
                  <td align="right">
                    <Link to="/guest_write_form">
                      <input
                        type="button"
                        id="btn_guest_write_form"
                        value="방명록 쓰기"
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
  );
}
export { GuestList };
