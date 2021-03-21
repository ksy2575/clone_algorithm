# 21.03.05 테스트 합격
# 프로그래머스 3단계 테스트 -> 그래프
from collections import deque
def bfs(computers, i, n, cnt):
  dq = deque([i])

  while dq:
    curr = dq.popleft()
    for j in range(n):
      if curr == j:
        continue
      if computers[curr][j] == 1:
        dq.append(j)
        computers[curr][j] = cnt
        computers[j][curr] = cnt
  return computers, cnt
def solution(n, computers):
  cnt = 0
  for i in range(n):
    zerocnt = 0
    for j in range(n):
      if computers[i][j] == 0:
        zerocnt += 1
      if i!=j and computers[i][j] == 1:
        computers, cnt = bfs(computers, i, n, cnt-1)
    else:
      if zerocnt == n-1:
        cnt -= 1
  return -cnt
# print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
# print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))


# 프로그래머스 3단계 테스트 -> 길찾기
def solution(m, n, puddles):
  l1 = [[0 for j in range(m+1)] for i in range(n+1)]
  l1[1][1] = 1
  print(l1)
  for i in range(1, n+1):
    for j in range(1, m+1):
      if (i, j) == (1, 1):
        continue
      if [j, i] in puddles:
        continue
      l1[i][j] = (l1[i-1][j] + l1[i][j-1])%1000000007
  return l1[-1][-1]
# solution(4, 3, [[2, 2]])


########################################################
# 21.03.03 테스트 불합격
# 프로그래머스 3단계 테스트 -> dp 동적계획법
def do(l1):
    memo = [0]*len(l1)
    memo[0] = l1[0]
    memo[1] = max(l1[0], l1[1])
    for i in range(len(l1)):
      if memo[i] != 0:
        continue
      else:
        memo[i] = max(memo[i-2]+l1[i], memo[i-1])
    return memo[-1]
def solution(sticker):
    if len(sticker) <= 2:
      return max(sticker)
    return max(do(sticker[:-1]), do(sticker[1:]))
# print(solution([14, 6, 5, 11, 3, 9, 2, 10]))


# 프로그래머스 3단계 테스트 -> 시뮬레이션, 구현 ※미해결
import math
def toInt(s):
    h, m = s.split(':')
    return int(h) * 60 + int(m)
def toHour(n):
    if n // 60 < 10:
        h = '0' + str(n // 60)
    else:
        h = str(n // 60)
    if n % 60 < 10:
        m = '0' + str(n % 60)
    else:
        m = str(n % 60)
    return h + ":" + m
def find(bus, currCrews, m):
    cnt = 0
    temp = -1
    currCrews = list(map(int, currCrews))
    for crew in currCrews:
        temp = crew
        cnt += 1
        if cnt == m:
            if currCrews.count(crew) >= m - 1:
                print("fail", crew - 1)
                return (crew - 1)
            else:
                return (crew)
    return bus

def solution(n, t, m, timetable):
    answer = ''
    crewTime = sorted(list(map(toInt, timetable)))
    for i in range(1, len(crewTime)):
        if crewTime[i] == int(crewTime[i - 1]):
            crewTime[i] = round(crewTime[i - 1] + 0.0001, 4)
    crewTimeSet = set(crewTime)
    busTime = []
    for i in range(n):
        busTime.append(540 + (i * t))
    dic = {}
    for bus in busTime:
        dic[bus] = []
    for crew in crewTime:
        for bus in busTime:
            if bus >= int(crew) and crew in crewTimeSet:
                dic[bus] = dic[bus] + [crew]
                crewTimeSet -= {crew}

    con = 0
    for bus in sorted(busTime, reverse=True):
        currCrews = sorted(dic[bus])
        con = max(con, find(bus, currCrews, m))

    return toHour(con)
# print(solution(1, 1, 5, ["08:00", "08:01", "08:02", "08:03"]))
# print(solution(2, 10, 2, ["09:10", "09:09", "08:00"]))
# print(solution(2, 1, 2, ["09:00", "09:00", "09:00", "09:00"]))