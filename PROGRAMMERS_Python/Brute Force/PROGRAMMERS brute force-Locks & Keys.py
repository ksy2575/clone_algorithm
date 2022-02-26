# 프로그래머스 자물쇠와 열쇠
from copy import deepcopy


def createKey(key):
    n = len(key)
    key2 = deepcopy(key)
    for i in range(n):
        for j in range(n):
            curr = key[i][j]
            key2[j][n - i - 1] = curr
    return key2


def do(key, lock):
    lockList = [[0 for _ in range(len(lock) * 3)] for _ in range(len(lock) * 3)]
    start, end = len(lock), len(lock) * 2
    for i in range(len(lock)):
        for j in range(len(lock)):
            lockList[i + len(lock)][j + len(lock)] = lock[i][j]
    for i in range(start - len(key), end):
        for j in range(start - len(key), end):
            if find(key, deepcopy(lockList), i, j, start, end, lock):
                return True
            else:
                continue
    return False


def find(key, lockList, i, j, start, end, lock):
    for ki in range(len(key)):
        for kj in range(len(key)):
            lockList[i + ki][j + kj] = lockList[i + ki][j + kj] ^ key[ki][kj]
    for ii in range(len(lock)):
        for jj in range(len(lock)):
            if lockList[ii + len(lock)][jj + len(lock)] == 0:
                return False

    return True


def solution(key, lock):
    keyList = [key]
    for _ in range(3):
        keyList.append(createKey(keyList[-1]))
    for k in keyList:
        if do(k, lock):
            return True
    return False
# print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]))
# print(solution([[1, 1], [0, 0]], [[1, 1, 1], [1, 1, 1], [1, 0, 1]]))