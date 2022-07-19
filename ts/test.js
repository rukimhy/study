var Test = /** @class */ (function () {
    function Test(num, str) {
        this.num = num;
        this.str = str;
    }
    Test.prototype.show = function () {
        console.log('num:' + this.num + ' str:' + this.str);
    };
    return Test;
}());
var Test2 = /** @class */ (function () {
    function Test2(num, str) {
        this.num = 2;
        if (num) {
            this.num = num;
        }
        this.str = 'hello';
        if (str) {
            this.str = str;
        }
    }
    Test2.prototype.show = function () {
        console.log('num2:' + this.num + ' str2:' + this.str);
    };
    return Test2;
}());
function makeShow(test) {
    test.show();
}
makeShow(new Test(1, 'test'));
makeShow(new Test2());
makeShow(new Test2(3, 'world'));
