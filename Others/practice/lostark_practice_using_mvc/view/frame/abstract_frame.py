from tkinter import *
import abc


class AbstractFrame(Frame, metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def create_widgets(self):
        raise NotImplementedError

    @abc.abstractmethod
    def set_widgets(self):
        raise NotImplementedError
