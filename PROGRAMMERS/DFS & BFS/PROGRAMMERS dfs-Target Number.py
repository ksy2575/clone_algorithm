# 프로그래머스 타겟 넘버 -> DFS
def dfs(numbers, index, isPlus, temp):
    if index == len(numbers)-1:
      return [temp + numbers[index]] if isPlus else [temp - numbers[index]]
    else:
      if isPlus:
        return dfs(numbers, index+1, True, temp + numbers[index]) + dfs(numbers, index+1, False, temp + numbers[index])
      else:
        return dfs(numbers, index+1, True, temp - numbers[index]) + dfs(numbers, index+1, False, temp - numbers[index])
def solution(numbers, target):
    answer = 0
    stack = [0]
    temp = 0

    return (dfs(numbers, 0, True, temp) + dfs(numbers, 0, False, temp)).count(target)

# print(solution([1,1,1,1,1], 3))