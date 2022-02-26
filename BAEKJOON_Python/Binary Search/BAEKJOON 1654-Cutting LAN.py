# 백준 1654 랜선 자르기
k, n = map(int, input().split())
l1 = []
for _ in range(k):
  l1.append(int(input()))
start = 0
end = max(l1)
mid = (start+end)//2
ansTemp = -1
while True:
  if mid == start or mid == end:
    break
  temp = 0
  mid = (start+end)//2
  if mid == 0:
    mid = 1
  for i in range(k):
    temp += l1[i]//mid
  if temp < n:
    end = mid-1
  elif temp >= n:
    if mid > ansTemp:
      ansTemp = mid
    start = mid+1
if mid == 0:
  if sum(l1) >= n:
    print(1)
else:
  print(ansTemp)