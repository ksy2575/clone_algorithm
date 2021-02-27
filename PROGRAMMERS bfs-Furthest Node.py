# 프로그래머스 가장 먼 노드 -> bfs      ※ visited 리스트를 set으로 바꾸기
from collections import deque
def bfs(dic):
    visited = set([1])
    dq = deque([(1, 0)])
    ansCnt = 0
    ans = 0
    while dq:
        curr, cnt = dq.popleft()
        for next in dic[curr]:
            if next not in visited:
                visited.add(next)
                dq.append((next, cnt + 1))
        if ansCnt < cnt:
            ansCnt = cnt
            ans = 1
        elif ansCnt == cnt:
            ans += 1
    return ans

def solution(n, edge):
    answer = 0
    dic = {}
    for v in edge:
        if v[0] not in dic.keys():
            dic[v[0]] = [v[1]]
        else:
            dic[v[0]] = dic[v[0]] + [v[1]]
        if v[1] not in dic.keys():
            dic[v[1]] = [v[0]]
        else:
            dic[v[1]] = dic[v[1]] + [v[0]]

    return bfs(dic)
solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]])