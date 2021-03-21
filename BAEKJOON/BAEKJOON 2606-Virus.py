# 백준 2606 바이러스
def dfs(l1, v, visited):
  visited[v] = True
  global cnt
  cnt += 1
  for i in l1[v]:
    if not visited[i]:
      dfs(l1, i, visited)

n = int(input())
m = int(input())
l1 = [[] for _ in range(n+1)]
for i in range(m):
  a, b = map(int, input().split())
  l1[a].append(b)
  l1[b].append(a)
visited = [False]*(n+1)
cnt = -1
dfs(l1, 1, visited)
print(cnt)