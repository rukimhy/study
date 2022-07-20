const add: (x: number, y: number) => number = (x, y) => x + y;
console.log('add(2, 3):' + add(3, 3));

const arrObj: { lat: number, lon: number } = { lat: 37.5, lon: 127.5 };
const arrGeneric: Array<number> = [123, 456];
const arrTupple: [number, number, string] = [123, 456, 'hello'];
console.log('arrObj.lat:' + arrObj.lat + '\narrGeneric:' + arrGeneric + '\narrTupple:' + arrTupple);

type World = "world" | "hell";
type Greeting = `hello ${World}`;
const greet: Greeting = 'hello hell';

const keyObj = { a: '123', b: 'hello', c: 'world' } as const;
type KeyObj = typeof keyObj[keyof typeof keyObj];

type Animal = { breath: true };
type Mammalia = Animal & { breed: true };
type Human = Mammalia & { think: true };
const zerocho: Human = { breath: true, breed: true, think: true };

interface HumanInter {
	talk: () => void;
}
const human: HumanInter = {
	talk() { return 'abc'; }
}
function a(callback: () => void): void { };
a(() => { return '3'; })

declare function forEach(arr: number[], callback: (el: number) => void): void;
let target: number[] = [];
forEach([1, 2, 3], el => { target.push(el) });
forEach([1, 2, 3], el => target.push(el));
