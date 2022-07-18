"use strict";
exports.__esModule = true;
var Foo = /** @class */ (function () {
    function Foo() {
    }
    Foo.prototype.foo = function (i) {
        return i + 1;
    };
    Foo.prototype.abc = function (a, b, c) {
        return "" + a + b + c;
    };
    Foo.prototype.randomNumber = function (len) {
        var randomNumber = Math.floor(Math.random() * len);
        console.log('randomNumber=' + randomNumber);
    };
    return Foo;
}());
exports["default"] = Foo;
