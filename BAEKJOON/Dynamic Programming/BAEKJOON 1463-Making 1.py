# 백준 1463 1로 만들기 -> dp
n = int(input())
dp = [-1] * 1000001
dp[1] = 0
dp[2] = 1
dp[3] = 1
for i in range(4, n + 1):
    value = 10000000
    if i % 3 == 0:
        value = min(value, dp[i // 3] + 1)

    if i % 2 == 0:
        value = min(value, dp[i // 2] + 1)

    dp[i] = min(dp[i - 1] + 1, value)
print(dp[n])