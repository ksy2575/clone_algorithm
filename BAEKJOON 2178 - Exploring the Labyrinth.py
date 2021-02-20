# 백준 2178 미로 탐색
from collections import deque
def bfs(l1):
  visited = [(0, 0)]
  dq = deque([(0, 0, 1)])
  di = [1, -1, 0, 0]
  dj = [0, 0, 1, -1]
  cnt = 0
  while dq:
    i, j, cnt = dq.popleft()
    if (i, j) == (n-1, m-1):
      break

    for k in range(4):
      if 0 <= i + di[k] < n and 0 <= j + dj[k] < m:
        if l1[i + di[k]][j + dj[k]] == 1:
          if (i + di[k], j + dj[k]) not in visited:
            dq.append((i + di[k], j + dj[k], cnt+1))
            visited.append((i + di[k], j + dj[k]))
  return cnt

n, m = map(int, input().split())
l1 = []
for _ in range(n):
  l1.append(list(map(int, list(input()))))
print(bfs(l1))