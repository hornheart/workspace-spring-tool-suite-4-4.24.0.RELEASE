import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import {
  userLoginCheck,
  userLoginAction,
  userLogoutAction,
} from "../api/userApi";

const initLoginState = {
  isLogin: false,
  loginUser: { userId: "", password: "", name: "", email: "" },
};
export const userLoginActionAsync = createAsyncThunk(
  "userLoginActionAsync",
  (user) => {
    return userLoginAction(user);
  }
);
export const userLogoutActionAsync = createAsyncThunk(
  "userLogoutActionAsync",
  () => {
    return userLogoutAction();
  }
);
export const userLoginCheckAsync = createAsyncThunk(
  "userLoginCheckAsync",
  () => {
    return userLoginCheck();
  }
);

const loginSlice = createSlice({
  name: "LoginSlice",
  initialState: initLoginState, 
  reducers: {},
  extraReducers: (builder) => {
    builder.addCase(userLoginActionAsync.fulfilled, (state, action) => {
      console.log("userLoginActionAsync.fulfilled");
      const payload = action.payload;
      return {
        isLogin: payload.status === 2100 ? true : false,
        loginUser: payload.data,
      };

    
    });
    builder.addCase(userLogoutActionAsync.fulfilled, (state, action) => {
      console.log("userLogoutActionAsync.fulfilled");
      const payload = action.payload;
      console.log('------------------>',payload);
      alert('로그아웃');
      return {
        isLogin:  false,
        loginUser:{},
      };
    });
    builder.addCase(userLoginCheckAsync.fulfilled, (state, action) => {
      console.log("userLoginCheckAsync.fulfilled");
      const payload = action.payload;
      return {
        isLogin: payload.status === 2100 ? true : false,
        loginUser: payload.data,
      };
    });
  },
});

export default loginSlice.reducer;
