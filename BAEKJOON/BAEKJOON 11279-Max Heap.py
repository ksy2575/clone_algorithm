# 백준 11279 최대 힙 -> 힙
import heapq
import sys
n = int(input())
l1 = []
for _ in range(n):
  curr = int(sys.stdin.readline().rstrip())
  if curr == 0:
    if l1 == []:
      print(0)
    else:ㄴ
      print(-heapq.heappop(l1))
  else:
    heapq.heappush(l1, -curr)