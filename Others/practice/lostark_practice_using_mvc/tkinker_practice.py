from tkinter import *
from tkinter import font
from tkinter import ttk
# from tkinter.ttk import *
from PIL import Image, ImageTk
window = Tk()
window.title("로스트아크 제작 효율 계산기")
window.geometry("640x400+100+100")
window.resizable(False, False)


# img = Image.open('.\source\lostark-logo.png')
# resized_img = img.resize((240, 66))
# resized_img.save('.\source\lostark_logo_240x66.png')

################################
#       윗부분 프레임            #
################################
upperFrame = Frame(window, bd=1)
upperFrame.grid(row=0, column=0)
logo = Canvas(upperFrame, width=240, height=66)

# logo.place(x=5, y=5, width=50, height=50)
# logo.pack(side="top", anchor="w")
# title = Label(window, text='제작 효율 계산기', height=3, font=font.Font(family="Lucida Grande", size=20))

logoImage = PhotoImage(file='.\source\lostark_logo_240x66.png')
logo.create_image(5, 5, anchor=NW, image=logoImage)

title = Label(upperFrame, text='제작 효율 계산기', height=3, font=font.Font(size=12))
buttonCurrPrice = Button(upperFrame, text='현재가 확인', fg='black', bg='lightgray', width=15, height=3)
buttonLatestPrice = Button(upperFrame, text='시세 그래프', fg='black', bg='lightgray', width=15, height=3)


logo.grid(row=0, column=0)
title.grid(row=0, column=1, padx=3)
buttonCurrPrice.grid(row=0, column=2, padx=10)
buttonLatestPrice.grid(row=0, column=3, sticky="e")


################################
#       밑부분 프레임            #
################################
lowerFrame = Frame(window, bd=1, bg="lightblue")
lowerFrame.grid(row=1, column=0, sticky="ewsn")

listbox = Listbox(lowerFrame, selectmode='extended', width=20, height=18)
listbox.insert(0, "고급 회복약")
listbox.insert(1, "정령의 회복약")
listbox.insert(2, "중급 오레하 재료")
listbox.insert(3, "명예의 돌파석")
listbox.grid(row=0, column=0, padx=2, pady=19, sticky="wns")
# 나중에 scrollbar 연결하기 - frame으로

resultFrame = Frame(lowerFrame, relief="solid", bd=1, bg='pink', width=480)
resultFrame.grid(row=0, column=1, padx=3, pady=19, sticky="ewsn")

# graphCanvas = Canvas(resultFrame, width=240, height=66)
# logoImage = PhotoImage(file='.\source\lostark_logo_240x66.png')
# logo.create_image(5, 5, anchor=NW, image=logoImage)
# graphCanvas.grid(row=0, column=0, sticky="n")
# lowerFrame.grid_rowconfigure(0, weight=1)
# lowerFrame.grid_rowconfigure(1, weight=100)
messageFrame = Frame(resultFrame, relief="solid", bd=1, bg='yellow', width=480)
messageFrame.place(x=480, y=290, width=100, height=30, anchor="se")
# messageLable = Label(resultFrame, text='제작 효율 계산기', height=3, font=font.Font(size=12))
# buttonRefresh = Button(resultFrame, text='현재가 확인', fg='black', bg='lightgray', width=15, height=3)
buttonRefresh = Button(messageFrame, fg='black', bg='white')
messageLable = Label(messageFrame, text='제작 효율 계산기', height=3, font=font.Font(size=12))

# messageLable.place(x=5, y=5, width=50, height=50)
# buttonRefresh.place(x=5, y=5, width=50, height=50)
buttonRefresh.pack(side='right')


window.mainloop()