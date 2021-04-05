from collections import deque


def toSecond(s):
    timeList = list(map(int, s.split(':')))
    return timeList[0] * 3600 + timeList[1] * 60 + timeList[2]


def toString(time):
    h = str(time // 3600)
    m = str(time % 3600 // 60)
    s = str(time % 60)
    if len(h) == 1:
        h = '0' + h
    if len(m) == 1:
        m = '0' + m
    if len(s) == 1:
        s = '0' + s
    return h + ':' + m + ':' + s


def makeSet(logs, playTime, advTime):
    startSet = set([0, playTime - advTime])
    timeDic = {}
    timeSet = set()
    for log in logs:
        startString, endString = log.split('-')
        start = toSecond(startString)
        end = toSecond(endString)
        if start < playTime - advTime:
            startSet.add(start)
        if 0 < end - advTime < playTime - advTime:
            startSet.add(end - advTime)

        if start in timeDic:
            timeDic[start] += 1
        else:
            timeDic[start] = 1
        if end in timeDic:
            timeDic[end] -= 1
        else:
            timeDic[end] = -1

        timeSet.add(start)
        timeSet.add(end)

    startList = sorted(list(startSet))
    return startList, sorted(list(timeSet)), timeDic


def solution(play_time, adv_time, logs):
    answer = ''
    playTime = toSecond(play_time)
    advTime = toSecond(adv_time)
    startList, timeList, timeDic = makeSet(logs, playTime, advTime)
    timeList.append(playTime)
    temp = playTime
    dq = deque(startList[1:])
    dic = {0: 0}
    dq2 = deque([0])
    counter = 0
    pre = 0
    ans = -1
    value = 0
    for i in range(len(timeList)):
        currTime = timeList[i]

        # 끝난 원소를 계산 후 제거
        while dq2:
            if dq2[0] + advTime <= currTime:
                curr = dq2.popleft()
                dic[curr] += counter * (curr + advTime - pre)
                if ans == -1:
                    ans = curr
                    value = dic[curr]
                elif value < dic[curr]:
                    ans = curr
                    value = dic[curr]
            else:
                break

        # 큐의 모든 원소 진행상황 업데이트
        for q in dq2:
            dic[q] += counter * (currTime - pre)

        # 큐에 새로 진행할 startTime을 추가
        while dq:
            if dq[0] <= currTime:
                curr = dq.popleft()
                dic[curr] = counter * (currTime - curr)
                dq2.append(curr)
            else:
                break

        if currTime != playTime:
            counter += timeDic[currTime]
        else:
            counter = 0

        pre = currTime

    # print(toString(ans), toString(value))

    return toString(ans)


# print(solution("02:03:55", "00:14:15", ["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]))
# print(solution("99:59:59", "25:00:00", ["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"]))
print(solution("50:00:00", "50:00:00", ["15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"]))