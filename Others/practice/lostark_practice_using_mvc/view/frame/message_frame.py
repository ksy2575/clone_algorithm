from lostark_practice_using_mvc.view.frame.abstract_frame import *
from tkinter import font

STATE_LOADING = 0
STATE_REFRESH = 1
STATE_COMPLETE = 2


class MessageFrame(AbstractFrame):

    def __init__(self, root):
        print("class MessageFrame initialized")
        super().__init__(root)

        self.grid(row=1, column=1, padx=3, sticky="ewsn")

        self.image = PhotoImage(file=r'0_source\button_refresh_16x16.png')
        self.button_refresh = None
        self.message_label = None

        self.create_widgets()
        self.set_widgets()

    def create_widgets(self):
        self.button_refresh = Button(self, image=self.image, command=self.onclick)
        self.message_label = Label(self, text='메시지 출력단입니다.',
                                   font=font.Font(size=8), width=65, anchor="e")

    def set_widgets(self):
        self.message_label.grid(row=0, column=0, padx=0, pady=0)
        self.button_refresh.grid(row=0, column=1, padx=0, pady=0)

    def onclick(self):
        print("onclick")  # 굳, 컨트롤러가 제어
        self.change_button_icon(2)

    def change_button_icon(self, state):
        if state == STATE_LOADING:
            print("STATE_LOADING")
            self.image = PhotoImage(file=r'0_source\button_loading_16x16.png')
            self.button_refresh["image"] = self.image
        elif state == STATE_REFRESH:
            print("STATE_REFRESH")
            self.image = PhotoImage(file=r'0_source\button_refresh_16x16.png')
            self.button_refresh["image"] = self.image
        elif state == STATE_COMPLETE:
            print("STATE_COMPLETE")
            self.image = PhotoImage(file=r'0_source\button_done_16x16.png')
            self.button_refresh["image"] = self.image
        else:
            print("throw value error")
