# 백준 1434 책 정리 -> 그리디
from collections import deque
n, m = map(int, input().split())
boxes = deque(list(map(int, input().split())))
books = deque(list(map(int, input().split())))
isBox, isBook = True, True
ans = 0
while True:
  if isBox:
    box = boxes.popleft()
    isBox = False
  if isBook:
    if books:
      book = books.popleft()
      isBook = False
    else:
      ans += box
      ans += sum(boxes)
      break

  if box>=book:
    box -= book
    isBook = True
  else:
    ans += box
    isBox = True
print(ans)