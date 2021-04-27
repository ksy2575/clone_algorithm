# 프로그래머스 신규 아이디 추천 -> 문자열
def first(s):
    return s.lower()
def second(s):
    temp = ''
    for char in s:
      if char.islower() or char.isdigit() or char in ['-', '_', '.']:
        temp += char
    return temp
def third(s):
    while '..' in s:
      s = s.replace('..', '.')
    return s
def fourth(s):
    if s[0] == '.':
      s = s[1:]
    if len(s) != 0 and s[-1] == '.':
      s = s[:-1]
    return s
def fifth(s):
    return 'a' if s == '' else s
def sixth(s):
    if len(s) >= 16:
      s = s[:15]
      if s[-1] == '.':
        s = s[:-1]
    return s
def seventh(s):
    return (s + s[-1]*3)[:3] if len(s) <= 2 else s
def change(s):
    s = first(s)
    s = second(s)
    s = third(s)
    s = fourth(s)
    s = fifth(s)
    s = sixth(s)
    s = seventh(s)
    return s
def solution(new_id):
    answer = change(new_id)
    return answer
# solution("...!@BaT#*..y.abcdefghijklm")
# solution("z-+.^.")
# solution("=.=")
# solution("123_.def")
# solution("abcdefghijklmn.p")