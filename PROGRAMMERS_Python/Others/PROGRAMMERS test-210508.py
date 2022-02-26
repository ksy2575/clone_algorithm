# 문제 1 통과

def solution(s):
    answer = ''
    temp = ''
    alphaList = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    for i in range(len(s)):
      curr = s[i]
      if curr.isalpha():
        temp += curr
        if temp in alphaList:
          answer += str(alphaList.index(temp))
          temp = ''
      else:
        answer += curr

    return answer
print(solution("one4seveneight"))


#################################

# 문제 2 통과

#   P000P
#   0XX0X
#   0PXPX
#   00X0X
#   P0XXP
di = [1, 0, -1, 0]
dj = [0, 1, 0, -1]
def find(i, j, place, visited, cnt):
    if cnt > 1:
        return 1
    for k in range(4):
        if 0 <= i+di[k] < 5 and 0 <= j+dj[k] < 5:
            if place[i+di[k]][j+dj[k]] == 'P' and (i+di[k], j+dj[k]) != visited:
                return 0
            elif place[i+di[k]][j+dj[k]] == 'O':
                if find(i+di[k], j+dj[k], place, visited, cnt + 1) == 0:
                    return 0
                else:
                    continue
def do(place):
    for i in range(5):
        for j in range(5):
            if place[i][j] == 'P':
                # print(i, j)
                if find(i, j, place, (i, j), 0) == 0:
                    return 0
    return 1
def solution(places):
    answer = []
    for place in places:
        answer.append(do(place))
    return answer

# print(solution([["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]))
# print(solution([["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"]]))

#################################

# 문제 3 효율성 불합격

stack = []
deleted = set()
curr, length = 0, 0
lastIndex = 0


def redo():
    global curr
    global length
    global stack
    global deleted
    global lastIndex
    i = stack.pop()
    deleted = deleted ^ {i}
    if i > lastIndex:
        lastIndex = i
    length += 1


def delete():
    global curr
    global length
    global stack
    global deleted
    global lastIndex
    stack.append(curr)
    deleted.add(curr)
    if curr == lastIndex:
        curr = up(curr, 1)
        lastIndex = curr
    else:
        curr = down(curr, 1)
    length -= 1


def up(curr, i):
    global deleted
    cnt = 0
    while cnt < i:
        cnt += 1
        if curr - cnt in deleted:
            i += 1
    curr -= cnt

    return curr


def down(curr, i):
    global deleted
    cnt = 0
    while cnt < i:
        cnt += 1
        if curr + cnt in deleted:
            i += 1
    curr += cnt

    return curr


def solution(n, k, cmd):
    answer = ''
    global curr
    curr = k
    global length
    length = n
    global stack
    global deleted
    global lastIndex
    lastIndex = n - 1

    for cm in cmd:
        if len(cm) != 1:
            c, num = cm.split()
            num = int(num)
            if c == 'U':
                curr = up(curr, num)
            else:
                curr = down(curr, num)
        else:
            if cm == 'C':
                delete()
            else:
                redo()
    for i in range(n):
        if i in deleted:
            answer += 'X'
        else:
            answer += 'O'
    return answer


#################################

# 문제 4, 5 불합격