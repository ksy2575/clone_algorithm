# 프로그래머스 매출 하락 최소화
from collections import defaultdict
from copy import deepcopy
import sys
saleList = []
dp = []
def do(l1, i, set1, pre):
    temp = 2147483648
    print(dp)
    print(set1)
    if pre != 0 and dp[pre] != -1:
      return dp[pre]
    for v in l1[i]:
      if i == len(l1)-1:
        dp[v] = saleList[v-1]
      else:
        dp[v] = do(l1, i+1, set1|set([v]), v)
      temp = min(temp, dp[v])
    return temp+saleList[pre-1]

def solution(sales, links):
    sys.setrecursionlimit(10**7)
    dic = defaultdict(set)
    global saleList, dp
    saleList = sales
    dp = [0] + [-1]*len(sales)
    print(dp)
    for link in links:
      dic[link[0]].add(link[0])
      dic[link[0]].add(link[1])
    print(sales)
    print(dic)

    return do(list(dic.values()), 0, set(), 0)
print(solution([14, 17, 15, 18, 19, 14, 13, 16, 28, 17], [[10, 8], [1, 9], [9, 7], [5, 4], [1, 5], [5, 10], [10, 6], [1, 3], [10, 2]]))