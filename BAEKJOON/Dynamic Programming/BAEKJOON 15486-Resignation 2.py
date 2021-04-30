# 백준 15486 퇴사 2 -> dp - 푸는 중
from collections import defaultdict
import sys
n = int(input())
dic = defaultdict(list)
dp = [0 for _ in range(n+1)]
for i in range(1, n+1):
  # day, cost = map(int, sys.stdin.readline().split())
  day, cost = map(int, input().split())
  dic[i+day-1].append((i, cost))
  if dic[i] != []:
    temp = 0
    for curr in dic[i]:
      print(curr)
      temp = max(temp, dp[curr[0]-1]+curr[1])
    dp[i] = temp
  else:
    dp[i] = dp[i-1]
  print(dp)

print(dp[-1])