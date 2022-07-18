class Foo {
	foo(i: number): number {
		return i + 1;
	}

	abc(a: string, b: string, c: string) {
		return "" + a + b + c;
	}

	randomNumber(len: number) {
		let randomNumber: number = Math.floor(Math.random() * len);
		console.log('randomNumber=' + randomNumber);
	}
}

export default Foo;
