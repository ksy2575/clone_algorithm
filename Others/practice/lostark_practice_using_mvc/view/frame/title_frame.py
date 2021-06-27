from tkinter import *
from tkinter import font


class TitleFrame(Frame):

    def __init__(self, root):
        print("class TitleFrame initialized")
        super().__init__(root)

        blank_space = Label(self)
        blank_space.grid(row=0, column=0, padx=3)

        title_label = Label(self, text='제작 효율 계산기', font=font.Font(size=12))
        title_label.grid(row=1, column=0, padx=3, sticky="s")

        version_label = Label(self, text='ver0.1', font=font.Font(size=8))
        version_label.grid(row=2, column=0, pady=3)