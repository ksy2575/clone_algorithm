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
      sumTemp = 0
      isTrue = False
      temp = float('inf')
      for v in dic[curr]:
        sumTemp += do(dic, v)[0]
      for v in dic[curr]:
        if dp[v][1] <= dp[v][0]:
          isTrue = True
          sumTemp = sumTemp-dp[v][0]+dp[v][1]
        temp = min(temp, dp[v][1] - dp[v][0])
      if isTrue:
        dp[curr][0] = sumTemp
      else:
        dp[curr][0] = sumTemp + temp

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