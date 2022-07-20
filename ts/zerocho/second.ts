function numOrStr(a: number | string) {
	if (typeof a === 'string') {
		a.split(',');
	} else {
		a.toFixed(1);
	}
}
numOrStr('hello');
numOrStr(234);

function numOrNumArray(a: number | number[]) {
	if (Array.isArray(a))
		a.concat(4);
	else
		a.toFixed(3);
}
numOrNumArray(123);
numOrNumArray([1, 2, 3]);

class A { aaa() { } }
class B { bbb() { } }
function aOrB(param: A | B) {
	if (param instanceof A)
		param.aaa();
}

//타입을 구분해주는 커스텀 함수 Type Guard
interface Cat { meow: number }
interface Dog { bow: number }
function catOrDog(a: Cat | Dog): a is Dog {
	if ((a as Cat).meow) return false;
	return true;
}
function pet(a: Cat | Dog) {
	if (catOrDog(a)) console.log(a.bow);
	else console.log(a.meow);
}

// Promise -> Pending -> Settled(Resolved, Rejected)

type C = 'Human' | "Animal" | "Mammal";
type D = { [key in C]: number };
const dddd: D = { Human: 1, Animal: 2, Mammal: 3 };

function add<T extends number | string>(x: T, y: T): void {
	console.log(x, y);
}
add(1, 2);
add('x', 'y');
