def ismatch(a, b):
    if a == '(' and b == ')':
        return True
    elif a == '{' and b == '}':
        return True
    elif a == '[' and b == ']':
        return True
    elif a == '<' and b == '>':
        return True
    return False
def solution(inputString):
    answer = 0
    stack = []
    cnt = 0
    for i in range(len(inputString)):
        curr = inputString[i]
        if curr not in ['(', ')', '{', '}', '[', ']', '<', '>']:
            continue
        elif curr in ['(', '{', '[', '<']:
            stack.append(curr)
        else:
            if stack == []:
                answer = -i
                return answer
            else:
                if ismatch(stack[-1], curr):
                    stack.pop()
                    cnt += 1
                else:
                    answer = -i
                    return answer
    else:
        if stack != []:
            return -len(inputString)+1
        else:
            return cnt