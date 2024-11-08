import { UserLeftMenuPage } from "./pages/UserLeftMenuPage.js";
import { UserLoginFormPage } from "./pages/UserLoginFormPage.js";
import { UserMainPage } from "./pages/UserMainPage.js";
import { UserWriteFormPage } from "./pages/UserWriteFormPage.js";
import { UserViewPage } from "./pages/UserViewPage.js";
import { UserModifyFormPage } from "./pages/UserModifyFormPage.js";

function App() {
  window.addEventListener("hashchange", function () {
    const hash = window.location.hash;
    navigate(hash);
  });
  window.addEventListener("click", function (e) {
    e.target.dataset.navigate
      ? (location.hash = e.target.dataset.navigate)
      : "";
  });
  window.addEventListener("load", function () {
    let hash = window.location.hash;
    hash = (hash == null || hash == "") ? "#/user_main" : hash;
    navigate(hash);
    UserLeftMenuPage();
  });

  /*********route path *********
    #/user_main
    #/user_write_form
    #/user_login_form
    #/user_view/guard1
    #/user_modify_form/guard1
    **************************/
  const navigate = function (hash) {
    if (hash == "#/user_main") {
      UserMainPage();
    } else if (hash == "#/user_write_form") {
      UserWriteFormPage();
    } else if (hash == "#/user_login_form") {
      UserLoginFormPage();
    } else if (hash.startsWith("#/user_view")) {
	  /*
		#/user_view/guard1
	  */	
	  UserViewPage(hash.substring(hash.lastIndexOf('/')+1));	
    } else if (hash.startsWith("#/user_modify_form")) {
	  /*
	  #/user_modify_form/guard1
	  */
	  UserModifyFormPage(hash.substring(hash.lastIndexOf('/')+1));		
    }
  };

  const template = ` 
  <!-- header start -->
    <div id="header">
        <!-- include_common_top.jsp start-->
        <h1>
            <a href="#/user_main">회원관리 FRONTEND</a>
        </h1>
        <!-- include_common_top.jsp end-->
    </div>
    <!-- header end -->
    <!-- navigation start-->
    <div id="navigation">
      <!-- include_common_left.jsp start-->
		
		  <!-- include_common_left.jsp end-->
    </div>
    <!-- navigation end-->
    <!-- wrapper start -->
    <div id="wrapper">
        <!-- content start -->
        <!-- include_content.jsp start-->
    
        <div id="content"></div>
        <!-- include_content.jsp end-->
        <!-- content end -->
    </div>
    <!--wrapper end-->
    <div id="footer">
        <!-- include_common_bottom.jsp start-->

        <p align="center">Copyright (&copy;) By Kimkyoungho.[김경호] All
            rights reserved.</p>

        <!-- include_common_bottom.jsp end-->
    </div> 
    `;
  return template;
}
export { App };