from collections import namedtuple
# namedtuple은 클래스가 아님. Collections 모듈 내에 있는 factory function.
# 딕셔너리와 비슷함(키, 인덱스로 접근 가능), 효율적인 메모리 사용

# 1. 정의 방식
Point = namedtuple('Point', ['x', 'y'])
Point = namedtuple('Point', 'x y')
Point = namedtuple('Point', 'x, y')

# 같은 key가 중복되거나 예약어 사용 시 rename=True 사용
Point = namedtuple('Point', ['x', 'y', 'x'], rename=True)

# 딕셔너리를 언패킹
Point = namedtuple('Point', ['x', 'y'])
dic = {'x': 40, 'y': 30}
p1 = Point(**dic)
print(p1)

# 기본 사용법
Point = namedtuple('Point', ['x', 'y'])
p = Point(11, 22)
print(p[0]+p[1]) # indexing 가능
x, y = p # unpacking 가능
print(p.x, p.y) # 이름으로 필드에 접근 가능
print(p)