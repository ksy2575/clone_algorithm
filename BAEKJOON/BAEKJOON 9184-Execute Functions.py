# 백준 9184 신나는 함수 실행 -> dp
l1 = [[[None for i in range(101)] for j in range(101)] for k in range(101)]
def w(a, b, c):
  if l1[a][b][c] != None:
    return l1[a][b][c]
  if a <= 0 or b <= 0 or c <= 0:
    l1[a][b][c] = 1
    return 1

  if a > 20 or b > 20 or c > 20:
    l1[a][b][c] = w(20, 20, 20)
    return l1[a][b][c]

  if a < b and b < c:
    l1[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
    return l1[a][b][c]

  else:
    l1[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    return l1[a][b][c]

while True:
  a, b, c = map(int, input().split())
  if (a, b, c) == (-1, -1, -1):
    break
  else:
    print('w' + str((a, b, c)) + ' = ' + str(w(a, b, c)))