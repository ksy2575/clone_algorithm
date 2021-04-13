# 프로그래머스 가사 검색 -> 효율성 테스트 실패 - 트라이로 구현할 필요 있음
from collections import defaultdict


def isCorrect(word, candidate):
    if len(word) != len(candidate):
        return False
    n = len(word)
    if candidate[0] != '?':
        start, end, seq = 0, n, 1
    else:
        start, end, seq = n - 1, -1, -1

    for i in range(start, end, seq):
        if candidate[i] != '?':
            if word[i] != candidate[i]:
                return False

    return True


def solution(words, queries):
    answer = []
    frontDict = defaultdict(set)
    endDict = defaultdict(set)
    questionDict = defaultdict(int)
    ansDict = {}
    for query in queries:
        if query[0] != '?': frontDict[query[0]].add(query)
        if query[-1] != '?': endDict[query[-1]].add(query)
        ansDict[query] = 0
    for word in words:
        # print('')
        # print(word)
        if word[0] in frontDict:
            for candidate in frontDict[word[0]]:
                # print(word, candidate)
                if isCorrect(word, candidate):
                    ansDict[candidate] += 1
        if word[-1] in endDict:
            for candidate in endDict[word[-1]]:
                # print(word, candidate)
                if isCorrect(word, candidate):
                    ansDict[candidate] += 1

        questionDict[len(word)] += 1

    # print(questionDict)

    for query in queries:
        if query[0] != '?':
            answer.append(ansDict[query])
        elif query[-1] != '?':
            answer.append(ansDict[query])
        else:
            answer.append(questionDict[len(query)])

    return answer


print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"],
               ["fro??", "????o", "fr???", "fro???", "pro?", "??????"]))