# 프로그래머스 징검다리 -> 이분탐색
def solution(distance, rocks, n):
    answer = -1
    rocks.sort()
    rocks.append(distance)

    left = 0
    right = distance
    curr = 0
    while left <= right:
      mid = (left+right)//2
      temp = 0
      cnt = 0
      minValue = distance
      for i in range(len(rocks)):
        if rocks[i] - temp >= mid:
          minValue = min(rocks[i] - temp, minValue)
          temp = rocks[i]
        else:
          cnt += 1
      if cnt > n:
        right = mid-1
      else:
        answer = max(answer, minValue)
        left = mid+1

    return answer


solution(25, [2, 14, 11, 21, 17], 2)