binList = ['0000', '0001', '0010', '0011', '0100', '0101', '0110', '0111', '1000', '1001', '1010', '1011', '1100', '1101', '1110', '1111']
aList = ['-', 'cpp', 'java', 'python']
bList = ['-', 'backend', 'frontend']
cList = ['-', 'junior', 'senior']
dList = ['-', 'chicken', 'pizza']
mList = [aList, bList, cList, dList]
def change(tempList):
    s = ''
    for i in range(4):
      s += str(mList[i].index(tempList[i]))
    return s, int(tempList[4])

def changeQuery(l1):
    retList = []
    for b in binList:
      s = ''
      for i in range(4):
        if b[i] == '0':
          s += '0'
        else:
          s += l1[i]
      retList.append(s)
    return retList

def solution(info, query):
    infoDic = {}
    answer = []
    for curr in info:
      tempList = list(curr.split())
      temp, score = change(tempList)
      l1 = changeQuery(temp)
      for l in l1:
        if l in infoDic:
          infoDic[l] += [score]
        else:
          infoDic[l] = [score]
    for q in query:
      tempList = q.split()
      queryList = [tempList[0], tempList[2], tempList[4], tempList[6], tempList[7]]
      temp, score = change(queryList)
      infoDic[temp].sort()
      left = 0
      right = len(infoDic[temp])
      t = -1
      while left <= right:
        mid = (left+right)//2
        if infoDic[temp][mid] >= score:
          right = mid - 1
        else:
          t = mid
          left = mid + 1
      answer.append(len(infoDic[temp]) - (t+1))
    return answer
print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"], ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]))