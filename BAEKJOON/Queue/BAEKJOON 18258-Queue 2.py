# 백준 18258 큐 2 -> 큐
from collections import deque
import sys
n = int(input())
dq = deque()

for _ in range(n):
  command = sys.stdin.readline().rstrip()
  if 'push' in command:
    curr = int(command.split()[1])
    dq.append(curr)
  elif command == 'pop':
    if len(dq) == 0:
      print(-1)
    else:
      print(dq.popleft())
  elif command == 'size':
    print(len(dq))
  elif command == 'empty':
    if len(dq) == 0:
      print(1)
    else:
      print(0)
  elif command == 'front':
    if len(dq) == 0:
      print(-1)
    else:
      print(dq[0])
  elif command == 'back':
    if len(dq) == 0:
      print(-1)
    else:
      print(dq[-1])