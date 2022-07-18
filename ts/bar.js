"use strict";
exports.__esModule = true;
var foo_1 = require("./foo");
var foo = new foo_1["default"]();
console.log(foo.foo(1));
console.log(foo.abc('a', 'b', 'c'));
var a = 1;
var b = 'string';
console.log(typeof (a), typeof (b));
var ABC = /** @class */ (function () {
    function ABC(a, b, c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    ABC.prototype.show = function () {
        console.log('a=', this.a, ' b=', this.b, ' c=', this.c);
    };
    return ABC;
}());
new ABC(1, 'first', 2).show();
var abc = new ABC(3, 'second', 4);
abc.show();
