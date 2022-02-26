# 백준 11053 가장 긴 증가하는 부분 수열 - DP로 해결
n = int(input())
l1 = list(map(int, input().split()))
d = [0]*n
for i in range(n):
  if i == 0:
    d[i] = 1
  else:
    l2 = []
    for j in range(i-1, -1, -1):
      if l1[j] < l1[i]: l2.append(d[j])
    if len(l2) != 0: d[i] = max(l2)+1
    else: d[i] = 1
print(max(d))