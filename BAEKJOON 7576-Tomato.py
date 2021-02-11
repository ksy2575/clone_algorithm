# 백준 7576 토마토

def tomato(l1, node, visited):
  i, j = node
  tempList2 = []
  global n, m
  for k in range(4):
    if 0 <= i + di[k] < n and 0 <= j + dj[k] < m:
      if l1[i + di[k]][j + dj[k]] == 0:
        if (i + di[k], j + dj[k]) not in visited:
          l1[i + di[k]][j + dj[k]] = 1
          tempList2.append((i + di[k], j + dj[k]))
  return(tempList2)

m, n = map(int, input().split())
l1 = []
visited = []
di = [1, -1, 0, 0]
dj = [0, 0, 1, -1]
tempList = []
tempList3 = []
zero = False
cnt = 0
flag = False
for i in range(n):
  l1.append(list(map(int, input().split())))

for i in range(n):
  for j in range(m):
    if l1[i][j] == 1:
      visited.append((i, j))
    elif l1[i][j] == 0:
      zero = True
if zero:
  while True:
    temp = len(visited)
    for v in visited:
      tempList = tomato(l1, v, visited)
      for t in tempList:
        tempList3.append(t)
    for t in tempList3:
      if t not in visited:
        visited.append(t)
    cnt += 1
    for i in range(n):
      if 0 in l1[i]:
        if temp == len(visited):
          print(-1)
          flag = True
        break
    else:
      print(cnt)
      break
    if flag:
      break
else:
  print(0)