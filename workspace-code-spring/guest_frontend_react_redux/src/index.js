import { HashRouter, Routes } from "react-router-dom";
import App from "./App";
import ReactDOM from "react-dom/client";
import { Provider } from "react-redux";
import { store } from "./store";
const root = ReactDOM.createRoot(document.getElementById("container"));
root.render(
  <Provider store={store}>
    <HashRouter>
      <App />
    </HashRouter>
  </Provider>
);
