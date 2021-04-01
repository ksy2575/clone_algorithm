# 백준 9663 N-Queen -> 백트래킹
def promising(i, l1):
  k = 1
  flag = True
  while k<i and flag:
    if l1[i] == l1[k] or abs(l1[i] - l1[k]) == i-k:
      flag = False
    k += 1
  return flag
def dfs(i, l1):
  n = len(l1)-1
  cnt = 0
  if promising(i, l1):
    if i == n:
      global ans
      ans += 1
    else:
      for j in range(1, n+1):
        l1[i+1] = j
        dfs(i+1, l1)
n = int(input())
l1 = [0 for _ in range(n+1)]
ans = 0
dfs(0, l1)
print(ans)