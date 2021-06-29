from lostark_practice_using_mvc.view.frame.abstract_frame import *
from tkinter import font


class ResultFrame(AbstractFrame):

    def __init__(self, root, bg, width):
        print("class ResultFrame initialized")
        super().__init__(root, bg=bg, width=width)

        self.grid(row=0, column=1, padx=3, pady=19, sticky="ewsn")

        self.image = None
        self.canvas = None
        self.label = None

        self.create_widgets()
        self.set_widgets()

    def create_widgets(self):
        # self.canvas = Canvas()
        # self.label = Label(self, text='결과 출력단입니다.', font=font.Font(size=12))
        pass

    def set_widgets(self):
        # self.canvas.pack(side='right', anchor="s", fill="both")
        # self.label.grid(row=0, column=0, padx=2, pady=19, sticky="wns")
        pass
