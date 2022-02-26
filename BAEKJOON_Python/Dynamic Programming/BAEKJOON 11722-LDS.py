# 백준 11722 가장 긴 감소하는 부분 수열 -> dp
n = int(input())
dp = [0 for _ in range(1001)]
l1 = list(map(int, input().split()))
minVal = 0
ans = 1
visited = []
for i in range(n-1, -1, -1):
  curr = l1[i]
  if i == n-1:
    dp[curr] = 1
    maxVal = curr
    minVal = curr
    visited.append(curr)
    visited.sort()
  else:
    if curr < minVal:
      dp[curr] = 1
      minVal = curr
    else:
      temp = 0
      for i in range(len(visited)):
        if visited[i] >= curr:
          break
        temp = max(temp, dp[visited[i]])
      dp[curr] = temp + 1
      ans = max(ans, dp[curr])
    visited.append(curr)
    visited.sort()

print(ans)