import Foo from './foo'

const foo = new Foo();
console.log('foo.foo(1)=' + foo.foo(1));
console.log('foo.abc(a, b, c)=' + foo.abc('a', 'b', 'c'));

let a: number = 1;
let b: string = 'string';

console.log('typeof(a):' + typeof (a), 'typeof(b):' + typeof (b));

class ABC {
	private a: number;
	private b: string;
	private c: number;
	constructor(a: number, b: string, c: number) {
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

type MyObject = {
	name?: string,
	age: number,
}

let myobject: MyObject = {
	name: 'kim',
	age: 4,
}

console.log('myobject.name:', myobject.name);

[10, 20, 30, 40].forEach((e, i) => {
	foo.randomNumber(e);
})

