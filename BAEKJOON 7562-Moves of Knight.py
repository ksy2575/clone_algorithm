# 백준 7562 나이트의 이동 -> visited를 만들면 시간 초과 > 이중배열로 해결
from collections import deque
def bfs(i, j, endi, endj, l):
  di = [-2, -2, -1, -1, 1, 1, 2, 2]
  dj = [-1, 1, -2, 2, -2, 2, -1, 1]
  dq = deque([(i, j, 0)])
  l1 = [[0 for _ in range(l)] for _ in range(l)]
  l1[i][j] = 1
  while dq:
    curi, curj, cnt = dq.popleft()
    if (curi, curj) == (endi, endj):
      return cnt
    for k in range(8):
      nexti = curi + di[k]
      nextj = curj + dj[k]
      if 0 <= nexti < l and 0 <= nextj < l:
        if l1[nexti][nextj] != 1:
          dq.append((nexti, nextj, cnt+1))
          l1[nexti][nextj] = 1
  return 0
t = int(input())
for _ in range(t):
  l = int(input())
  i, j = map(int, input().split())
  endi, endj = map(int, input().split())
  print(bfs(i, j, endi, endj, l))