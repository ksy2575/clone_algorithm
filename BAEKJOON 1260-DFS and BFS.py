# 백준 1260 DFS와 BFS
from collections import deque
import sys


def dfs(l1, v, visited):
    visited[v] = True
    print(v, end=' ')
    for i in l1[v]:
        if not visited[i]:
            dfs(l1, i, visited)


def bfs(l1, dq, visited):
    if len(dq) == 0:
        return None
    v = dq.popleft()
    visited[v] = True
    print(v, end=' ')
    for i in l1[v]:
        if not visited[i] and i not in dq:
            dq.append(i)

    bfs(l1, dq, visited)


sys.setrecursionlimit(10 ** 6)
n, m, v = map(int, input().split())
l1 = [[] for _ in range(n + 1)]
for i in range(m):
    a, b = map(int, input().split())
    l1[a].append(b)
    l1[b].append(a)
for i in range(n + 1):
    l1[i].sort()
visited = [False] * (n + 1)
dfs(l1, v, visited)
print("")
dq = deque([v])
visited = [False] * (n + 1)
bfs(l1, dq, visited)