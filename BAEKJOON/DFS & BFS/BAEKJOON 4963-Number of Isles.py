# 백준 4963 섬의 개수
import sys
def dfs(l1, node, visited):
  i, j = node
  visited.append(node)

  for k in range(8):
    if 0 <= i + di[k] < h and 0 <= j + dj[k] < w:
      if l1[i + di[k]][j + dj[k]] == 1:
        if (i + di[k], j + dj[k]) not in visited:
          dfs(l1, (i + di[k], j + dj[k]), visited)


di = [1, 1, 1, 0, 0, -1, -1, -1]
dj = [1, 0, -1, 1, -1, 1, 0, -1]
sys.setrecursionlimit(10**6)
while True:
  w, h = map(int,input().split())
  if (w, h) == (0, 0):
    break
  l1 = []
  cnt = 0
  visited = []
  for _ in range(h):
    l1.append(list(map(int, input().split())))
  for i in range(h):
    for j in range(w):
      if l1[i][j] == 1 and (i, j) not in visited:
        dfs(l1, (i, j), visited)
        cnt += 1
  print(cnt)