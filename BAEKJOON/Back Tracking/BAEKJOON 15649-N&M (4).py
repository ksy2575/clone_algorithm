# 백준 15649 N과 M (4) -> 백트래킹
def backtracking(n, m, l1):
  if m == 0:
    print(' '.join(list(map(str, l1))))
    return
  if l1 == []:
    pre = 0
  else:
    pre = l1[-1]
  for i in range(1, n+1):
    if i >= pre:
      backtracking(n, m-1, l1+[i])

n, m = map(int, input().split())
backtracking(n, m, [])