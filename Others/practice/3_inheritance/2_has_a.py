# 사람 목록은 사람을 포함한다. (has-a 관계)
class Person:
    def greeting(self):
        print("hello")

class PersonList:
    def __init__(self):
        self.person_list = []
    def append_person(self, person):
        self.person_list.append(person)
        print(self.person_list)

sooyong = Person()
sangho = Person()
person_list = PersonList()
person_list.append_person(sooyong)
person_list.append_person(sangho)

# Person 클래스들을 잘 포함한 모습
for person in person_list.person_list:
    person.greeting()