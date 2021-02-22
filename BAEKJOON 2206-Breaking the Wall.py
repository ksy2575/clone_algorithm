# 백준 2206 벽 부수고 이동하기 -> 경로 저장
from collections import deque
def bfs(n, m):
  dq = deque()
  dq.append([0, 0, 0])
  di = [1, -1, 0, 0]
  dj = [0, 0, 1, -1]
  visit = [[[-1, -1] for _ in range(m)] for _ in range(n)]
  visit[0][0][0] = 1

  while dq:
    i, j, z = dq.popleft()
    if (i, j) == (n-1, m-1):
      return max(visit[i][j])
    for k in range(4):
      ni, nj = (i + di[k], j + dj[k])
      if 0 <= ni < n and 0 <= nj < m:
        if l1[ni][nj] == 0 and visit[ni][nj][z] == -1:
          visit[ni][nj][z] = visit[i][j][z]+1
          dq.append([ni, nj, z])
        elif z == 0 and l1[ni][nj] == 1 and visit[ni][nj][1] == -1:
          visit[ni][nj][1] = visit[i][j][z] + 1
          dq.append([ni, nj, 1])

  return -1
l1 = []
n, m = map(int, input().split())
for _ in range(n):
  l1.append(list(map(int, list(input()))))
print(bfs(n, m))

# 이하는 틀린 코드 (경로 저장 > 시간초과)
# from collections import deque
# def bfs(n, m):
#   dq = deque([[False, [(0, 0)]]])
#   di = [1, -1, 0, 0]
#   dj = [0, 0, 1, -1]
#
#   while dq:
#     isWall, visited = dq.popleft()
#     i, j = visited[-1]
#     if (i, j) == (n-1, m-1):
#       return len(visited)
#     for k in range(4):
#       if 0 <= i + di[k] < n and 0 <= j + dj[k] < m:
#         if (i + di[k], j + dj[k]) not in visited:
#           if l1[i + di[k]][j + dj[k]] != 1:
#             dq.append([isWall, visited + [(i + di[k], j + dj[k])]])
#           elif not isWall:
#             dq.append([True, visited + [(i + di[k], j + dj[k])]])
#   return -1
# l1 = []
# n, m = map(int, input().split())
# for _ in range(n):
#   l1.append(list(map(int, list(input()))))
# print(bfs(n, m))