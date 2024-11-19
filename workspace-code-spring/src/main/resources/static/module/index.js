import {a,b}  from "./First.js"
import {c,d } from "./Second.js"
import * as third from "./Third.js";
function module_test(){
    console.log(a);
    b();
    console.log(c);
    d();
    console.log(third.e);
    third.f();
}
module_test();
