# 백준 1018 체스판 다시 칠하기 -> 브루트포스
def do(l1, i, j):
  toBlack = 1
  cnt = 0
  for ii in range(8):
    for jj in range(8):
      if l1[i+ii][j+jj] == 'B':
        isBlack = 1
      else:
        isBlack = -1
      if toBlack != isBlack:
        cnt += 1
      toBlack = toBlack*(-1)
    toBlack = toBlack*(-1)
  return min(cnt, 64-cnt)
n, m = map(int, input().split())
l1 = []
for _ in range(n):
  l1.append(list(input()))
ans = 64
for i in range(n-7):
  for j in range(m-7):
    ans = min(ans, do(l1, i, j))
print(ans)