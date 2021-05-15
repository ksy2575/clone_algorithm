class Person:
    def __init__(self):
        self.hello = 'hello'

    def greeting(self):
        print(self.hello)

sooyong = Person()
sooyong.greeting()


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