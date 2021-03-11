# 라인 코딩테스트 나 잡아봐라
from collections import deque
c, b = map(int, input().split())
l1 = [[-1]*2 for _ in range(200000)]
dq = deque([(b, 0)])
time = 0
l1[b][0] = 0
while c<=200000:
  if l1[c][time%2] != -1:
    print(time)
    break
  time += 1
  c += time
  while True:
    curr, cnt = dq[0]
    if cnt != time-1:
      break
    curr, cnt = dq.popleft()
    if 0 <= curr-1 <= 200000 and l1[curr-1][time%2] == -1:
      dq.append((curr-1, time))
      l1[curr-1][time%2] = time
    if 0 <= curr+1 <= 200000 and l1[curr+1][time%2] == -1:
      dq.append((curr+1, time))
      l1[curr+1][time%2] = time
    if 0 <= curr*2 <= 200000 and l1[curr*2][time%2] == -1:
      dq.append((curr*2, time))
      l1[curr*2][time%2] = time
if c > 200000:
  print(-1)