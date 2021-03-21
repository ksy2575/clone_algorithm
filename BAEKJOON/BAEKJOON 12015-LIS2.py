# 백준 12015 가장 긴 증가하는 부분 수열2 - 이분 탐색으로 해결
n = int(input())
l1 = list(map(int, input().split()))
maxNum = []
for i in range(n):
  value = l1[i]
  left = 0
  right = len(maxNum)-1
  index = -1
  while left <= right:
    mid = (left+right)//2
    if maxNum[mid] < value:
      left = mid + 1
    else:
      index = mid
      right = mid - 1
  if index == -1:
    maxNum.append(l1[i])
  else:
    maxNum[index] = value

print(len(maxNum))