# 백준 9466 텀 프로젝트 -> dfs
import sys
def dfs(i, cycle):
  visited[i] = True
  cycle.append(i)
  next = l1[i]
  if visited[next]:
    if next in cycle:
      return cycle[cycle.index(next):]
    else:
      return []
  else:
    return dfs(next, cycle)

t = int(input())
sys.setrecursionlimit(1000000)
for _ in range(t):
  n = int(input())
  l1 = [0] + list(map(int, input().split()))
  visited = [True] + [False]*n
  for i in range(1, n+1):
    if not visited[i]:
      cycle = []
      tempList = dfs(i, cycle)
      n -= len(tempList)
  print(n)