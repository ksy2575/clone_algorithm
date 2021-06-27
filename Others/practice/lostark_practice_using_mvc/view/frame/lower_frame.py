from pathlib import Path
from lostark_practice_using_mvc.view.frame.title_frame import *


class LowerFrame(Frame):

    def __init__(self, root):
        print("class LowerFrame initialized")
        super().__init__(root)

        self.grid(row=1, column=0)

        listbox = Listbox(self, selectmode='extended', width=20, height=18)
        listbox.insert(0, "고급 회복약")
        listbox.insert(1, "정령의 회복약")
        listbox.insert(2, "중급 오레하 재료")
        listbox.insert(3, "명예의 돌파석")
        listbox.grid(row=0, column=0, padx=2, pady=19, sticky="wns")
        # 나중에 scrollbar 연결하기 - frame으로

        result_frame = Frame(self, relief="solid", bd=1, bg='pink', width=480)
        result_frame.grid(row=0, column=1, padx=3, pady=19, sticky="ewsn")

        ############################
        #       메시지 프레임        #
        ############################
        message_frame = Frame(self, relief="solid")
        message_frame.place(x=631, y=331, height=20, anchor="se")

        button_image = PhotoImage(file=r'0_source\button_refresh_16x16.png')
        button_refresh = Button(message_frame, fg='black', bg='white', image=button_image)
        message_label = Label(message_frame, text='메시지 출력단입니다.', font=font.Font(size=8))

        button_refresh.pack(side='right', anchor="s")
        message_label.pack(side='right', anchor="s")