# 프로그래머스 무지의 먹방 라이브
def solution(food_times, k):
    ans = 0
    left = 0
    right = 2000000
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
      else:
        right = mid - 1
    for i in range(length):
      food_times[i] -= aroundTime
    ans = k-(aroundTime * length)
    for i in range(length):
      if ans == 0:
        return i
      if food_times[i] < 0:
        ans += food_times[i]
    return -1
# print(solution([3, 1, 2], 5))
print(solution([4, 2, 3, 6, 7, 1, 5, 8], 16))
# print(solution([100000000, 100000000, 100000000], 2 * 10**13))