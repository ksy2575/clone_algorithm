# 백준 1966 프린터 큐 -> 큐
from collections import deque
t = int(input())
for _ in range(t):
  n, pos = map(int, input().split())
  dq = deque(map(int, input().split()))
  cnt = 0
  while True:
    curr = dq.popleft()
    pos -= 1
    for next in dq:
      if next > curr:
        dq.append(curr)
        if pos == -1:
          pos = len(dq)-1
        break
    else:
      cnt += 1
      if pos == -1:
        print(cnt)
        break