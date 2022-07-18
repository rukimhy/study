import Foo from './foo'

const foo = new Foo();
console.log('foo.foo(1)=' + foo.foo(1));
console.log('foo.abc(a, b, c)=' + foo.abc('a', 'b', 'c'));

let a: number = 1;
let b: String = 'string';

console.log('typeof(a):' + typeof (a), 'typeof(b):' + typeof (b));

class ABC {
	private a: number;
	private b: String;
	private c: number;
	constructor(a: number, b: String, c: number) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	show() {
		console.log('ABC.show() a:' + this.a, 'b:' + this.b, 'c:' + this.c);
	}
}

new ABC(1, 'first', 2).show();
let abc = new ABC(3, 'second', 4);
abc.show();
