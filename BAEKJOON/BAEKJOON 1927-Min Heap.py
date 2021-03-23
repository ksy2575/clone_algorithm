# 백준 1927 최소 힙 -> 힙
import heapq
import sys
n = int(input())
l1 = []
for _ in range(n):
  curr = int(sys.stdin.readline().rstrip())
  if curr == 0:
    if l1 == []:
      print(0)
    else:
      print(heapq.heappop(l1))
  else:
    heapq.heappush(l1, curr)