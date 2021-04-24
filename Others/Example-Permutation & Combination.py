# 순열의 재귀적 구현
ans = []
l1 = [0,1,2,3,4,5]
def permutation(cnt, l2):
  if cnt == 3:
    ans.append(l2)
  else:
    for i in range(len(l1)):
      if l1[i] not in l2:
        combi(cnt+1, l2+[l1[i]])

print(permutation(0, []), ans)
print(len(ans))


# 조합의 재귀적 구현
ans = []
l1 = [0,1,2,3,4,5]
def combination(cnt, l2, idx):
  if cnt == 3:
    ans.append(l2)
  else:
    for i in range(idx, len(l1)):
      if l1[i] not in l2:
        combi(cnt+1, l2+[l1[i]], i+1)

print(combination(0, [], 0), ans)
print(len(ans))