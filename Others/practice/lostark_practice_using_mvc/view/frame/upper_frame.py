from pathlib import Path
from lostark_practice_using_mvc.view.frame.title_frame import *


class UpperFrame(Frame):

    def __init__(self, root):
        print("class UpperFrame initialized")
        super().__init__(root)

        self.grid()
        logo = Canvas(self, width=240, height=66)

        # base_path = Path(__file__).parent
        # file_path = (base_path / r'..\..\0_source\lostark_logo_240x66.png').resolve()
        # logo_image = PhotoImage(file=file_path, master=self)


        self.logo_image = PhotoImage(file='0_source\lostark_logo_240x66.png', master=self)

        logo.create_image(5, 5, anchor=NW, image=self.logo_image)
        logo.grid(row=0, column=0, sticky="ewsn")

        title_frame = TitleFrame(self)
        title_frame.grid(row=0, column=1)

        button_curr_price = Button(self, text='현재가 확인', fg='black', bg='lightgray', width=15, height=3)
        button_latest_price = Button(self, text='시세 그래프', fg='black', bg='lightgray', width=15, height=3)

        button_curr_price.grid(row=0, column=2, padx=10)
        button_latest_price.grid(row=0, column=3, sticky="e")
