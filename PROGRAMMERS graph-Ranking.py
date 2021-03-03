# 프로그래머스 순위 -> 그래프
def find(dic, l1, set1, isWin):
  for l in set(l1)-set1:
    set1.add(l)
    if isWin:
      set1 = find(dic, dic[l][0], set1, True)
    else:
      set1 = find(dic, dic[l][1], set1, False)
  return set1
def solution(n, results):
  answer = 0
  dic = {}
  for i in range(1, n+1):
    dic[i] = [[], []]

  for win, lose in results:
    dic[win][0].append(lose)
    dic[lose][1].append(win)

  for d in dic.keys():
    winCnt = len(find(dic, dic[d][0], {d}, True))-1
    loseCnt = len(find(dic, dic[d][1], {d}, False))-1
    if winCnt + loseCnt == n-1:
      answer += 1
  return answer


# solution(5, [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]])