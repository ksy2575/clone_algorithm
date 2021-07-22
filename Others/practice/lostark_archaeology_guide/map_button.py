from tkinter import *


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