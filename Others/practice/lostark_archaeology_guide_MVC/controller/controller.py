import csv
import pandas
from tkinter import PhotoImage

import lostark_archaeology_guide_MVC.view.view as view
import lostark_archaeology_guide_MVC.model.model as model


class Controller:
    def __init__(self, view):
        self.view = view

    def run(self):
        self.view.start_mainloop()
