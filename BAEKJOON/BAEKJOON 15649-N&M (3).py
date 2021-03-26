# 백준 15649 N과 M (3) -> 백트래킹
def backtracking(n, m, l1):
  if m == 0:
    print(' '.join(list(map(str, l1))))
    return
  for i in range(1, n+1):
    backtracking(n, m-1, l1+[i])

n, m = map(int, input().split())
backtracking(n, m, [])