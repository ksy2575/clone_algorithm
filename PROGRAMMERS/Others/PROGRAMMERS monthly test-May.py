# 프로그래머스 월간 코딩 테스트 시즌2 (5월) 문제 1
from collections import defaultdict
def solution(left, right):
    answer = 0
    dic = defaultdict(int)
    for i in range(1, right+1):
      for num in range(left, right+1):
        if num%i == 0:
          dic[num] += 1
    for num in dic:
      if dic[num]%2 == 0:
        answer += num
      else:
        answer -= num
    return answer
# print(solution(13, 17))

# 프로그래머스 월간 코딩 테스트 시즌2 (5월) 문제 2 -> 시간 초과
def countOne(n):
    cnt = 0
    while n != 0:
        if n & 1 == 1:
            cnt += 1
        n = n >> 1
    return cnt


def diff(n, m):
    return countOne(n ^ m)


def solution(numbers):
    answer = []
    for curr in numbers:
        next = curr + 1

        while True:
            if diff(curr, next) <= 2:
                answer.append(next)
                break
            next += 1

    return answer

# print(solution([2, 7]))