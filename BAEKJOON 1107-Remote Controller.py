# 백준 1107 리모컨 -> 브루트포스    풀이 중,,
n = str(input())
m = int(input())
set1 = {}
curr = 100
temp = ['', '', '']
if m != 0:
  set1 = set(map(int, input().split()))
print(set1)
for l in list(n):
  if int(l) not in set1 and temp[1] != '-1':
    temp[1] += l
  else:
    for i in range(int(l)-1, 0, -1):
      if i not in set1:
        temp[0]+=str(i)
        break
    else:
      temp[0]+= '0'
    for i in range(int(l)+1, 10):
      if i not in set1:
        temp[2]+=str(i)
        break
    temp[1] = '-1'





  if int(l) in set1:
    for i in range(int(l)-1, 0, -1):
      if i not in set1:
        temp[0]+=str(i)
        break
    for i in range(int(l)+1, 10):
      if i not in set1:
        temp[2]+=str(i)
        break
    temp[1] = '-1'
  elif temp[1] != '-1':
    temp[1]+=str(l)
    temp[0]=temp[1]
    temp[2]=temp[1]
  print(temp)