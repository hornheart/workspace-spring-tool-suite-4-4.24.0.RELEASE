import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { listGuest, viewGuest} from "../api/fetchGuest";

export const listGuestAsync = createAsyncThunk("listGuestAsync", () => {
  return listGuest();
});
export const viewGuestAsync = createAsyncThunk("viewGuestAsync", (guest_no) => {
  return viewGuest(guest_no);
});

const initState = {
    "msg": "",
    "data":[
        {
            "guestNo": 0,
            "guestName": "",
            "guestDate": "",
            "guestEmail": "",
            "guestHomepage": "",
            "guestTitle": "",
            "guestContent": ""
        }
    ]
}
export const guestSlice = createSlice({
  name: "guestSlice",
  initialState: initState,
  extraReducers: (builder) => {
    builder.addCase(listGuestAsync.fulfilled, (state, action) => {
      return action.payload;
    });
    builder.addCase(viewGuestAsync.fulfilled, (state, action) => {
      state=action.payload;
      return state;
    });
    
  },
});
export default guestSlice.reducer;
