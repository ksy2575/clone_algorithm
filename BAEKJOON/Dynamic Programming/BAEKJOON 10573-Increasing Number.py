# 백준 10573 증가하는 수 -> dp
def isIncrease(n):
    temp = 0
    for num in n:
        if int(num) >= temp:
            temp = int(num)
        else:
            return False
    return True


dpList = [[0 for _ in range(11)] for _ in range(82)]
t = int(input())
for i in range(1, 82):
    for j in range(0, 10):
        if i == 1:
            dpList[i][j] = 1
        else:
            for k in range(j, 10):
                dpList[i][j] += dpList[i - 1][k]

for _ in range(t):
    n = input()
    if not isIncrease(n):
        print(-1)
        continue
    ans = dpList[len(n) + 1][0]
    length = len(n)
    for i in range(length):
        curr = int(n[i])
        ans -= dpList[length - i + 1][curr + 1]

    print(ans - 1)