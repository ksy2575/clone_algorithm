# 백준 1010 다리 놓기
t = int(input())
for _ in range(t):
  n, m = map(int, input().split())
  a, b = 1, 1
  for i in range(n):
    a *= m-i
  for i in range(1, n+1):
    b *= i
  print(a//b)