from tkinter import *
from tkinter import font
from lostark_archaeology_guide_MVC.view.frame.main_frame import *
from lostark_archaeology_guide_MVC.view.frame.lower_frame import *
from lostark_archaeology_guide_MVC.view.frame.map_button import *


class View:
    button_list = []
    button_pos_list = [(305, 27), (355, 40), (345, 100), (290, 80),
                       (250, 110), (210, 115), (210, 160), (260, 165),
                       (237, 178), (160, 145), (130, 185), (170, 210),
                       (125, 245), (55, 248), (90, 300), (80, 350),
                       (90, 380), (135, 344), (140, 375), (200, 380),
                       (165, 427), (160, 452), (275, 448), (240, 475),
                       (268, 498), (314, 458), (330, 490),
                       (314, 540), (320, 575),
                       (547, 43), (600, 41), (530, 85), (565, 92),
                       (590, 100), (620, 80), (665, 100), (700, 120),
                       (565, 160), (680, 160), (640, 190)
                       ]

    def __init__(self):
        print("class View initialized")
        self.root = Tk()
        self.controller = None
        self.root.title("무쇠망치 고고학 가이드")
        self.root.geometry("770x710+100+100")
        self.root.resizable(False, False)

        self.upperFrame = None
        self.logo = None
        self.logoImage = None
        self.titleFrame = None
        self.title0 = None
        self.title = None
        self.title2 = None

        self.buttonLoad = None
        self.buttonReset = None

        self.lowerFrame = None
        self.map_bg = None
        self.map_image = None
        
        self.set_frame()
        self.set_buttons()

    def set_frame(self):
        self.upperFrame = Frame(self.root, bd=1)
        self.upperFrame.grid(row=0, column=0)

        self.logo = Canvas(self.upperFrame, width=240, height=66)

        self.logoImage = PhotoImage(file='0_source\lostark_logo_240x66.png')
        self.logo.create_image(5, 5, anchor=NW, image=self.logoImage)
        self.logo.grid(row=0, column=0)

        self.titleFrame = Frame(self.upperFrame, bd=1)
        self.titleFrame.grid(row=0, column=1, padx=3)

        self.title0 = Label(self.titleFrame)
        self.title0.grid(row=0, column=0, padx=3)
        self.title = Label(self.titleFrame, text='무쇠망치 고고학 가이드', font=font.Font(size=12))
        self.title.grid(row=1, column=0, padx=3, sticky="s")
        self.title2 = Label(self.titleFrame, text='for 상호♡', font=font.Font(size=8))
        self.title2.grid(row=2, column=0, pady=3)

        self.buttonLoad = Button(self.upperFrame, text='불러오기', fg='black', bg='lightgray', width=15, height=3)
        self.buttonReset = Button(self.upperFrame, text='전체 초기화', fg='black', bg='lightgray', width=15, height=3, command=self.reset)

        self.buttonLoad.grid(row=0, column=2, padx=10)
        self.buttonReset.grid(row=0, column=3, sticky="e")

        self.lowerFrame = Frame(self.root, bd=1, bg="lightblue")
        self.lowerFrame.grid(row=1, column=0, sticky="ewsn")

        self.map_bg = Canvas(self.lowerFrame, width=762, height=599)
        self.map_image = PhotoImage(file='0_source\yon_cut.png')
        self.map_bg.create_image(5, 5, anchor=NW, image=self.map_image)
        self.map_bg.grid(row=0, column=0)

    def start_mainloop(self):
        self.root.mainloop()

    def reset(self):
        print("reset")
        for curr_btn in self.button_list:
            curr_btn.configure(background="white", foreground="black")

    def set_buttons(self):
        for i in range(len(self.button_pos_list)):
            x, y = self.button_pos_list[i]
            self.button_list.append(MapButton(self.lowerFrame, x, y, i + 1))


