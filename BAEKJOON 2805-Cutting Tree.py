# 백준 2805 나무 자르기 -> pypy3
import sys
n, m = map(int, sys.stdin.readline().split())
l1 = list(map(int, sys.stdin.readline().split()))
l1.sort(reverse = True)
start = 0
end = max(l1)
result = 0
while True:
  temp = 0
  mid = (start + end)//2
  for i in range(n):
    if l1[i] <= mid:
      break
    temp += l1[i]-mid
  if temp < m:
    end = mid - 1
  else:
    result = mid
    start = mid + 1
  if start > end:
    break
print(result)