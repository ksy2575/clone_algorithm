# 도발 봇 인터프리터
def tount(tountCnt):
  global cnt
  cnt += 1
  cntList[0] += 1
  # 예외처리 - 애매한 부분
  # if cntList[0] > tountCnt:
  #   return ""
  order = (cntList[0]-1)%4
  if order == 0:
    s = sentence()
  elif order == 1:
    tempStr1 = tount(tountCnt) + " "
    tempStr2 = sentence()
    s = tempStr1 + tempStr2[0].upper() + tempStr2[1:]
  elif order == 2:
    s = noun() + "!"
  elif order == 3:
    s = sentence()

  s = s[0].upper() + s[1:]
  if s[-1] != "!":
    s = s + "."
  return s

def sentence():
  cntList[1] += 1
  order = (cntList[1]-1)%3
  if order == 0:
    s = pastRel() + " " + nounPhrase()
  elif order == 1:
    s = presentRel() + " " + nounPhrase()
  elif order == 2:
    s = pastRel() + " " + article() + " " + noun()
  return s

def nounPhrase():
  cntList[2] += 1
  s = article() + " " + modifiedNoun()
  return s

def modifiedNoun():
  cntList[3] += 1
  order = (cntList[3]-1)%2
  if order == 0:
    s = noun()
  elif order == 1:
    s = modifier() + " " + noun()
  return s

def modifier():
  cntList[4] += 1
  order = (cntList[4]-1)%2
  if order == 0:
    s = adjective()
  elif order == 1:
    s = adverb() + " " + adjective()
  return s

def presentRel():
  cntList[5] += 1
  s = "your" + " " + presentPerson() + " " + presentVerb()
  return s

def pastRel():
  cntList[6] += 1
  s = "your" + " " + pastPerson() + " " + pastVerb()
  return s

def presentPerson():
  cntList[7] += 1
  order = (cntList[7]-1)%3
  if order == 0:
    s = "steed"
  elif order == 1:
    s = "king"
  elif order == 2:
    s = "first-born"
  return s

def pastPerson():
  cntList[8] += 1
  order = (cntList[8]-1)%5
  if order == 0:
    s = "mother"
  elif order == 1:
    s = "father"
  elif order == 2:
    s = "grandmother"
  elif order == 3:
    s = "grandfather"
  elif order == 4:
    s = "godfather"
  return s

def noun():
  cntList[9] += 1
  order = (cntList[9]-1)%11
  if order == 0:
    s = "hamster"
  elif order == 1:
    s = "coconut"
  elif order == 2:
    s = "duck"
  elif order == 3:
    s = "herring"
  elif order == 4:
    s = "newt"
  elif order == 5:
    s = "peril"
  elif order == 6:
    s = "chicken"
  elif order == 7:
    s = "vole"
  elif order == 8:
    s = "parrot"
  elif order == 9:
    s = "mouse"
  elif order == 10:
    s = "twit"
  return s

def presentVerb():
  cntList[10] += 1
  order = (cntList[10]-1)%2
  if order == 0:
    s = "is"
  elif order == 1:
    s = "masquerades as"
  return s

def pastVerb():
  cntList[11] += 1
  order = (cntList[11]-1)%2
  if order == 0:
    s = "was"
  elif order == 1:
    s = "personified"
  return s

def article():
  cntList[12] += 1
  s = "a"
  return s

def adjective():
  cntList[13] += 1
  order = (cntList[13]-1)%7
  if order == 0:
    s = "silly"
  elif order == 1:
    s = "wicked"
  elif order == 2:
    s = "sordid"
  elif order == 3:
    s = "naughty"
  elif order == 4:
    s = "repulsive"
  elif order == 5:
    s = "malodorous"
  elif order == 6:
    s = "ill-tempered"
  return s

def adverb():
  cntList[14] += 1
  order = (cntList[14]-1)%5
  if order == 0:
    s = "conspicuously"
  elif order == 1:
    s = "categorically"
  elif order == 2:
    s = "positively"
  elif order == 3:
    s = "cruelly"
  elif order == 4:
    s = "incontrovertibly"
  return s

# 본 코드
cntList = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
while True:
  try:
    string1 = input()
  except EOFError:
    break
  except KeyboardInterrupt:
    break
  tempStr = string1
  cnt = 0
  holyFlag = False
  # 도발 수
  l1 = string1.split()
  print("Knight: " + " ".join(l1))
  alphaCnt = 0
  for l in l1:
    for ll in l:
      if ll.isalpha():
        break
    else:
      alphaCnt += 1
  tountCnt = (len(l1)-alphaCnt+2)//3
  # print("tount 갯수 : ", tountCnt)

  # 홀리그레일
  for s in ['t', 'h', 'e', 'h', 'o', 'l', 'y', 'g', 'r', 'a', 'i', 'l']:
    if s in tempStr:
      tempStr = tempStr[tempStr.index(s)+1:]
    else:
      break
  else:
    cnt += 1
    print("Taunter: (A childish hand gesture).")

  # 인터프리터 실행
  while cnt < tountCnt:
    print("Taunter: " + tount(tountCnt))
  print("")