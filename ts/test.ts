class Test {
	num: number;
	str: string;

	constructor(num: number, str: string) {
		this.num = num;
		this.str = str;
	}

	show() {
		console.log('num=' + this.num + ' str=' + this.str);
	}
}

let test: Test = new Test(1, 'test');
test.show();
