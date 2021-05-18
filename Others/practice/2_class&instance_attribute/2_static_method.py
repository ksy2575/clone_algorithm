# @staticmethod를 붙여 정적메서드를 만들 수 있다. (@로 시작하는 것은 데코레이터)

class Calc:
    @staticmethod
    def add(a, b):
        return a+b
print(Calc.add(2, 5))


# 클래스 메서드는 메서드 안에서 클래스 속성, 클래스 메서드에 접근해야 할 때 사용한다.

class Person:
    count = 0  # 클래스 속성

    def __init__(self):
        Person.count += 1

    @classmethod
    def ret_count(cls):
        # cls.count로 클래스 속성에 접근
        return cls.count

sooyong = Person()
sangho = Person()

print(Person.ret_count())