import "./css/styles.css";
import "./css/guest.css";
import Header from "./layout/Header";
import Navigation from "./layout/Navigation";
import Footer from "./layout/Footer";
import { HashRouter, Route, Routes } from "react-router-dom";
import { GuestMain } from "./component/GuestMain";
import { GuestList } from "./component/GuestList";
import { GuestWriteForm } from "./component/GuestWriteForm";
import { GuestModifyForm } from "./component/GuestModifyForm";
import { GuestView } from "./component/GuestView";

function App() {
  return (
    <>
      {/* Header.js start  */}
      <Header />
      {/* Header.js end  */}

      {/* Navigation.js start  */}
      <Navigation />
      {/* Navigation.js end  */}

      <div id="wrapper">
        <div id="content">
          {/* 
          GuestContent.js start  
            1. GET  	/guests       		  : 방명록리스트  (모든데이타요청)
            2. GET  	/guests/{guest_no}  : 방명록상세보기(guest_no 데이타를요청)
            3. POST 	/guests  	  		    : 방명록쓰기	  (데이타추가)
            4. PUT  	/guests/{guest_no}  : 방명록수정    (guest_no 데이타를수정)
            5. DELETE	/guests/{guest_no}  : 방명록삭제	  (guest_no 데이타를삭제)
          */}
            <Routes>
              <Route exact path="/" element={GuestMain()} />
              <Route path="/guest_home" element={<GuestMain />} />
              <Route path="/guest_list" element={<GuestList />} />
              <Route path="/guest_write_form" element={<GuestWriteForm />} />
              <Route
                path="/guest_modify_form/:guest_no"
                element={<GuestModifyForm />}
              />
              <Route path="/guest_view/:guest_no" element={<GuestView />} />
            </Routes>
          {/* GuestContent.js end  */}
        </div>
      </div>
      {/* Footer.js start  */}
      <Footer />
      {/* Footer.js end  */}
    </>
  );
}
export default App;
