# 백준 10816 숫자 카드 2
import bisect
n = int(input())
l1 = list(map(int, input().split()))
m = int(input())
l2 = list(map(int, input().split()))
l1.sort()
for l in l2:
  print(bisect.bisect_right(l1,l)-bisect.bisect_left(l1,l), end=" ")