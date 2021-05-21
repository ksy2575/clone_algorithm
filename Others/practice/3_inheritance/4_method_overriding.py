# 메서드 오버라이딩
class Person:
    def greeting(self):
        print('안녕하세요')


class Student(Person):
    def greeting(self):
        print('안녕하세요 저는 학생입니다.')


sooyong = Student()
sooyong.greeting()

# 메서드 오버라이딩 + super로 부모 클래스 메서드 사용
class Person:
    def greeting(self):
        print('안녕하세요')


class Student(Person):
    def greeting(self):
        super().greeting()
        print('저는 학생입니다.')


sooyong = Student()
sooyong.greeting()