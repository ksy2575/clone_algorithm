# 클래스 속성은 모든 인스턴스에서 공유한다.
class Person:
    bag = []

    def put_bag(self, stuff):
        # self.bag.append(stuff) <- 이렇게 하면 우선 인스턴스 속성을 먼저 탐색, 이후 클래스 속성 탐색
        Person.bag.append(stuff)

sooyong = Person()
sooyong.put_bag('pen')

sangho = Person()
sangho.put_bag('eraser')

print(sooyong.bag)
print(sangho.bag)

print(Person.bag)

# 인스턴스와 클래스의 속성 확인
print(sooyong.__dict__)
print(Person.__dict__)


# 인스턴스 속성은 각 인스턴스마다 독립적이다.
class Person:
    def __init__(self):
        self.bag = []

    def put_bag(self, stuff):
        self.bag.append(stuff)

sooyong = Person()
sooyong.put_bag('pen')

sangho = Person()
sangho.put_bag('eraser')

print(sooyong.bag)
print(sangho.bag)

# 인스턴스와 클래스의 속성 확인
print(sooyong.__dict__)
print(Person.__dict__)


# 비공개 클래스 속성
class Knight:
    '''비공개 클래스 속성'''
    __item_limit = 10  # 비공개 클래스 속성

    def print_item_limit(self):
        '''클래스 내에서만 접근 가능'''
        print(Knight.__item_limit)  # 클래스 안에서만 접근할 수 있음


x = Knight()
x.print_item_limit()  # 10

print(Knight.__doc__)
print(Knight.print_item_limit.__doc__)

# print(Knight.__item_limit)  # 클래스 바깥에서는 접근할 수 없음

