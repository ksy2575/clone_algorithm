# 프로그래머스 입국심사 -> 이분탐색
def solution(n, times):
    answer = 0
    times.sort()
    ansList = []
    left = 0
    right = (n*times[-1]//len(times))+1
    print(right)
    while left <= right:
      mid = (left+right)//2
      print(left, right, mid)
      temp = 0
      for t in times:
        temp += mid//t
      print(temp, n)
      if temp >= n:
        ansList.append(mid)
        right = mid-1
      else:
        left = mid+1
    return min(ansList)


# solution(6, [7, 10])
# solution(20, [3,5,7,10,15])