import os
from tkinter import *
from tkinter import font
# from lostark_archaeology_guide.map_button import MapButton
from tkinter import ttk
# from tkinter.ttk import *
from PIL import Image, ImageTk


class MapButton(Button):
    def __init__(self, root, x, y):
        print("class ResultFrame initialized")
        super().__init__(root, bg="white", command=self.switch, relief="flat", overrelief="raised")

        self.place(x=x, y=y, width=20, height=20)

        # self.place()

    def switch(self):
        if self.configure("background")[-1] == "white":
            print("green")
            self.configure(background="lightgreen")
        elif self.configure("background")[-1] == "lightgreen":
            print("purple")
            self.configure(background="purple")
        elif self.configure("background")[-1] == "purple":
            print("white")
            self.configure(background="white")


try:
    os.chdir(sys._MEIPASS)
    print(sys._MEIPASS)
except:
    os.chdir(os.getcwd())

window = Tk()
window.title("무쇠망치 고고학 가이드")
window.geometry("770x710+100+100")
window.resizable(False, False)


# img = Image.open(r'.\0_source\done.png')
# resized_img = img.resize((16, 16))
# resized_img.save(r'.\0_source\button_done_16x16.png')


################################
#       윗부분 프레임            #
################################
upperFrame = Frame(window, bd=1)
upperFrame.grid(row=0, column=0)
logo = Canvas(upperFrame, width=240, height=66)

# logo.place(x=5, y=5, width=50, height=50)
# logo.pack(side="top", anchor="w")
# title = Label(window, text='제작 효율 계산기', height=3, font=font.Font(family="Lucida Grande", size=20))

logoImage = PhotoImage(file='0_source\lostark_logo_240x66.png')
logo.create_image(5, 5, anchor=NW, image=logoImage)
logo.grid(row=0, column=0)

titleFrame = Frame(upperFrame, bd=1)
titleFrame.grid(row=0, column=1, padx=3)

title0 = Label(titleFrame)
title0.grid(row=0, column=0, padx=3)
title = Label(titleFrame, text='무쇠망치 고고학 가이드', font=font.Font(size=12))
title.grid(row=1, column=0, padx=3, sticky="s")
title2 = Label(titleFrame, text='for 상호♡', font=font.Font(size=8))
title2.grid(row=2, column=0, pady=3)


buttonLoad = Button(upperFrame, text='불러오기', fg='black', bg='lightgray', width=15, height=3)
buttonReset = Button(upperFrame, text='전체 초기화', fg='black', bg='lightgray', width=15, height=3)


buttonLoad.grid(row=0, column=2, padx=10)
buttonReset.grid(row=0, column=3, sticky="e")


################################
#       밑부분 프레임            #
################################
lowerFrame = Frame(window, bd=1, bg="lightblue")
lowerFrame.grid(row=1, column=0, sticky="ewsn")

map_bg = Canvas(lowerFrame, width=762, height=599)
map_image = PhotoImage(file='0_source\yon_cut.png')
map_bg.create_image(5, 5, anchor=NW, image=map_image)
map_bg.grid(row=0, column=0)

################################
#         버튼 노가다            #
################################
button_pos_list = [(305, 27), (355, 40), (345, 100), (290, 80),
                   (250, 110), (210, 115), (210, 160), (260, 165),
                   (237, 178), (160, 145), (130, 185), (170, 210),
                   (125, 245), (55, 248), (90, 300), (80, 350),
                   (90, 380), (135, 344), (140, 375), (200, 380),
                   (165, 427), (160, 452), (275, 448), (240, 475),
                   (268, 498), (160, 452), (314, 458), (330, 490),
                   (314, 540), (320, 575),
                   (547, 43), (600, 41), (530, 85), (565, 92),
                   (590, 100), (620, 80), (665, 100), (700, 120),
                   (565, 160), (680, 160), (640, 190)


                   ]
for x, y in button_pos_list:
    MapButton(lowerFrame, x, y)


resultFrame = Frame(lowerFrame, relief="solid", bd=1, bg='pink', width=480)
resultFrame.grid(row=1, column=0, padx=3, pady=3, sticky="ewsn")
################################
#       메시지 프레임            #
################################
messageFrame = Frame(resultFrame, relief="solid")
messageFrame.grid()
buttonImage = PhotoImage(file=r'0_source\button_refresh_16x16.png')
buttonRefresh = Button(messageFrame, fg='black', bg='white', image=buttonImage)
messageLable = Label(messageFrame, text='무쇠망치 고고학 가이드ver0.1', font=font.Font(size=8))

buttonRefresh.pack(side='right', anchor="s")
messageLable.pack(side='right', anchor="s")

window.mainloop()
