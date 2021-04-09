# 프로그래머스 괄호 변환
from collections import deque
def doFirst(s):
    if s == '':
      return ''
    else:
      return doSecond(s)
def doSecond(s):
    left = 0
    right = 0
    for i in range(len(s)):
      char = s[i]
      if char == "(":
        left += 1
      if char == ")":
        right += 1
      if left == right:
        u = s[:i+1]
        v = s[i+1:]
        return doThird(u, v)
def doThird(u, v):
    if isPossible(u):
      if isCorrect(u):
        return u + doFirst(v)
    return doFourth(u, v)
def isPossible(s):
    if s != "":
      left = 0
      right = 0
      for i in range(len(s)):
        char = s[i]
        if char == "(":
          left += 1
        else:
          right += 1
      if left == right:
        return True
    else:
      return False
def isCorrect(s):
    if s == '':
      return False
    stack = []
    for char in s:
      if stack == []:
        stack.append(char)
      elif stack[-1] == "(" and char == ")":
        stack.pop()
      else:
        stack.append(char)
    return True if len(stack) == 0 else False
def doFourth(u, v):
    retStr = "(" + doFirst(v) + ")"
    for i in range(1, len(u)-1):
      char = u[i]
      if char == "(":
        retStr += ")"
      else:
        retStr += "("
    return retStr
def solution(p):
    answer = ''
    if isCorrect(p):
      return p
    else:
      return doFirst(p)
print(solution("(()())()"))
# print(solution(")("))
# print(solution("()))((()"))