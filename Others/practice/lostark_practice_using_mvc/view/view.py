from lostark_practice_using_mvc.view.frame.main_frame import *


class View:

    def __init__(self):
        print("class View initialized")
        self.root = Tk()
        self.initialize_form()
        self.controller = None
        self.main_frame = None

    def initialize_form(self):
        print("start initialize Form")
        self.main_frame = MainFrame(self.root)
        print("end initialize Form")

    def set_controller(self, controller):
        self.controller = controller

    def start_mainloop(self):
        # 둘 다 가능
        # tk.mainloop()
        self.root.mainloop()  # <- 컨트롤러 run에서 작동시키기

    def set_list_box(self, product_list):
        # 컨트롤러가 뷰를 통해 뷰의 각 위젯을 동작시키도록 설계
        # 그러기 위해서는 컨트롤러 - 뷰 : 양방향 연관 관계
        # 뷰 - 위젯들간의 인스턴스 : 양방향 연관 관계
        pass