# 프로그래머스 무지의 먹방 라이브 -> 이분 탐색
def solution(food_times, k):
    ans = 0
    left = 0
    right = 100000000
    length = len(food_times)

    while left <= right:
      mid = (left+right)//2
      time = mid*length
      for food in food_times:
        temp = food-mid
        if temp < 0:
          time += temp
      if time <= k:
        left = mid + 1
        aroundTime = mid
        retTime = time
      else:
        right = mid - 1
    for i in range(length):
      food_times[i] -= aroundTime
    ans = k-retTime
    for i in range(length+1):
      if ans == -1:
        return i
      if i == length:
        return -1
      if food_times[i] > 0:
        ans -= 1
# print(solution([3, 1, 2], 5))
# print(solution([1, 1, 1, 1], 3))
# print(solution([4, 2, 3, 6, 7, 1, 5, 8], 17))
# print(solution([100000000, 100000000, 100000000], 2 * 10**13))
# solution([1, 5, 5, 5, 5, 6, 7], 31)