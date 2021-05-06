# 백준 9252 LCS 2 -> dp
s1 = input()
s2 = input()

# s1 = 'ACAYKP'
# s2 = 'CAPCAK'
# s1 = 'ABCDEFG'
# s2 = 'CAEVCABDG'
dp = [['' for _ in range(len(s1))] for _ in range(len(s2))]
ansN, ansStr = 0, ''
for i in range(len(s2)):
  for j in range(len(s1)):
    currS1 = s1[j]
    currS2 = s2[i]
    if currS1 == currS2:
      dp[i][j] = currS1
      for jj in range(j-1, -1, -1):
        for ii in range(i-1, -1, -1):
          if dp[ii][jj] != '' and len(dp[ii][jj]) > len(dp[i][j])-1:
            dp[i][j] = dp[ii][jj]+currS1
            if len(dp[i][j]) >= ansN:
              ansN = len(dp[i][j])
              ansStr = dp[i][j]
            break
print(ansN)
print(ansStr)