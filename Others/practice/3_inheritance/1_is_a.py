# 기반 클래스 <- 파생 클래스 (상속)
# 학생은 사람이다. (is-a 관계)
class Person:
    def greeting(self):
        print("hello")

class Student(Person):
    def study(self):
        print("studying")

# sooyong = Student()
# sooyong.greeting()
# sooyong.study()
#
# # 상속 관계 확인하기
# print(issubclass(Student, Person))
dic = {}
dic['sooyong'] = Person()
dic['sangho'] = Person()
dic['sooyong'].greeting()