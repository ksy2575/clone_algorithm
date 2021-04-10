# 프로그래머스 자물쇠와 열쇠
from copy import deepcopy
def createKey(key):
    n = len(key)
    key2 = deepcopy(key)
    for i in range(n):
      for j in range(n):
        curr = key[i][j]
        key2[j][n-i-1] = curr
    print(key2)
    return key2

def do(key, lock):
    pass
def solution(key, lock):
    answer = True
    keyList = [key]
    for _ in range(3):
      keyList.append(createKey(keyList[-1]))
    print(keyList)
    for k in keyList:
      do(k, lock)
    return answer
print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]))