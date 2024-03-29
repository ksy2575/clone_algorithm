from collections import defaultdict
from selenium import webdriver
import csv
import time
import subprocess

SLEEP_TIME = 0.2
SLEEP_COUNT = 25

class Product:
    # 클래스 속성 <- Product 클래스 공통의
    # name = ''
    # curr_price = 0

    # Product 클래스는 여러 개 생성되어야 하기 때문에 싱글턴 패턴을 적용하기엔 무리가 있다.
    # def __new__(cls, *args, **kwargs):
    #     if not hasattr(cls, "_instance"):
    #         print('__new__called')
    #         cls._instance = super().__new__(cls)
    #     return cls._instance

    def __init__(self, name):
        print('Instance', name, 'created')
        self.name = name
        self.curr_price = 0
        self.latest_price = 0
        self.bundle = 0

    def set_price(self, curr_price, latest_price, bundle, name):
        print("Set price of", name, ':', curr_price)
        self.curr_price = curr_price
        self.latest_price = latest_price
        self.bundle = bundle

    def ret_price(self):
        return self.curr_price


class ProductConstructor:
    product_dict = defaultdict(Product)
    Recipe_dict = defaultdict(list)

    def __init__(self, directory):
        self.file_reader = open(directory, 'r')
        self.read_line()

    def read_line(self):
        csv_reader = csv.reader(self.file_reader)
        for line in csv_reader:
            # print(line)
            self.create_product_dict(line)
        self.file_reader.close()

    def create_product_dict(self, line):
        for index in range(len(line)):
            curr = line[index]
            if index == 0:
                if curr not in self.product_dict:
                    self.product_dict[curr] = Product(curr)
                self.Recipe_dict[curr]
            elif not curr.isdigit():
                curr_name = curr
                if curr not in self.product_dict:
                    self.product_dict[curr] = Product(curr)
            elif curr_name != '' and curr.isdigit():
                curr_quantity = curr
                # print(curr_name, curr_quantity) # 득실 계산시 필요
                self.Recipe_dict[line[0]].append((curr_name, curr_quantity))

                curr_name = ''
            else:
                self.Recipe_dict[line[0]].append(curr)
        print('Recipe_dict :', self.Recipe_dict)
        print('')


class Crawler:
    def __init__(self):
        self.isReady = False
        options = webdriver.ChromeOptions()
        options.add_argument('headless')
        options.add_argument('window-size=1920x1080')
        options.add_argument("disable-gpu")
        self.chromedriver = '.\chromedriver\chromedriver.exe'
        self.browser = webdriver.Chrome(self.chromedriver, options=options)
        self.browser.get('https://lostark.game.onstove.com/Market')
        self.item_name_textfield = self.browser.find_element_by_xpath(
        "/html/body/div[2]/div/main/div/div[2]/div[2]/form/fieldset/div/div[1]/input")
        self.item_name_deleteBtn = self.browser.find_element_by_xpath(
        "/html/body/div[2]/div/main/div/div[2]/div[2]/form/fieldset/div/div[1]/button")
        self.searchBtn = self.browser.find_element_by_xpath(
            '/html/body/div[2]/div/main/div/div[2]/div[2]/form/fieldset/div/div[4]/button[1]')

        print("+" * 100)
        print(self.browser.title)
        print(self.browser.current_url)
        print("로아 거래소")
        print("-" * 100)

    def product_construct(self, product_dict):
        for curr in product_dict:
            # print(curr)
            self.item_name_textfield.send_keys(curr)
            self.searchBtn.click()
            curr_price = -1
            latest_price = -1
            bundle = 1
            time.sleep(1)
            for i in range(SLEEP_COUNT):
                try:
                    self.table = self.browser.find_element_by_xpath(
                        '/html/body/div[2]/div/main/div/div[2]/div[2]/div/div/div[1]/table')
                    self.tbody = self.table.find_element_by_tag_name("tbody")
                    rows = self.tbody.find_elements_by_tag_name("tr")
                    for row in enumerate(rows):
                        index, value = row
                        body = value.find_elements_by_tag_name("td")[0]

                        if body.text.split('\n')[0] == curr:
                            if body.text.split('\n')[0] == '죽음의 습격 각인서' and index != 3:
                                print(index)
                                continue
                            print(curr)
                            latest_price = value.find_elements_by_tag_name("td")[1]
                            cost = value.find_elements_by_tag_name("td")[3]
                            bundle = self.export_bundle(body.text)
                            curr_price = int(''.join(cost.text.split(','))) # / bundle
                            latest_price = float(''.join(latest_price.text.split(','))) # / bundle
                            print('curr_price', curr_price, 'latest_price', latest_price)

                            break
                    break
                except:
                    print(i, 'SLEEP_TIME')
                    time.sleep(SLEEP_TIME)
            else:
                print("테이블 정보 불러오기 시간 초과")
                quit()

            product_dict[curr].set_price(curr_price, latest_price, bundle, curr)

            self.item_name_deleteBtn.click()

    def export_bundle(self, s):
        if '단위 판매' in s:
            bundle = int(''.join(x for x in s if x.isdigit()))
            return bundle
        return 1

    def __del__(self):
        try:
            self.browser.close()
            print('Chrome browser successfully closed.')
        except:
            print('Chrome browser has not closed.')

        try:
            self.browser.quit()
            print('Chrome driver successfully closed.')
        except:
            print('Chrome driver has not closed formally.')
            try:
                subprocess.call("TASKKILL /f /IM CHROMEDRIVER.EXE")
                print('Chrome driver successfully KILLED.')
            except:
                print('Chrome driver has not KILLED.')


def main():
    constructor = ProductConstructor('./practice.csv')
    crawler = Crawler()
    crawler.product_construct(constructor.product_dict)
    print(constructor.product_dict)
    print(constructor.Recipe_dict)
    print(constructor.product_dict['고급 회복약'].ret_price())
    # return constructor.product_dict['죽음의 습격 각인서'].ret_price()
def __del__():
    print('asdf')
main()