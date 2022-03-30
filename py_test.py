# 반복문 예제
i=0
sum = 0
for i in range(1, 11):
    sum += i
print("range :", sum)

# class 예제
class A:
    def fn(self):
        print("class A :", 5)
a = A()
a.fn()
# A.fn(self='')

# 생성자 예제
class B:
    # 파이썬은 오버로딩 불가
    # def __init__(self):
    #     print("class B Constructor no variable.")
    def __init__(self, i):
        print("class B Constructor :", i)
    def __del__(self):
        print("class B Destructor")
    def setB(self, b):
        self.b = b
    def getB(self):
        return self.b
    def abs_test(self):
        pass
b = B('i')
b.setB(6);
print("class B :", b.getB())
del b

# 상속 예제
class C(B):
    def fnC(self):
        print("class C is well.")
    def abs_test(self):
        print("abstract test!")
c = C(8)
c.setB(7)
print("class B in class C :", c.getB())
c.fnC()
c.abs_test()
del c
