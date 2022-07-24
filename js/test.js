console.log("typeof null =", typeof null);
console.log("typeof undefined =", typeof undefined);

if (typeof (null) === Object) {
	console.log("typeof(null) === Object !!!");
} else if (typeof (null) === "object") {
	console.log('typeof(null) === "object" !!!');
} else {
	console.log("typeof(null) != Object !!!");
}

console.log(5 > 0 ? "5는 0보다 크다." : "5는 0보다 작다.");

const target = ['a', 'b', 'c'];
target.unshift('first');
target[target.length] = 'd';
target.push('e');
console.log(target);
target.pop();
target.shift();
target.splice(1, 2, 'middle1', 'middle2');
console.log(target);
console.log(target.includes('a'));
console.log(target.indexOf('b'));
console.log(target.lastIndexOf('middle2'));

const arr = ['가', '라', '다', '라', '마', '라'];
for (let i = 0; i < arr.length; i++) {
	if (i === arr.indexOf('라')) {
		arr.splice(i, 1);
	}
}
console.log(arr);
