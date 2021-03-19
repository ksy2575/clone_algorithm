# 프로그래머스 카드 짝 맞추기
from copy import deepcopy

di = [1, -1, 0, 0]
dj = [0, 0, 1, -1]
dirList = ['d', 'u', 'r', 'l']


def dfs(board, curr, visited, selected, direction, cnt):
    i, j = curr
    print(board, curr, selected, visited)
    # 엔터가 있고 값이 맞을 때
    if selected != (-1, -1) and curr != selected and board[i][j] == board[selected[0]][selected[1]]:
        tempList = deepcopy(board)
        tempList[i][j] = 0
        tempList[selected[0]][selected[1]] = 0
        dfs(tempList, (i, j), [(i, j)], (-1, -1), 's', cnt + 1)
    else:
        # 엔터가 없을 때
        if selected == (-1, -1):
            if board[i][j] != 0:
                selected = (i, j)
                dfs(board, (i, j), visited, selected, 's', cnt + 1)

        # 네 방향 검사
        for k in range(4):
            if 0 <= i + di[k] < 4 and 0 <= j + dj[k] < 4:
                if (i + di[k], j + dj[k]) not in visited:
                    visited.append((i + di[k], j + dj[k]))
                    if dirList[k] == direction:
                        dfs(board, (i + di[k], j + dj[k]), visited, selected, direction, cnt)
                    else:
                        dfs(board, (i + di[k], j + dj[k]), visited, selected, dirList[k], cnt + 1)


def solution(board, r, c):
    answer = 0
    visited = [(r, c)]
    selected = (-1, -1)
    dfs(board, (r, c), visited, selected, 's', 0)


solution([[1, 0, 0, 3], [2, 0, 0, 0], [0, 0, 0, 2], [3, 0, 1, 0]], 1, 0)