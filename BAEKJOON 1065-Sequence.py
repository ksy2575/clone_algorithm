# 백준 1065 한수 -> 브루트 포스
n = input()
cnt = 0
if len(n) <= 2:
  print(n)
else:
  for i in range(100, int(n)+1):
    s = str(i)
    if int(s[2])-int(s[1]) == int(s[1])-int(s[0]):
      cnt += 1
  print(99 + cnt)