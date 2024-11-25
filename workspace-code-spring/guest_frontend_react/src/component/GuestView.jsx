import "../css/styles.css";
import "../css/guest.css";
import {useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import * as guestApi from "../api/guestApi";
function GuestView() {
  const navigate=useNavigate();
  const {guest_no} =useParams();
  const [guest,setGuest]=useState({
    guestNo:0,
    guestName:"",
    guestEmail:"",
    guestHomepage:"",
    guestTitle:"",
    guestDate:"",
    guestContent:""
  });

  useEffect(function(){
      (async ()=>{
        const responseJsonObject = await guestApi.viewGuest(guest_no);
        /*
        {
          "msg": "게시물이존재하지않습니다.",
          "data": [],
          "status": 2
        }
        */
        if(responseJsonObject.status===1){
          console.log(responseJsonObject.data[0]);
          setGuest(responseJsonObject.data[0]);
        }else{
          alert('게시물이존재하지않습니다.');
          navigate('/guest_list');
        }
        
      })();  
 },[guest_no]);

 const guestRemoveAction=async ()=>{
  const responseJsonObject =await guestApi.removeGuest(guest_no);
  if(responseJsonObject.status===1){
    navigate('/guest_list');
  }else{
    alert('삭제실패');
  }

 };


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
                    &nbsp;&nbsp;<b>방명록 관리 - 방명록 상세보기</b>
                  </td>
                </tr>
              </tbody>
            </table>
            <form name="f" method="post">
              <input type="hidden" name="guest_no" value="3" />
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
                      번호
                    </td>
                    <td
                      width="490"
                      bgcolor="ffffff"
                      align="left"
                      style={{ paddingLeft: 10 }}
                    >
                      {guest.guestNo}
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      이름
                    </td>
                    <td
                      width="490"
                      bgcolor="ffffff"
                      align="left"
                      style={{ paddingLeft: 10 }}
                    >
                       {guest.guestName}
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      날짜
                    </td>
                    <td
                      width="490"
                      bgcolor="ffffff"
                      align="left"
                      style={{ paddingLeft: 10 }}
                    >
                       {guest.guestDate.substring(0,10)}
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      홈페이지
                    </td>
                    <td
                      width="490"
                      bgcolor="ffffff"
                      align="left"
                      style={{ paddingLeft: 10 }}
                    >
                       {guest.guestHomepage}
                    </td>
                  </tr>
                  <tr>
                    <td width="100" align="center" bgcolor="E6ECDE" height="22">
                      제목
                    </td>
                    <td
                      width="490"
                      bgcolor="ffffff"
                      align="left"
                      style={{ paddingLeft: 10 }}
                    >
                       {guest.guestTitle}
                    </td>
                  </tr>
                  <tr>
                    <td
                      width="100"
                      align="center"
                      bgcolor="E6ECDE"
                      height="110"
                    >
                      내용
                    </td>
                    <td
                      width="490"
                      bgcolor="ffffff"
                      align="left"
                      style={{ paddingLeft: 10 }}
                    >
                       {guest.guestContent}
                    </td>
                  </tr>
                </tbody>
              </table>
            </form>
            <br />
            <table width="590" border="0" cellPadding="0" cellSpacing="0">
              <tbody>
                <tr>
                  <td align="center">
                    <Link to={`/guest_modify_form/${guest_no}`}>
                    <input
                      type="button"
                      value="수정"
                      id="btn_guest_modify_form"
                      guest_no="1"
                    />
                    </Link>
                    &nbsp; <input type="button" value="삭제" onClick={guestRemoveAction} />
                    &nbsp;{" "}
                    <Link to={"/guest_list"}>
                      <input type="button" value="목록" id="btn_guest_list" />
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
export { GuestView };