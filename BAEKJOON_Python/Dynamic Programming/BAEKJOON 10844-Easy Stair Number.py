# 백준 10844 쉬운 계단 수 -> dp
n = int(input())
dp = [[0 for _ in range(12)] for _ in range(n)]
for i in range(2,11):
  dp[0][i] = 1
for i in range(1, n):
  for j in range(1, 11):
    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000
print(sum(dp[-1])%1000000000)