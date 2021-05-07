# 백준 11066 파일 합치기 -> dp   --- 답은 맞았으나 시간초과 -> for 문으로 작성 후 통과
import sys
t = int(input())
for _ in range(t):
  n = int(input())
  l1 = list(map(int, sys.stdin.readline().split()))
  dp = [[0 for _ in range(n)] for _ in range(n)]
  for j in range(n):
    for i in range(j, -1, -1):
      if i == j:
        dp[i][j] = 0
      elif j == i+1:
        dp[i][j] = l1[i]+l1[j]
      else:
        temp = float('inf')
        cost = sum(l1[i:j+1])
        for k in range(i, j):
          temp = min(temp, cost + dp[i][j-k-1+i] + dp[j-k+i][j])
        dp[i][j] = temp
  print(dp[0][-1])

####################################

# 백준 11066 파일 합치기 -> dp   --- 답은 맞았으나 시간초과
# import sys
#
# sys.setrecursionlimit(10 ** 8)
#
#
# def dp(l1, index):
#     if l1 == []:
#         return [0, 0]
#     elif dpList[index][index + len(l1) - 1][1] != 0:
#         return dpList[index][index + len(l1) - 1]
#
#     elif len(l1) == 1:
#         dpList[index][index][0] = l1[0]
#         dpList[index][index][1] = l1[0]
#         return [l1[0], l1[0]]
#     elif len(l1) == 2:
#         dpList[index][index + 1][0] = sum(l1)
#         dpList[index][index + 1][1] = sum(l1)
#         return dpList[index][index + 1]
#
#     retVal = [float('inf'), float('inf')]
#     for i in range(1, len(l1)):
#         dpLeft = dp(l1[:i], index)
#         dpRight = dp(l1[i:], i + index)
#         temp = 0
#
#         if len(l1[:i]) <= 1:
#             temp += dpLeft[0]
#         else:
#             temp += sum(dpLeft)
#         if len(l1[i:]) <= 1:
#             temp += dpRight[0]
#         else:
#             temp += sum(dpRight)
#
#         retVal[1] = min(retVal[1], temp)
#         if retVal[0] == float('inf'):
#             retVal[0] = dpLeft[0] + dpRight[0]
#     dpList[index][index + len(l1) - 1][0] = retVal[0]
#     dpList[index][index + len(l1) - 1][1] = retVal[1]
#     return dpList[index][index + len(l1) - 1]
#
#
# t = int(input())
# for _ in range(t):
#     n = int(input())
#     # l1 = list(map(int, input().split()))
#     l1 = list(map(int, sys.stdin.readline().split()))
#     dpList = [[[0, 0] for _ in range(n)] for _ in range(n)]
#     print(dp(l1, 0)[1])