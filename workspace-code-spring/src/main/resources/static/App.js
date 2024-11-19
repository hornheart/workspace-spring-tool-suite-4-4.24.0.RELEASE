import { GuestMainPage } from "./pages/GuestMainPage.js";
import { GuestListPage } from "./pages/GuestListPage.js";
import { GuestViewPage } from "./pages/GuestViewPage.js";
import { GuestWriteFormPage } from "./pages/GuestWriteFormPage.js";
import { GuestModifyFormPage } from "./pages/GuestModifyFormPage.js";
const App = function () {
	console.log(window.$);
	console.log(window.$('#container'));
	/*
    #/guest_home
    #/guest_list
    #/guest_view/1
    #/guest_write_form
    #/guest_modify_form/1
    */

  $(window).on('hashchange',function(){
	const hash = window.location.hash;
    navigate(hash);
  });
 
  $(window).on('load',function(){
	let hash = window.location.hash;
    hash = (hash == null || hash == "") ? "#/guest_home" : hash;
    navigate(hash);
  });
  
  
  $(window).on('click',function(e){
	/*
	<input type="button" data-navigate="#/guest_write_form">
	*/
	e.target.dataset.navigate
	? (location.hash = e.target.dataset.navigate)
	: "";
  });

 

  async function navigate(hash) {
    let pageObject = {};
    if (hash == "#/guest_home") {
    	GuestMainPage();
    } else if (hash == "#/guest_list") {
        GuestListPage();
    } else if (hash.startsWith("#/guest_view")) {
      // ex> #/guest_view/12
      let guest_no = hash.substring(hash.lastIndexOf("/") + 1);
      GuestViewPage(guest_no);
    } else if (hash == "#/guest_write_form") {
      pageObject = GuestWriteFormPage();
      pageObject.render();
    } else if (hash.startsWith("#/guest_modify_form")) {
      //ex> #/guest_modify_form/1
      let guest_no = hash.substring(hash.lastIndexOf("/") + 1);
	  GuestModifyFormPage(guest_no);
	}
  }

  const template = `	
  <!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<h1>
				<a href="">방명록 JQuery</a>
			</h1>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<p>
				<strong>메 뉴</strong>
			</p>
			<ul class="guest_menus">
				<li><a id="menu_guest_home" href="#/guest_home">방명록홈</a></li>
				<li><a id="menu_guest_list" href="#/guest_list">방명록리스트</a></li>
				<li><a id="menu_guest_write_form" href="#/guest_write_form">방명록쓰기폼</a></li>
				<li><a href="http://localhost:8080/swagger-ui/index.html">Swagger</a></li>

			</ul>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content start-->
			<div id="content">
				
			</div>
			<!-- include_content end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<p align="center">Copyright (&copy;) By Kimkyoungho.[김경호] All
				rights reserved.</p>
			<!-- include_common_bottom.jsp end-->
		</div>`;
  return template;
};
export { App };