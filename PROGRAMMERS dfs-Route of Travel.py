# 프로그래머스 여행경로 -> DFS
from copy import deepcopy
answer = ["zzz"]
def dfs(dic, stack, visited, cnt):
  global answer
  if stack == []:
    return None
  if cnt == 0:
    answer = min(answer, deepcopy(visited))
  elif len(dic) == 0:
    return None
  curr = stack.pop()
  if curr not in dic.keys():
    return None
  for next in dic[curr]:
    tempDic = deepcopy(dic)
    tempDic[curr].remove(next)
    stack.append(next)
    visited.append(next)
    dfs(tempDic, stack, visited, cnt-1)
    stack = []
    visited.pop()

def solution(tickets):
  stack = ["ICN"]
  visited = ["ICN"]
  dic = {}
  for t in tickets:
    if t[0] in dic.keys():
      dic[t[0]] = dic[t[0]] + [t[1]]
    else:
      dic[t[0]] = [t[1]]
  dfs(dic, stack, visited, len(tickets))
  return answer

# solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]])
# print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))