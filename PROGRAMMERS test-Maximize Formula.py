# 프로그래머스 이중우선순위큐 -> 힙
import heapq
def solution(operations):
    minHeap = []
    maxHeap = []
    cnt = 0
    for op in operations:
        order, n = op.split()
        if order == 'I':
            heapq.heappush(minHeap, int(n))
            heapq.heappush(maxHeap, -int(n))
            cnt += 1
        if order == 'D' and cnt != 0:
            if n == '-1':
                curr = heapq.heappop(minHeap)
                maxHeap.pop(maxHeap.index(-curr))
                heapq.heapify(maxHeap)
                cnt -= 1
            elif n == '1':
                curr = heapq.heappop(maxHeap)
                minHeap.pop(minHeap.index(-curr))
                heapq.heapify(minHeap)
                cnt -= 1
                heapq.

    return [0, 0] if cnt == 0 else [-heapq.heappop(maxHeap), heapq.heappop(minHeap)]
# print(solution(["I 16","D 1"]))
# print(solution(["I 7","I 5","I -5","D -1"]))