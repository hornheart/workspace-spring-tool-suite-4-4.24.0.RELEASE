import { configureStore } from '@reduxjs/toolkit'
import guestSlice from './slice/guestSlice'

export const store = configureStore({
  reducer: guestSlice,
})