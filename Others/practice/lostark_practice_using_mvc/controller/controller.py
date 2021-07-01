import csv
import pandas

import lostark_practice_using_mvc.view.view as view
import lostark_practice_using_mvc.model.product as model


class Controller:

    def __init__(self, my_view):
        print("class Controller initialized")
        
        # 유저의 선호 품목을 csv로 저장 및 불러오기,
        # 로스트아크의 전체 제작식을 DB로 사전에 저장 및 불러오기 <-무슨 DB?
        self.product_dict = {}
        self.product_list = []
        self.get_user_product_from_csv('./user_products.csv')
        self.view = my_view
        self.view.set_controller(self)

    # tk 메인 루프 시작(GUI출력), 크롤러 시작
    def run(self):
        view.View.start_mainloop(self.view)

    def get_user_product_from_csv(self, directory):
        print("get_user_product_from_csv")
        try:
            file_reader = open(directory, 'r', encoding='UTF8')
        except FileNotFoundError:
            # 파일이 없다면 새로 생성
            temp_product_list = ['고급 회복약', '각성 각인서', '역천지체 각인서']
            self.save_user_product_to_csv(temp_product_list)
            file_reader = open(directory, 'r', encoding='UTF8')

        csv_reader = csv.reader(file_reader)
        for line in csv_reader:
            print(line)
            self.create_product_list(line[0])
        file_reader.close()
        print(self.product_list)
        print(self.product_dict)

    def create_product_list(self, name):
        print("create_product_dict")
        if name.isdigit():
            pass
        else:
            self.product_list.append(name)
            self.product_dict[name] = model.Product(name)

    def save_user_product_to_csv(self, product_list):
        data_frame = pandas.DataFrame(product_list)
        data_frame.to_csv('./user_products.csv', index=False)
