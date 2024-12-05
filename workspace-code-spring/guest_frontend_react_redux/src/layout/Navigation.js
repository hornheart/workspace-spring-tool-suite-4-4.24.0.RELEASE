import React from 'react'
import { Link} from 'react-router-dom'

function Navigation() {
  return (
    <div id="navigation">
        <p>
          <strong>메 뉴</strong>
        </p>
        <ul className="guest_menus">
          <li>
            <Link to='/guest_home'>  
            방명록홈
            </Link>
          </li>
          <li>
            <Link to={`/guest_list`}>
              방명록리스트
            </Link>
          </li>
          <li>
            <a id="menu_guest_write_form" href="#/guest_write_form">
              방명록쓰기폼
            </a>
          </li>
          <li>
            <a href="http://localhost/swagger-ui/index.html">Swagger</a>
          </li>
        </ul>
      </div>
  )
}

export default Navigation