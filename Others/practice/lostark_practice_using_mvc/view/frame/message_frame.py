from lostark_practice_using_mvc.view.frame.abstract_frame import *
from tkinter import font


class MessageFrame(AbstractFrame):

    def __init__(self, root):
        print("class MessageFrame initialized")
        super().__init__(root)

        self.place(x=631, y=331, height=20, anchor="se")

        self.image = PhotoImage(file=r'0_source\button_refresh_16x16.png')
        self.button_refresh = None
        self.message_label = None

        self.create_widgets()
        self.set_widgets()

    def create_widgets(self):
        self.button_refresh = Button(self, image=self.image)
        self.message_label = Label(self, text='메시지 출력단입니다.', font=font.Font(size=8))

    def set_widgets(self):
        self.button_refresh.pack(side='right', anchor="s", fill="both")
        self.message_label.pack(side='right', anchor="s")
