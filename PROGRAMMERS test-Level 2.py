# 프로그래머스 2단계 테스트 -> 에라토스테네스의 체
from itertools import permutations
import math
def do(s):
  return int(''.join(s))

def sosu(n):
  if n <= 1:
    return False
  for i in range(2, int(math.sqrt(n))+1):
    if n%i == 0:
      return False
  return True

def solution(numbers):
    answer = 0
    p = set()
    for i in range(1, len(numbers)+1):
      temp = list(permutations(numbers, i))
      for t in temp:
        p.add(t)
    p = list(p)
    p = list(set(map(do, p)))
    for pp in p:
      if sosu(pp):
        answer += 1
    return answer
# print(solution("17"))
# print(solution("011"))


# 프로그래머스 2단계 테스트 -> 정렬
def do(n):
  return (n * 4)[:5]
def solution(numbers):
  l1 = sorted(list(map(str, numbers)))
  l1.sort(key = do, reverse = True)
  return str(int(''.join(l1)))
# print(solution([6, 10, 2]))
# print(solution([3, 30, 34, 5, 9]))