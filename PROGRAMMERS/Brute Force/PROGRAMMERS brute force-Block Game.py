# 프로그래머스 블록 게임
def findshape(board, i, j):
    num = board[i][j]
    square = [[(0, 0), (2, 3)], [(0, 0), (3, 2)], [(0, -1), (3, 1)], [(0, -2), (2, 1)], [(0, -1), (2, 2)]]

    for curr in square:
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
            if not flag:
                break

        if cnt == 4:
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


def solution(board):
    answer = 0
    row = len(board)
    col = len(board[0])
    while True:
        flag = False
        for i in range(row):
            for j in range(col):
                if board[i][j] != 0:
                    temp = findshape(board, i, j)
                    if temp != 0:
                        flag = True
                        answer += temp
        if not flag:
            break
    return answer
# print(solution([[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,4,0,0,0],[0,0,0,0,0,4,4,0,0,0],[0,0,0,0,3,0,4,0,0,0],[0,0,0,2,3,0,0,0,5,5],[1,2,2,2,3,3,0,0,0,5],[1,1,1,0,0,0,0,0,0,5]]))
# print(solution([[0, 1, 0, 3, 0], [0, 1, 3, 3, 3], [0, 1, 1, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]))