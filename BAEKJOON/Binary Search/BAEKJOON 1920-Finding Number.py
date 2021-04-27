# 백준 1920 수 찾기
n = int(input())
l1 = list(map(int, input().split()))
m = int(input())
l2 = list(map(int, input().split()))
l1.sort()
for l in l2:
  start = 0
  end = n-1
  middle = (start+end)//2
  while True:
    if middle == start or middle == end:
      print("0")
      break
    middle = (start+end)//2
    if l < l1[middle]:
      end = middle-1
    elif l > l1[middle]:
      start = middle+1
    else:
      print("1")
      break