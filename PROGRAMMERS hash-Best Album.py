# 프로그래머스 베스트앨범
def solution(genres, plays):
    answer = []
    n = len(genres)
    dic = {}
    for i in range(n):
        if not genres[i] in dic.keys():
            dic[genres[i]] = [plays[i], [(i, plays[i])]]
        else:
            temp, play = dic[genres[i]]
            dic[genres[i]] = [temp+plays[i], play + [(i, plays[i])]]
    l1 = list(dic.values())
    l1.sort(reverse = True)
    for l in l1:
        l[1].sort(key = lambda x:x[1], reverse = True)
        if 0 < len(l[1]) < 2:
            answer.append(l[1][0][0])
        else:
            answer.append(l[1][0][0])
            answer.append(l[1][1][0])
    return answer