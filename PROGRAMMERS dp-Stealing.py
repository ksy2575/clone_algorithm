# 프로그래머스 도둑질 -> dp
from copy import deepcopy
def do(start, end, memo, money):
  for i in range(start, end):
      if len(memo) >= i+1:
        continue
      else:
        memo.append(max(memo[i-1], memo[i-2]+money[i]))
  return memo[-1]

def solution(money):
    ans = []
    tempList = deepcopy(money)
    memo = [money[0], max(money[:2]), max(money[0]+money[2], money[1])]
    ans.append(do(0, len(money)-1, memo, money))
    memo = [0, money[1], max(money[1:3])]
    ans.append(do(1, len(money), memo, money))
    return max(ans)

solution([1, 2, 3, 1])