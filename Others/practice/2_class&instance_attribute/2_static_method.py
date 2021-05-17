# @staticmethod를 붙여 정적메서드를 만들 수 있다. (@로 시작하는 것은 데코레이터)

class Calc:
    @staticmethod
    def add(a, b):
        return a+b
print(Calc.add(2, 5))