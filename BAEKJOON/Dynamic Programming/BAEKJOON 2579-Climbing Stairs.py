# 백준 2579 계단 오르기 -> dp
n = int(input())
dp = [[0, 0] for _ in range(n+1)]
for i in range(1, n+1):
  curr = int(input())
  if i == 1:
    dp[i] = [curr, curr]
  else:
    dp[i] = [curr+max(dp[i-2]), curr+dp[i-1][0]]
print(max(dp[n]))