# 프로그래머스 섬 연결하기 -> 프림 알고리즘으로 해결 (프림 vs 크루스칼)
def add(dic, start, end, cost):
    if start not in dic.keys():
        dic[start] = [(end, cost)]
    else:
        dic[start] = dic[start] + [(end, cost)]


def find(dic, visited, ans, n):
    least = (-1, -1)
    if len(visited) == n:
        return ans
    for v in visited:
        for next in dic[v]:
            if (least == (-1, -1) or next[1] < least[1]) and (next[0] not in visited):
                least = next
                i = v
    visited.append(least[0])
    ans += least[1]
    return find(dic, visited, ans, n)


def solution(n, costs):
    ans = 0
    dic = {}
    visited = []
    for c in costs:
        start, end, cost = c
        add(dic, start, end, cost)
        add(dic, end, start, cost)
    visited.append(list(dic.keys())[0])
    return find(dic, visited, ans, n)
# solution(4, [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]])
# solution(6, [[0,1,1],[0,2,2],[1,2,3],[2,3,2],[2,5,1],[3,4,1],[3,5,3],[4,5,3]])