# attribute
class Person:
    def __init__(self):
        self.hello = 'hello'

    def greeting(self):
        print(self.hello)

sooyong = Person()
sooyong.greeting()

# attribute - 매개변수로 속성 받기
class Person:
    def __init__(self, age, height):
        self.age = age
        self.height = height

    def greeting(self):
        print("Hello, I'm", self.age, "and", self.height)

sooyong = Person(26, 187)
sooyong.greeting()
print(sooyong.age)
print(sooyong.height)

# attribute - 위치 인수로 속성 받기
class Person:
    def __init__(self, *args):
        # print(args)
        self.age = args[0]
        self.height = args[1]

    def greeting(self):
        print("Hello, I'm", self.age, "and", self.height)

sooyong = Person(26, 187)
sooyong.greeting()

# attribute - 비공개 속성 사용하기
class Person:
    def __init__(self, wallet):
        # print(args)
        self.__wallet = wallet

    def usewallet(self, money):
        if money >= self.__wallet:
            print("돈이 부족합니다.")
        else:
            self.__wallet -= money
        # print("used:", money, "and", self.__wallet, "remained")

sooyong = Person(10000)
sooyong.usewallet(3000)
sooyong.usewallet(8000)
# 비공개 메서드도 생성 가능 -> def __(메서드명):