from lostark_practice_using_mvc.view.view import *

class Controller():
    def __init__(self, view):
        print("class Controller initialized")
        self.view = view
        self.view.set_controller(self)

    # tk 메인 루프 시작(GUI출력), 크롤러 시작
    def run(self):
        View.start_mainloop(self.view)
