class Person:
    def greeting(self):
        print('hello')


sooyong = Person()
sooyong.greeting()

def greeting():
    print('outside')
class Person:
    def greeting(self):
        print('hello')
    def hello(self):
        self.greeting()
        # greeting()

sooyong = Person()
sooyong.hello()

print(dir(sooyong))
print(isinstance(sooyong, Person))