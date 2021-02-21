# 백준 7569 토마토 -> 3차원 BFS
from copy import deepcopy
from collections import deque
def bfs(dq, cnt):

  ans = 0
  while dq and cnt > 0:
    i, j, k = dq.popleft()
    for t in range(6):
      if 0 <= i + di[t] < n and 0 <= j + dj[t] < m and 0 <= k + dk[t] < h:
        if l1[k + dk[t]][i + di[t]][j + dj[t]] == 0:
          temp = l1[k][i][j] + 1
          if ans < temp:
            ans = temp-1
          l1[k + dk[t]][i + di[t]][j + dj[t]] = temp
          dq.append((i + di[t], j + dj[t], k + dk[t]))
          cnt -= 1

  return ans if cnt == 0 else -1

m, n, h = map(int, input().split())
l1 = []
dq = deque()
di = [1, -1, 0, 0, 0, 0]
dj = [0, 0, 1, -1, 0, 0]
dk = [0, 0, 0, 0, 1, -1]
cnt = n*m*h
for k in range(h):
  l2 = []
  for i in range(n):
    l2.append(list(map(int, input().split())))
    for j in range(m):
      if l2[i][j] == 1:
        dq.append((i, j, k))
        cnt -= 1
      elif l2[i][j] == -1:
        cnt -= 1
  l1.append(l2)

print(bfs(dq, cnt))