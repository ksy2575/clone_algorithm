from lostark_practice import main
import time
from collections import deque
# 계속해서 정보를 받아오는 프로그램을 만드려 하였으나, 로스트아크 홈페이지의 거래소 시스템은 실제 매물 상태와 최대 10분의 차이가 난다.
# 10분에 한 번 정보를 받아오고, 이를 계속 저장하다가 필요할 때 출력하는 방식으로 해보기
dq = deque()
for i in range(10):
    main.main()
    time.sleep(15)