# 백준 1669 멍멍이 쓰다듬기

n, m = map(int, input().split())
ans = 0

temp = m-n
cnt = 1
while True:
  if temp - cnt*2 >= 0:
    temp -= cnt*2
  else:
    if temp > cnt:
      ans += 2
    elif temp != 0:
      ans += 1
    break
  cnt += 1
  ans += 2

print(ans)