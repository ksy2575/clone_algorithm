# 백준 7576 토마토
# deque를 한 번씩 검사했던 기존 구문이 시간초과를 야기함
from collections import deque
import sys

# r = sys.stdin.readline
m, n = map(int, input().split())
l1 = []
di = [1, -1, 0, 0]
dj = [0, 0, 1, -1]
cnt = 0
dq = deque()
for i in range(n):
    tempList = list(map(int, input().split()))
    for j in range(m):
        if tempList[j] == 1:
            dq.append((i, j))
    l1.append(tempList)
temp = -1
while dq:

    i, j = dq.popleft()
    for k in range(4):
        if 0 <= i + di[k] < n and 0 <= j + dj[k] < m:
            if l1[i + di[k]][j + dj[k]] == 0:
                l1[i + di[k]][j + dj[k]] = l1[i][j] + 1
                temp = max(temp, l1[i][j] + 1)
                dq.append((i + di[k], j + dj[k]))

for i in range(n):
    if 0 in l1[i]:
        print(-1)
        break
else:
    if temp == -1:
        print(0)
    else:
        print(temp - 1)