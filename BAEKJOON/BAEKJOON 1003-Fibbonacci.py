# 백준 1003 피보나치 함수 -> dp
def fib(n):
  if cnt[n] != [0, 0]:
    pass
  else:
    l2 = fib(n-2)
    l1 = fib(n-1)
    cnt[n] = [l1[0]+l2[0], l1[1]+l2[1]]
  return cnt[n]

t = int(input())
dp = [0, 1] + [-1]*39
cnt = [[0, 0] for i in range(41)]
cnt[0] = [1, 0]
cnt[1] = [0, 1]
for _ in range(t):
  n = int(input())
  a, b = fib(n)
  print(a, b)