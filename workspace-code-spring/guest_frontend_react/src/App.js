import "./css/styles.css";
import "./css/guest.css";
import Header from "./layout/Header";
import Navigation from "./layout/Navigation";
import Footer from "./layout/Footer";
import { Route, Routes } from "react-router-dom";
import { GuestMain } from "./component/GuestMain";
import { GuestList } from "./component/GuestList";
import { GuestWriteForm } from "./component/GuestWriteForm";
import { GuestModifyForm } from "./component/GuestModifyForm";
import { GuestView } from "./component/GuestView";


function App() {
  return (
    <>
      {/* Header.js start  */}
      <Header/>
      {/* Header.js end  */}

      {/* Navigation.js start  */}
      <Navigation/>
      {/* Navigation.js end  */}

      <div id="wrapper">
        <div id="content">
          {/* GuestContent.js start  
          /*********route path *********
            #/user_main
            #/user_write_form
            #/user_login_form
            #/user_view/guard1
            #/user_modify_form/guard1
          **************************/
        }
          <Routes>
            <Route exact path="/" element={GuestMain()}/>
            <Route path="/guest_main" element={GuestMain()}/>
            <Route path="/guest_list" element={GuestList()}/>
            <Route path="/guest_write_form" element={GuestWriteForm()}/>
            <Route path="/guest_view/:guest_no" element={<GuestView/>}/>
            <Route path="/guest_modify_form/:guest_no" element={<GuestModifyForm/>}/>
          </Routes>
          {/* GuestContent.js end  */}
        </div>
      </div>
      {/* Footer.js start  */}
      <Footer/>
      {/* Footer.js end  */}
    </>
  );
}
export default App;