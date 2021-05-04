# 백준 11049 행렬 곱셈 순서 -> dp
import sys
sys.setrecursionlimit(10**8)
n = int(input())
l1 = []
for _ in range(n):
  # l1.append(list(map(int, input().split())))
  l1.append(list(map(int, sys.stdin.readline().split())))
# n = 5
# l1 = [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6]]
dp = [[0 for _ in range(n)] for _ in range(n)]
def do(l1, index):
  if len(l1) == 1:
    return 0, l1[0]
  if dp[index][index+len(l1)-1] != 0:
    return dp[index][index+len(l1)-1], [l1[0][0], l1[-1][1]]
  if len(l1) == 2:
    cost = l1[0][0]*l1[0][1]*l1[1][1]
    matrix = [l1[0][0], l1[1][1]]
    dp[index][index+1] = cost
    return cost, matrix
  cost = float('inf')
  matrix = [l1[0][0], l1[-1][1]]
  for i in range(1, len(l1)):
    leftList = l1[:i]
    rightList = l1[i:]
    dpLeft = do(leftList, 0)
    dpRight = do(rightList, i)
    cost = min(cost, dpLeft[0]+dpRight[0]+dpLeft[1][0]*dpLeft[1][1]*dpRight[1][1])
  dp[index][index+len(l1)-1] = cost
  return cost, matrix

print(do(l1, 0)[0])
# print(dp)