# 프로그래머스 매출 하락 최소화
from collections import defaultdict
import sys
saleList = []
dp = []
def do(dic, curr):
    if curr not in dic:
      dp[curr][0] = 0
      dp[curr][1] = saleList[curr-1]
      return (dp[curr][0], dp[curr][1])

    if dp[curr][0] == -1:
      temp = float('inf')
      sumTemp = 0
      for v in dic[curr]:
        sumTemp += do(dic, v)[0]
      for v in dic[curr]:
        temp = min(temp, sumTemp-dp[v][0]+dp[v][1])
      dp[curr][0] = temp

    if dp[curr][1] == -1:
      temp = 0
      for v in dic[curr]:
        temp += min(do(dic, v))
      dp[curr][1] = saleList[curr-1]+temp

    return (dp[curr][0], dp[curr][1])

def solution(sales, links):
    sys.setrecursionlimit(10**8)
    dic = defaultdict(set)
    global saleList, dp
    saleList = sales
    dp = [[0, 0]] +[[-1, -1] for _ in range(len(sales))]
    for link in links:
      dic[link[0]].add(link[1])
    return min(do(dic, 1))
print(solution([14, 17, 15, 18, 19, 14, 13, 16, 28, 17], [[10, 8], [1, 9], [9, 7], [5, 4], [1, 5], [5, 10], [10, 6], [1, 3], [10, 2]]))
print(solution([5, 6, 5, 3, 4], [[2,3], [1,4], [2,5], [1,2]]))
print(solution([5, 6, 5, 1, 4], [[2,3], [1,4], [2,5], [1,2]]))
print(solution([10, 10, 1, 1], [[3,2], [4,3], [1,4]]))
print(solution([0, 0], [[1,2]]))
print(solution([i for i in range(9000)], [[i,i+1] for i in range(9000)]))