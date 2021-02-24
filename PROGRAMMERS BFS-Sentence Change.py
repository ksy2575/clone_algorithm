# 프로그래머스 단어 변환 -> BFS
from collections import deque
def compare(word, curr):
    cnt = 0
    for i in range(len(curr)):
      if curr[i] != word[i]:
        cnt += 1
      if cnt > 1:
        return False
    return True
def bfs(begin, target, words):
    dq = deque([(begin, 0)])
    visited = [begin]
    while dq:
      curr, cnt = dq.popleft()
      if curr == target:
        return cnt
      for word in words:
        if compare(word, curr) and word not in visited:
          visited.append(word)
          dq.append((word, cnt+1))
    return 0

def solution(begin, target, words):
    return bfs(begin, target, words)

# solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"])
# solution("hit", "cog", ["hot", "dot", "dog", "lot", "log"])