# 프로그래머스 블록 게임
from collections import defaultdict


def findshape(board, i, j):
    num = board[i][j]
    cnt = 0
    # leftTop, rightBottom = (i, i), (-1, -1)
    block = defaultdict(list)
    black = defaultdict(list)
    for ii in range(3):
        for jj in range(-2, 3):
            if i + ii >= len(board) or j + jj >= len(board[0]) or j + jj < 0:
                continue
            if board[i + ii][j + jj] == num:
                cnt += 1
                block[i + ii].append(j + jj)
            else:
                if board[i + ii][j + jj] == 0:
                    board[i + ii][j + jj] = -1
                    black[i + ii].append(j + jj)
                else:
                    pass
    print("")
    print('num:', num)
    print(block)
    print(black)
    four = [[(0, 0), (2, 3)], [(0, 0), (3, 2)], [(0, -2), (-3, 0)], [(0, -3), (-2, 0)]]
    for k in range(len(four))
        for ii in block:
            print(ii, block[ii])


def solution(board):
    answer = 0
    blockPos = defaultdict(list)
    row = len(board)
    col = len(board[0])
    visited = set()
    for i in range(row):
        for j in range(col):
            if board[i][j] != 0 and board[i][j] not in visited:
                findshape(board, i, j)
                visited.add((board[i][j]))
    return answer


print(solution([[0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 4, 0, 0, 0], [0, 0, 0, 0, 0, 4, 4, 0, 0, 0],
                [0, 0, 0, 0, 3, 0, 4, 0, 0, 0], [0, 0, 0, 2, 3, 0, 0, 0, 5, 5], [1, 2, 2, 2, 3, 3, 0, 0, 0, 5],
                [1, 1, 1, 0, 0, 0, 0, 0, 0, 5]]))