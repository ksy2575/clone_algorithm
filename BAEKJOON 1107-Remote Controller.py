# 백준 1107 리모컨 -> 브루트포스
n = int(input())
m = int(input())
set1 = {}
if m != 0:
  set1 = set(map(int, input().split()))

ans = abs(n-100)

for i in range(1000001):
  for s in str(i):
    if int(s) in set1:
      break
  else:
    ans = min(ans, abs(n-i)+len(str(i)))
print(ans)