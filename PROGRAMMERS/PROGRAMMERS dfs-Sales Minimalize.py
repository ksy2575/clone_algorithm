# 프로그래머스 매출 하락 최소화
from collections import defaultdict
from copy import deepcopy
import sys
saleList = []
minValue = 2147483648
def do(l1, i, set1, sale):
    temp = 2147483648
    global minValue
    if sale >= minValue:
      return -1
    if i >= len(l1):
      minValue = min(minValue, sale)
      return sale
    for v in l1[i]:
      if v in set1:
        temp =  min(temp, do(l1, i+1, set1, sale))
      else:
        tempSet = deepcopy(set1)
        tempSet.add(v)
        nextValue = do(l1, i+1, tempSet, sale + saleList[v-1])
        if nextValue != -1:
          temp =  min(temp, nextValue)
    return temp

def solution(sales, links):
    sys.setrecursionlimit(10**7)
    dic = defaultdict(set)
    global saleList
    saleList = deepcopy(sales)
    for link in links:
      dic[link[0]].add(link[0])
      dic[link[0]].add(link[1])

    return do(list(dic.values()), 0, set(), 0)
print(solution([14, 17, 15, 18, 19, 14, 13, 16, 28, 17], [[10, 8], [1, 9], [9, 7], [5, 4], [1, 5], [5, 10], [10, 6], [1, 3], [10, 2]]))