import csv

from lostark_practice_using_mvc.view.view import *

class Controller():
    def __init__(self, view):
        print("class Controller initialized")
        
        # 유저의 선호 품목을 csv로 저장 및 불러오기,
        # 로스트아크의 전체 제작식을 DB로 사전에 저장 및 불러오기 <-무슨 DB?
        self.user_products = self.get_user_product_from_csv('./user_products.csv')
        self.view = view
        self.view.set_controller(self)

    # tk 메인 루프 시작(GUI출력), 크롤러 시작
    def run(self):
        View.start_mainloop(self.view)

    def get_user_product_from_csv(self, directory):
        print("get_product_list_from_csv")
        file_reader = open(directory, 'r')
        csv_reader = csv.reader(file_reader)
        for line in csv_reader:
            # print(line)
            self.create_product_dict(line)
        file_reader.close()
        return []

    def create_product_dict(self, line):
        # for index in range(len(line)):
        #     curr = line[index]
        #     if index == 0:
        #         if curr not in self.product_dict:
        #             self.product_dict[curr] = Product(curr)
        #         self.Recipe_dict[curr]
        #     elif not curr.isdigit():
        #         curr_name = curr
        #         if curr not in self.product_dict:
        #             self.product_dict[curr] = Product(curr)
        #     elif curr_name != '' and curr.isdigit():
        #         curr_quantity = curr
        #         # print(curr_name, curr_quantity) # 득실 계산시 필요
        #         self.Recipe_dict[line[0]].append((curr_name, curr_quantity))
        #
        #         curr_name = ''
        #     else:
        #         self.Recipe_dict[line[0]].append(curr)
        # print('Recipe_dict :', self.Recipe_dict)
        # print('')
        pass
