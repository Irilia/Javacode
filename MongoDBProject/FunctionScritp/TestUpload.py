#coding=utf-8
'''
import unittest

from selenium import webdriver


class TestUpload(unittest.TestCase):

    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(30)
        self.base_url = "http://localhost:8080/"
        self.verificationErrors = []
        self.accept_next_alert = True


        def test_upload(self):
            driver = self.driver
            driver.get(self.base_url+"/")
            driver.find_element_by_class_name("filename").clear()
            driver.find_element_by_class_name("filename").send_keys(u"C:\Users\Rachel\Pictures\Saved Pictures")
            driver.find_element_by_css_selector("input[type=\"submit\"]").click()
            driver.find_element_by_xpath(u"(//a[contains(text(),'查看')])[3]").click()
            driver.find_element_by_xpath(u"(//a[contains(text(),'删除')])[2]").click()

        def

'''
__author__ = 'sunraylily'
# -*- coding: utf-8 -*-
from selenium import webdriver
import unittest,os
class Testupload(unittest.TestCase):
    def setUp(self):
         self.driver = webdriver.Firefox()
         self.driver.implicitly_wait(30)
         self.base_url = "http://localhost:8080/"
         self.verificationErrors = []
         self.accept_next_alert = True
#上传文件
    def test1_upload(self):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_name("filename").clear()
        driver.find_element_by_name("filename").send_keys(u"C:\\Users\\Rachel\\Pictures\\Saved Pictures\\timgU0QAKK1A.jpg")
        driver.find_element_by_css_selector("input[type=\"submit\"]").click()
        driver.implicitly_wait(30)
        if driver.find_element_by_link_text(u"timgU0QAKK1A.jpg").is_displayed():
            print "上传成功"
        else:
            print "上传失败"
        driver.quit()
#下载文件
    def test2_down(self):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_link_text(u"timgU0QAKK1A.jpg").click()
        driver.implicitly_wait(30)
        if os.path.exists(u"C:\\Users\Rachel\AppData\Local\Temp\\timgU0QAKK1A.jpg"):
            print "下载成功"
        else:
            print "下载失败"
        driver.quit()
#查看文件
    def test3_view(self):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_xpath(u"(//a[contains(text(),'查看')])[3]").click()
        driver.implicitly_wait(30)
        handles = driver.window_handles #获取当前打开的所有窗口的句柄
        print(handles)
        driver.switch_to.window(handles[1]) #切换到第二个窗口的句柄
        print(driver.current_window_handle)
        print(driver.title)
        print(driver.current_url)
        driver.quit()
#删除上传文件
    def test4_delete(self):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_xpath(u"(//a[contains(text(),'删除')])[2]").click()
        driver.implicitly_wait(30)
        print "删除成功"
        driver.quit()

    def tearDown(self):
        self.driver.quit()
        self.assertEqual([], self.verificationErrors)
if __name__ == "__main__":
        unittest.main()