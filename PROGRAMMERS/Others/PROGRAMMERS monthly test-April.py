# 프로그래머스 월간 코딩 테스트 시즌2 (4월) 문제 1
def do(signs, i):
    return 1 if signs[i] else -1
def solution(absolutes, signs):
    answer = 0
    for i in range(len(absolutes)):
        curr = absolutes[i]
        sign = do(signs, i)
        answer += sign*curr
    return answer
# print(solution([4,7,12], [true,false,true]))

# 프로그래머스 월간 코딩 테스트 시즌2 (4월) 문제 2
from collections import defaultdict
def solution(s):
    answer = 0
    dic = defaultdict(str)
    dic['('] = ')'
    dic['['] = ']'
    dic['{'] = '}'
    for i in range(len(s)):
        curr = s[i:]+s[:i]
        stack = []
        for char in curr:
            if stack != [] and dic[stack[-1]] == char:
                stack.pop()
            else:
                stack.append(char)
        if stack == []:
            answer += 1
    return answer
# print(solution("[](){}"))

# 프로그래머스 월간 코딩 테스트 시즌2 (4월) 문제 3
from collections import defaultdict
import sys
sys.setrecursionlimit(10**8)
def dfs(curr, a, dict, visited):
    cnt = 0
    visited.add(curr)
    for next in dict[curr]:
      if next not in visited:

        value, child = dfs(next, a, dict, visited)

        a[curr] += value
        cnt += child

    retVal = a[curr]
    a[curr] = 0
    return retVal, abs(retVal)+cnt
def solution(a, edges):
    set1 = set([i for i in range(len(a))])
    dict = defaultdict(set)
    for edge in edges:
      dict[edge[0]].add(edge[1])
      dict[edge[1]].add(edge[0])
    for key in dict:
      if len(dict[key]) == 1:
        start = key
        break
    visited = set()
    value, answer = dfs(start, a, dict, visited)
    return answer if value == 0 else -1
# print(solution([-5,0,2,1,2], [[0,1],[3,4],[2,3],[0,3]]))

# 프로그래머스 월간 코딩 테스트 시즌2 (4월) 문제 4 -> 시간초과
from collections import defaultdict
from collections import deque
dp = defaultdict(list)
def bfs(n, z, dic, query):
    dq = deque([(0, 0, 0, False)])
    while dq:
      # print(dq)
      curr, turn, money, isJumped = dq.popleft()
      if money == query:
        return turn
      turn += 1
      if money+z <= query:
        dq.append((curr, turn, money+z, False))
      for next in dic[curr]:
        i, w = next
        if money+w <= query:
          dq.append((i, turn, money+w, False))
      if not isJumped:
        for i in range(n):
          if i != curr:
            dq.append((i, turn, money, True))
    else:
      return -1

def solution(n, z, roads, queries):
    answer = []
    dic = defaultdict(list)
    for road in roads:
      dic[road[0]].append((road[1], road[2]))
    for query in queries:
      # print('  ')
      # print('  ')
      # print('  ')
      answer.append(bfs(n, z, dic, query))
    return answer

# print(solution(5, 5, [[1,2,3],[0,3,2]], [0,1,2,3,4,5,6]))