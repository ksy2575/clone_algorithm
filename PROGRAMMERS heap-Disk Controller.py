# 프로그래머스 디스크 컨트롤러 -> 힙
import heapq
def solution(jobs):
    dic = {}
    waitTime = []
    heap = []
    for job in jobs:
      if job[0] in dic.keys():
        dic[job[0]] = dic[job[0]] + [job[1]]
      else:
        dic[job[0]] = [job[1]]

    cnt = 0
    isEmpty = True
    while len(waitTime) < len(jobs):
      if not isEmpty and cnt-startTime == currJob:
        isEmpty = True
        waitTime.append(cnt-appendTime)
      if cnt in dic.keys():
        for job in dic[cnt]:
          heapq.heappush(heap, (job, cnt))
      if isEmpty and len(heap) != 0:
        isEmpty = False
        currJob, appendTime = heapq.heappop(heap)
        startTime = cnt
      cnt += 1
    return sum(waitTime)//len(waitTime)
# print(solution([[0, 3], [1, 9], [2, 6]]))
# print(solution([[0, 1],[0, 3], [1, 9], [2, 6]]))