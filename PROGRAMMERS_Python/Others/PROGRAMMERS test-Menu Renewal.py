# 프로그래머스 메뉴 리뉴얼
from itertools import combinations
def solution(orders, course):
    answer = []
    dic = {}
    tempList = [[0, []]] + [[0, []] for _ in range(course[-1])]
    for order in orders:
      l1 = list(order)
      for num in course:
        combi = combinations(l1, num)
        for com in combi:
          key = "".join(sorted(com))
          if key in dic:
            dic[key] += 1
          else:
            dic[key] = 1
          if dic[key] > tempList[len(key)][0]:
            tempList[len(key)][0] = dic[key]
            tempList[len(key)][1] = [key]
          elif dic[key] == tempList[len(key)][0]:
            tempList[len(key)][1].append(key)
    for cnt, temps in tempList:
      if cnt >= 2:
        for temp in temps:
          answer.append(temp)

    return sorted(answer)
print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2,3,4]))
# print(solution(["XYZ", "XWY", "WXA"], [2,3,4]))