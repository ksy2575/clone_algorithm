# 백준 1300 K번째 수
n = int(input())
k = int(input())

left = 0
right = k
ans = -1

while right >= left:
  mid = (left + right)//2
  cnt = 0
  for i in range(n):
    cnt += min(mid//(i+1), n)
  if cnt < k:
    left = mid + 1
  elif cnt >= k:
    right = mid -1
    ans = mid

print(ans)