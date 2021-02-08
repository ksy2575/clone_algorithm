# 백준 1012 유기농 배추
import sys
def dfs(l1, node, visited):
  i, j = node
  visited.append(node)
  l1[i][j] = 1
  global n, m
  for k in range(4):
    if 0 <= i+di[k] < n and 0 <= j+dj[k] < m:
      if l1[i+di[k]][j+dj[k]] == 1:
        if (i+di[k], j+dj[k]) not in visited:
          dfs(l1, (i+di[k], j+dj[k]), visited)

sys.setrecursionlimit(10**7)
di = [1, -1, 0, 0]
dj = [0, 0, 1, -1]
t = int(input())
for _ in range(t):
  m, n, k = map(int, input().split())
  l1 = [[0 for _ in range(m)] for _ in range(n)]
  for _ in range(k):
    x, y = map(int, input().split())
    l1[y][x] = 1
  cnt = 0
  visited = []
  for i in range(n):
    for j in range(m):
      if l1[i][j] == 1 and (i, j) not in visited:
        dfs(l1, (i, j), visited)
        cnt += 1
  print(cnt)
