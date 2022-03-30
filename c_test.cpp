#include <iostream>

enum Week {
    Sunday,
    Monday,
    Tuesday = 5,
    Wednesday
};

struct Student {
    char gender;
    int age;
    int num;
};

int fn(int n) {
    if (n <= 1)
        return 1;
    else
        return n * fn(n - 1);
}

class A {
   private:
    int a;

   public:
    A() {
        std::cout << "class A Constructor no variable" << std::endl;
    }
    A(char c) {
        std::cout << "class A Constructor : " << c << std::endl;
    }
    ~A() {
        std::cout << "class A Destructor" << std::endl;
    }
    void setA(int a) {
        this->a = a;
    }
    int getA() {
        return a;
    }
    virtual int over_ride_teset(int a) {
        std::cout << "over_ride_test : " << a << std::endl;
        return a;
    }
};

class B : public A {
   public:
    void fnB() {
        std::cout << "This is B inheritance A" << std::endl;
    }
    virtual int over_ride_teset(int a) {
        A ::over_ride_teset(a);
        std::cout << "over_ride_test : " << a + 1 << std::endl;
        return a;
    }
};

class AbsTest {
   public:
    virtual void abstract_test() = 0;
};

class AbsTestAnswer : public AbsTest {
   public:
    virtual void abstract_test() {
        std::cout << "abstract class test" << std::endl;
    }
};

int main() {
    using namespace std;

    // while 반복문 및 break 예제
    printf("while & break : ");
    int i = 0;
    while (i < 10) {
        i++;
        if (i == 7) break;
        cout << i;
    }
    printf("\n");
    printf("------------------\n");

    // enum 예제
    enum Week week;
    week = Wednesday;
    cout << "enum : " << week << endl;
    printf("------------------\n");

    // struct 예제
    struct Student s;
    s.gender = 'M';
    s.age = 24;
    s.num = 20200101;

    cout << "s.gender : " << s.gender << endl
         << "s.age : " << s.age << endl
         << "s.num : " << s.num << endl;
    printf("------------------\n");

    // 재귀함수 예제
    cout << "fn(3) : " << fn(3) << endl;
    printf("------------------\n");

    // class 예제
    A* a = new A('c');
    a->setA(5);
    cout << "a -> getA() : " << a->getA() << endl;
    delete a;
    printf("------------------\n");

    // 상속 예제
    B* b = new B();
    b->setA(7);
    cout << "b -> getA() : " << b->getA() << endl;
    b->fnB();
    delete b;
    printf("------------------\n");

    // 오버라이딩 & 추상클래스 예제
    A* bb = new B();
    bb->over_ride_teset(2);
    delete bb;
    printf("------------------\n");

    // 추상클래스 예제
    AbsTest* abs = new AbsTestAnswer();
    abs->abstract_test();
    printf("------------------\n");
}