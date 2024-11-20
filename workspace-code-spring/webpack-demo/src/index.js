import { hello1 } from "./hello1.js";
import { hello2 } from "./hello2.js";
import { sum } from "./sum.js";
import $ from 'jquery';
import _ from 'lodash';
import '../css/style.css';
import '../image/background.jpg';
import '../image/logo.png';
function component() {
    const element = document.createElement('div');
    element.innerHTML += hello1();
    element.innerHTML += hello2();
    element.innerHTML += sum(3,4)+"<br><hr>";
    element.innerHTML += _.join(['Hello', 'webpack'], ' ');
    let html='<ul>';
    $.each(['kim','lee','park','choi'],function(i,name){
        html+=`<li>${name}</li>`;
    });
    html+='</ul>';
    $(element).append(html);

   element.classList.add("class3");
   //원래 있던 div 에 이미지를 추가합니다.

  
   return element;
  }
  
  document.body.appendChild(component());