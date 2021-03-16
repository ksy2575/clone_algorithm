# 백준 1005 ACM Craft -> dp
def do(curr):
    if l2[curr] != -1:
        return l2[curr]
    if curr not in dic.keys():
        return l1[curr]
    else:
        temp = -1
        for i in dic[curr]:
            temp = max(temp, do(i))
        value = temp + l1[curr]
        l2[curr] = value
        return value


t = int(input())
for _ in range(t):
    n, k = map(int, input().split())
    l1 = [0] + list(map(int, input().split()))
    dic = {}
    l2 = [-1 for _ in range(n + 1)]
    for _ in range(k):
        a, b = map(int, input().split())
        if b in dic.keys():
            dic[b] += [a]
        else:
            dic[b] = [a]
    w = int(input())
    print(do(w))