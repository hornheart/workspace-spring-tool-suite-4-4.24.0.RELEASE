import "./css/styles.css";
import "./css/user.css";
import { UserMainPage } from "./page/UserMainPage";
import { UserLoginFormPage } from "./page/UserLoginFormPage";
import { Link, Navigate, Route, Routes, useNavigate } from "react-router-dom";
import { UserViewPage } from "./page/UserViewPage";
import { UserWriteFormPage } from "./page/UserWriteFormPage";
import { UserModifyFormPage } from "./page/UserModifyFormPage";
import { UserNonPage } from "./page/UserNonePage";
import React, { useEffect } from "react";
import * as responseStatusCode from "./api/responseStatusCode";
import { useDispatch, useSelector } from "react-redux";
import { userLoginCheckAsync, userLogoutActionAsync } from "./slices/loginSlice";
function App() {
  const navigate = useNavigate();
  const loginStatus = useSelector((state) => state.loginSlice);
  const dispatcher = useDispatch();
  useEffect(() => {
    (async () => {
      dispatcher(userLoginCheckAsync());
    })();
  }, []);

  const userLogoutAction = async () => {
    dispatcher(userLogoutActionAsync());
    navigate("/user_main");
  };
  return (
    <>
      <div id="header">
        <h1>
          <a href="#/user_main">회원관리 REACT FRONTEND</a>
        </h1>
      </div>
      <div id="navigation">
        <p>
          <strong>메뉴</strong>
        </p>
        <ul>
          {!loginStatus.isLogin ? (
            <>
              {/* 로그인전 */}
              <li>
                <Link to={"/user_login_form"}> 로그인</Link>
              </li>
              <li>
                <Link to="/user_write_form">회원가입</Link>
              </li>
            </>
          ) : (
            <>
              {/* 로그인후 */}
              <li>
                <Link to={`/user_view/${loginStatus.loginUser.userId}`}>
                  {loginStatus.loginUser.userId} 님
                </Link>
              </li>
              <li>
                <Link to={`/user_view/${loginStatus.loginUser.userId}`}>
                  내정보
                </Link>
              </li>
              <li>
                <Link to="" onClick={userLogoutAction}>
                  로그아웃
                </Link>
              </li>
            </>
          )}
        </ul>
      </div>
      <div id="wrapper">
        <div id="content">
          {/*
            Context 데이터를 공유할 Child컴포넌트들을 하위에포함한다.
           */}

          <Routes>
            <Route
              path="/"
              exact
              element={<Navigate to="/user_main"></Navigate>}
            />
            <Route path="/user_main" element={<UserMainPage />} />
            <Route
              path="/user_login_form"
              element={
                !loginStatus.isLogin ? <UserLoginFormPage /> : <UserMainPage />
              }
            />
            <Route
              path="/user_write_form"
              element={
                !loginStatus.isLogin ? <UserWriteFormPage /> : <UserMainPage />
              }
            />
            <Route
              path="/user_view/:userId"
              element={
                loginStatus.isLogin ? (
                  <UserViewPage userLogoutAction={userLogoutAction} />
                ) : (
                  <UserMainPage />
                )
              }
            />
            <Route
              path="/user_modify_form/:userId"
              element={
                loginStatus.isLogin ? <UserModifyFormPage /> : <UserMainPage />
              }
            />
            <Route path="*" element={<UserNonPage />} />
          </Routes>
        </div>
      </div>
      <div id="footer">
        <p align="center">
          Copyright (©) By Kimkyoungho.[김경호] All rights reserved.
        </p>
      </div>
    </>
  );
}
export default App;
