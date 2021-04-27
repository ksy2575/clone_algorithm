# 백준 1038 감소하는 수 -> 브루트포스, 백트래킹   ※큐에 유망한 후보를 삽입
from collections import deque
n = int(input())
dq = deque([(i, str(i)) for i in range(10)])
cnt = 0
ans = 0
while cnt <= n:
  if not dq:
    ans = -1
    break
  curr, temp = dq.popleft()
  for i in range(int(temp[-1])):
    dq.append((i, temp+str(i)))
  cnt += 1
  ans = temp
print(ans)