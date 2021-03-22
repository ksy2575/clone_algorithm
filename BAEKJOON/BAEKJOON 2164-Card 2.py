# 백준 2164 카드2 -> 큐
from collections import deque
n = int(input())
l1 = [i for i in range(1, n+1)]
dq = deque(l1)
isTwice = False
while dq:
  curr = dq.popleft()
  if isTwice:
    dq.append(curr)
  isTwice = not isTwice
print(curr)