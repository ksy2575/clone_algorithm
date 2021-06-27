from lostark_practice_using_mvc.view.frame.main_frame import *

class View():
    def __init__(self):
        print("class View initialized")
        self.root = Tk()
        self.initializeForm()
        self.controller = None

    def initializeForm(self):
        print("initialize Form")

        tk = MainFrame(self.root)

    def setController(self, controller):
        self.controller = controller

    def startMainloop(self):
        # 둘 다 가능
        # tk.mainloop()
        self.root.mainloop()  # <- 컨트롤러 run에서 작동시키기