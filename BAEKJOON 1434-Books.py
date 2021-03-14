# 백준 1434 책 정리 -> 그리디
from collections import deque
n, m = map(int, input().split())
dq1 = deque(list(map(int, input().split())))
dq2 = deque(list(map(int, input().split())))
box = dq1.popleft()
book = dq2.popleft()
ans = 0
cnt = 0
while cnt < 5:
  cnt += 1
  print(cnt, box, book, ans)
  if box >= book:
    box -= book
    book = dq2.popleft()
    if box < book:
      ans += box
      box = dq1.popleft()
  else:
    ans += box
    box = dq1.popleft()
print(ans)