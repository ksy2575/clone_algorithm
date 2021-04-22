# 프로그래머스 블록 게임
from collections import defaultdict


def findshape(board, i, j):
    num = board[i][j]
    # leftTop, rightBottom = (i, i), (-1, -1)
    block = defaultdict(list)
    black = defaultdict(list)
    for ii in range(3):
        for jj in range(-2, 3):
            if i + ii >= len(board) or j + jj >= len(board[0]) or j + jj < 0:
                continue
            if board[i + ii][j + jj] == num:
                block[i + ii].append(j + jj)
            else:
                if board[i + ii][j + jj] == 0:
                    black[i + ii].append(j + jj)
                else:
                    pass
    # print("")
    # print('num:', num)
    # print(block)
    # print(black)
    four = [[(0, 0), (2, 3)], [(0, 0), (3, 2)], [(0, -1), (3, 1)], [(0, -2), (2, 1)]]
    for curr in four:
        cnt = 0
        iStart, jStart = i + curr[0][0], j + curr[0][1]
        iEnd, jEnd = i + curr[1][0], j + curr[1][1]
        flag = True
        l1 = []
        for ii in range(iStart, iEnd):
            for jj in range(jStart, jEnd):
                if ii >= len(board) or jj >= len(board[0]) or jj < 0:
                    flag = False
                    break
                if board[ii][jj] == num:
                    cnt += 1
                    l1.append(jj)
                elif board[ii][jj] not in (num, 0):
                    flag = False
                    break
                elif jj in l1:
                    flag = False
                    break
                # print("ii", "jj")
                # print(ii, jj)

            if not flag:
                break
        if cnt == 4:
            # print('cnt is 4')
            for index in range(0, iStart):
                for jj in range(jStart, jEnd):
                    if board[index][jj] != 0:
                        for iii in range(iStart, iEnd):
                            if board[iii][jj] == 0:
                                flag = False
                                break
                    if not flag:
                        break
            if not flag:
                continue
            for ii in range(iStart, iEnd):
                for jj in range(jStart, jEnd):
                    board[ii][jj] = 0
            return 1
    return 0
    # for ii in block:
    #   print(ii, block[ii])


def solution(board):
    answer = 0
    blockPos = defaultdict(list)
    row = len(board)
    col = len(board[0])
    visited = set()
    for i in range(row):
        for j in range(col):
            if board[i][j] != 0 and board[i][j] not in visited:
                answer += findshape(board, i, j)
                visited.add((board[i][j]))
    return answer


# print(solution([[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,4,0,0,0],[0,0,0,0,0,4,4,0,0,0],[0,0,0,0,3,0,4,0,0,0],[0,0,0,2,3,0,0,0,5,5],[1,2,2,2,3,3,0,0,0,5],[1,1,1,0,0,0,0,0,0,5]]))
# print(solution([[0,0,0,0,0,0,0,0,0,0]
# ,[0,0,0,2,2,0,0,0,0,0]
# ,[0,0,0,2,1,0,0,0,0,0]
# ,[0,0,0,2,1,0,0,0,0,0]
# ,[0,0,0,0,1,1,0,0,0,0]
# ,[0,0,0,0,0,0,0,0,0,0]]))
print(solution([[2, 2, 3, 3], [1, 2, 3, 4], [1, 2, 3, 4], [1, 1, 4, 4]]))