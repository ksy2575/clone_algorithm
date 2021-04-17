# 프로그래머스 후보키
from itertools import combinations
def isin(curr, ansList):
    flag = True
    for ans in ansList:
      if curr|set(ans) == curr:
        return False
    return True

def ishubo(curr, relation):
    tempSet = set()
    for row in relation:
      temp = ''
      for index in curr:
        temp += ' ' + row[index]
      if temp in tempSet:
        return False
      tempSet.add(temp)
    return True
def solution(relation):
    answer = 0
    ansList = []
    row, col = len(relation), len(relation[0])
    for i in range(1, col+1):
      for combi in combinations(range(col), i):
        curr = set(combi)
        if isin(curr, ansList):
          if ishubo(curr, relation):
            ansList.append(curr)
            answer += 1
    return answer

print(solution([["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]))