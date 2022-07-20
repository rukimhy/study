function numOrStr(a) {
    if (typeof a === 'string') {
        a.split(',');
    }
    else {
        a.toFixed(1);
    }
}
numOrStr('hello');
numOrStr(234);
function numOrNumArray(a) {
    if (Array.isArray(a))
        a.concat(4);
    else
        a.toFixed(3);
}
numOrNumArray(123);
numOrNumArray([1, 2, 3]);
var A = /** @class */ (function () {
    function A() {
    }
    A.prototype.aaa = function () { };
    return A;
}());
var B = /** @class */ (function () {
    function B() {
    }
    B.prototype.bbb = function () { };
    return B;
}());
function aOrB(param) {
    if (param instanceof A)
        param.aaa();
}
function catOrDog(a) {
    if (a.meow)
        return false;
    return true;
}
function pet(a) {
    if (catOrDog(a))
        console.log(a.bow);
    else
        console.log(a.meow);
}
var dddd = { Human: 1, Animal: 2, Mammal: 3 };
function add(x, y) {
    console.log(x, y);
}
add(1, 2);
add('x', 'y');
