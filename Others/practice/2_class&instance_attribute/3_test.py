# 다음 소스 코드에서 Date 클래스를 완성하세요.
# is_date_valid는 문자열이 올바른 날짜인지 검사하는 메서드입니다.
# 날짜에서 월은 12월까지 일은 31일까지 있어야 합니다.

# class Date:
#
#     ...
#
#
# if Date.is_date_valid('2000-10-31'):
#     print('올바른 날짜 형식입니다.')
# else:
#     print('잘못된 날짜 형식입니다.')

# 정답

class Date:
    @staticmethod
    def is_date_valid(s):
        stringList = list(map(int, s.split('-')))
        if 1 <= stringList[1] <= 12 and 1 <= stringList[2] <= 31:
            return True
        else:
            return False

if Date.is_date_valid('2000-10-31'):
    print('올바른 날짜 형식입니다.')
else:
    print('잘못된 날짜 형식입니다.')