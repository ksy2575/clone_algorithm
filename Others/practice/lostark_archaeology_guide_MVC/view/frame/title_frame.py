from tkinter import font
from lostark_archaeology_guide_MVC.view.frame.abstract_frame import *


class TitleFrame(AbstractFrame):

    PROGRAM_TITLE = '무쇠망치 고고학 가이드'
    CURRENT_VERSION = 'ver0.2'

    def __init__(self, root):
        print("class TitleFrame initialized")
        super().__init__(root)

        self.grid(row=0, column=1)

        self.title_label = None
        self.version_label = None

        self.create_widgets()
        self.set_widgets()

    def create_widgets(self):
        self.blank_space = Label(self)
        self.title_label = Label(self, text=self.PROGRAM_TITLE,
                                 font=font.Font(size=12))
        self.version_label = Label(self, text=self.CURRENT_VERSION,
                                   font=font.Font(size=8))

    def set_widgets(self):
        self.title_label.grid(row=1, column=0, padx=3, pady=(25, 0))
        self.version_label.grid(row=2, column=0, pady=3)
