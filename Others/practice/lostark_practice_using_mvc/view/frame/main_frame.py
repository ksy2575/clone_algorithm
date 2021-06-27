from tkinter import *
from lostark_practice_using_mvc.view.frame.lower_frame import LowerFrame
from lostark_practice_using_mvc.view.frame.upper_frame import UpperFrame


class MainFrame(Frame):

    def __init__(self, root):
        print("class MainFrame initialized")
        super().__init__(root)
        self.root = root
        self.root.title("로스트아크 제작 효율 계산기")
        self.root.geometry("640x400+100+100")
        self.root.resizable(False, False)

        ############################
        #       윗부분 프레임        #
        ############################
        self.upperFrame = UpperFrame(self)


        ############################
        #       밑부분 프레임        #
        ############################
        self.lowerFrame = LowerFrame(self)





        self.pack(expand=True, fill="both")