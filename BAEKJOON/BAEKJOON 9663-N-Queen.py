# N이 4일 때
from copy import deepcopy


def paint(l1, i, j):
    for k in range(1, len(l1) + 1):
        l1[k - 1][j] = 1
        l1[i][k - 1] = 1
        if 0 <= i + k < len(l1) and 0 <= j + k < len(l1):
            l1[i + k][j + k] = 1
        if 0 <= i - k < len(l1) and 0 <= j - k < len(l1):
            l1[i - k][j - k] = 1
        if 0 <= i - k < len(l1) and 0 <= j + k < len(l1):
            l1[i - k][j + k] = 1
        if 0 <= i + k < len(l1) and 0 <= j - k < len(l1):
            l1[i + k][j - k] = 1
    return l1


def dfs(i, j, n, l1):
    l1 = paint(l1, i, j)
    if i == n - 1:
        return 1
    cnt = 0
    for k in range(n):
        if l1[i + 1][k] != 1:
            cnt += dfs(i + 1, k, n, deepcopy(l1))
    return cnt


n = int(input())

cnt = 0
for j in range(n):
    l1 = [[0 for _ in range(n)] for _ in range(n)]
    cnt += dfs(0, j, n, l1)
print(cnt)