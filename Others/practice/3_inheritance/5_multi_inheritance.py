# 다중 상속
class Person:
    def greeting(self):
        print('hello')

class School:
    def info(self):
        print('한기대')

class Undergraduate(Person, School):
    def study(self):
        print('studing')

sooyong = Undergraduate()
sooyong.study()
sooyong.greeting()
sooyong.info()

# 다중 상속
class A:
    def greeting(self):
        print('A')

class B(A):
    def greeting(self):
        print('B')

class C(A):
    def greeting(self):
        print('C')

class D(B, C):
    # def greeting(self):
    #     print('D')
    pass
sooyong = D()
sooyong.greeting() # 어떤 부모 클래스의 메서드를 호출할지 애매하다.

# 메서드 탐색 순서 확인

print(D.mro())


