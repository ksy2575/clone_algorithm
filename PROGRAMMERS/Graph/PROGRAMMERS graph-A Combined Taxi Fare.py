# 프로그래머스 합승 택시 요금
def solution(n, s, a, b, fares):
    distList = [[float('inf') for _ in range(n + 1)] for _ in range(n + 1)]

    for fare in fares:
        start, end, cost = fare
        distList[start][end] = cost
        distList[end][start] = cost

    for i in range(n + 1):
        distList[i][i] = 0

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                distList[i][j] = min(distList[i][j], distList[i][k] + distList[k][j])

    return min([distList[s][k] + distList[k][a] + distList[k][b] for k in range(1, n + 1)])


print(solution(6, 4, 6, 2, [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]))