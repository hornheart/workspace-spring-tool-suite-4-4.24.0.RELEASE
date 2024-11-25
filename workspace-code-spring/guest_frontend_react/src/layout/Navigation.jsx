import React from "react";

export default function Navigation() {
  return (
    <div id="navigation">
      <p>
        <strong>메 뉴</strong>
      </p>
      <ul className="guest_menus">
        <li>
          <a id="menu_guest_home" href="#/guest_main">
            방명록홈
          </a>
        </li>
        <li>
          <a id="menu_guest_list" href="#/guest_list">
            방명록리스트
          </a>
        </li>
        <li>
          <a id="menu_guest_write_form" href="#/guest_write_form">
            방명록쓰기폼
          </a>
        </li>
        <li>
          <a href="http://localhost:8080/swagger-ui/index.html">Swagger</a>
        </li>
      </ul>
    </div>
  );
}