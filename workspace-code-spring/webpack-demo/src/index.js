import { hello1 } from "./hello1.js";
import { hello2 } from "./hello2.js";
import { sum } from "./sum.js";
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
    return element;
  }
  
  document.body.appendChild(component());