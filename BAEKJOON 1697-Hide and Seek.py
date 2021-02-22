# 백준 1697 숨바꼭질
from collections import deque

def bfs(n, k, dq):
  visited = {n:0}
  while True:
    curr = dq.popleft()
    if curr == k:
      return visited[curr]
    if curr-1 >= 0 and curr-1 not in visited.keys():
      dq.append(curr-1)
      visited[curr-1] = visited[curr]+1
    if curr+1 <= 100000 and curr+1 not in visited.keys():
      dq.append(curr+1)
      visited[curr+1] = visited[curr]+1
    if curr*2 <= 100000 and curr*2 not in visited.keys():
      dq.append(curr*2)
      visited[curr*2] = visited[curr]+1

n, k = map(int, input().split())

dq = deque([n])
print(bfs(n, k, dq))