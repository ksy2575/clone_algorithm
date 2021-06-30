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
