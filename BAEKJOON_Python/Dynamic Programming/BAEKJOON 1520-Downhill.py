# 백준 1520 내리막 길 -> dp
import sys
sys.setrecursionlimit(10**7)
def do(l1, curr):
  i, j = curr
  if dp[i][j][1]:
    return dp[i][j][0]
  di = [1, -1, 0, 0]
  dj = [0, 0, 1, -1]
  temp = 0
  for k in range(4):
    if 0 <= i+di[k] < len(l1) and 0 <= j+dj[k] < len(l1[0]):
      if l1[i+di[k]][j+dj[k]] > l1[i][j]:
        temp += do(l1, (i+di[k], j+dj[k]))
  dp[i][j][0] = temp
  dp[i][j][1] = True
  return temp
n, m = map(int, input().split())
dp = [[[0, False] for _ in range(m)] for _ in range(n)]
dp[0][0][0] = 1
dp[0][0][1] = True
l1 = []
for _ in range(n):
  l1.append(list(map(int, input().split())))
print(do(l1, (n-1, m-1)))