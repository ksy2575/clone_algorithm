# 백준 11049 행렬 곱셈 순서 -> dp
import sys
n = int(input())
l1 = []
for _ in range(n):
  # l1.append(list(map(int, input().split())))
  l1.append(list(map(int, sys.stdin.readline().split())))

dp = [[0 for _ in range(n)] for _ in range(n)]
for j in range(1, n):
  for i in range(j-1, -1, -1):
    temp = float('inf')
    for k in range(i, j):
      temp = min(temp, dp[i][k]+dp[k+1][j]+l1[i][0]*l1[k][1]*l1[j][1])
      dp[i][j] = temp
print(dp[0][-1])

# 재귀적으로 구현한 dp를 for 문으로 다시 구현해야 효율성 통과
#
# 백준 11049 행렬 곱셈 순서 -> dp
# import sys
# sys.setrecursionlimit(10**8)
# n = int(input())
# l1 = []
# for _ in range(n):
#   l1.append(list(map(int, sys.stdin.readline().split())))
# dp = [[0 for _ in range(n)] for _ in range(n)]
# def do(l1, index):
#   if len(l1) == 1:
#     return 0, l1[0]
#   if dp[index][index+len(l1)-1] != 0:
#     return dp[index][index+len(l1)-1], [l1[0][0], l1[-1][1]]
#   if len(l1) == 2:
#     cost = l1[0][0]*l1[0][1]*l1[1][1]
#     matrix = [l1[0][0], l1[1][1]]
#     dp[index][index+1] = cost
#     return cost, matrix
#   cost = float('inf')
#   matrix = [l1[0][0], l1[-1][1]]
#   for i in range(1, len(l1)):
#     leftList = l1[:i]
#     rightList = l1[i:]
#     dpLeft = do(leftList, 0)
#     dpRight = do(rightList, i)
#     cost = min(cost, dpLeft[0]+dpRight[0]+dpLeft[1][0]*dpLeft[1][1]*dpRight[1][1])
#   dp[index][index+len(l1)-1] = cost
#   return cost, matrix
# 
# print(do(l1, 0)[0])