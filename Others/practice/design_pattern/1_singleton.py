class Singleton:
    __instance = None
    def __new__(cls, *args, **kwargs):
        if not cls.__instance:
            cls.__instance = object.__new__(cls, *args, **kwargs)
            print('new')
        return cls.__instance

    # def __init__(self):
    #     if not self.__instance:
    #         print('init')
    #         self.__instance = True
    #     print('init')


sooyong = Singleton()
sangho = Singleton()
print(sooyong)
print(sangho)