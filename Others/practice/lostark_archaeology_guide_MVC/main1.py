from lostark_archaeology_guide_MVC.model import *
from lostark_archaeology_guide_MVC.controller.controller import *
from lostark_archaeology_guide_MVC.view.view import *


def main():
    print("main start")
    v = View()
    c = Controller(v)
    c.run()


if __name__ == "__main__":
    main()