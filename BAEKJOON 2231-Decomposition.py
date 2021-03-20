# 백준 2231 분해합
n = int(input())
for i in range(1, n):
  temp, curr = i, i
  while i > 0:
    temp += i%10
    i //= 10
  if temp == n:
    print(curr)
    break
else:
  print(0)