from lostark_practice_using_mvc.view.frame.abstract_frame import *


class ButtonFrame(AbstractFrame):

    def __init__(self, root):
        print("class ButtonFrame initialized")
        super().__init__(root)

        self.grid(row=0, column=2)

        self.button_curr_price = None
        self.button_latest_price = None

        self.create_widgets()
        self.set_widgets()

    def create_widgets(self):
        self.button_curr_price = Button(self, text='현재가 확인', fg='black',
                                        bg='lightgray', width=15, height=3)
        self.button_latest_price = Button(self, text='시세 그래프', fg='black',
                                          bg='lightgray', width=15, height=3)

    def set_widgets(self):
        self.button_curr_price.grid(row=0, column=2, padx=10, pady=(10, 0))
        self.button_latest_price.grid(row=0, column=3, pady=(10,0))
