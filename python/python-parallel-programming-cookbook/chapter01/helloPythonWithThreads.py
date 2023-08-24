from threading import Thread
from time import sleep


class CookBook(Thread):
    def __init__(self):
        Thread.__init__(self)
        self.message = "Hello Parallel Python CookBook!!\n"

    def print_message(self):
        print(self.message)

    def run(self):
        print("Thread Starting\n")
        x = 0
        while x < 10:
            self.print_message()
            sleep(2)
            x += 1
        print("Thread Ended\n")


# 主线程结束了，子线程还在执行
# 1. join 可以使主线程等待
# 2. 子线程默认是非 deamon 线程

print("Process Started")
hello_python = CookBook()
hello_python.start()

hello_python.join()
print("Process Ended")
