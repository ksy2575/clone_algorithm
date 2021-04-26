# 백준 9095 1, 2, 3 더하기 -> dp
t = int(input())
dpList = [0] * 12
dpList[1] = 1
dpList[2] = 2
dpList[3] = 4
dpList[4] = 7
for _ in range(t):
  n = int(input())
  for i in range(5, n+1):
    if dpList[i] == 0:
      dpList[i] = dpList[i-1]+dpList[i-2]+dpList[i-3]
  print(dpList[n])