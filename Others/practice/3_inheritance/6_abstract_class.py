# 추상 클래스 사용을 위해 abc 모듈 필요 (abstract base class)
from abc import *

class StudentBase(metaclass=ABCMeta):
    @abstractmethod
    def study(self):
        pass

    @abstractmethod
    def go_to_school(self):
        pass


class Student(StudentBase):

    # 모든 추상 메서드를 구현하지 않으면 에러

    def study(self):
        print('study')

    def go_to_school(self):
        print('go')


sooyong = Student()
sooyong.study()
sooyong.go_to_school()