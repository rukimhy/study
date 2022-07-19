interface InterfaceTest {
	show(): void;
}

class Test implements InterfaceTest {
	num: number;
	str: string;

	constructor(num: number, str: string) {
		this.num = num;
		this.str = str;
	}

	show() {
		console.log('num:' + this.num + ' str:' + this.str);
	}
}

class Test2 implements InterfaceTest {
	num: number;
	str: string;

	constructor(num?: number, str?: string) {
		this.num = 2;
		if (num) {
			this.num = num;
		}

		this.str = 'hello';
		if (str) {
			this.str = str;
		}
	}

	show() {
		console.log('num2:' + this.num + ' str2:' + this.str);
	}
}

function makeShow(test: InterfaceTest) {
	test.show();
}

makeShow(new Test(1, 'test'));
makeShow(new Test2());
makeShow(new Test2(3, 'world'));
