# 백준 11866 요세푸스 문제 0 -> 큐
from collections import deque
n, k = map(int, input().split())
l1 = [str(i) for i in range(1, n+1)]
dq = deque(l1)
ans = []
while dq:
  for _ in range(k):
    curr = dq.popleft()
    dq.append(curr)
  else:
    ans.append(curr)
    dq.pop()
print('<' + ', '.join(ans) + '>')