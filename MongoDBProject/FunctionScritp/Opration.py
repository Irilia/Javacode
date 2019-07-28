# -*- coding: utf-8 -*-
import unittest,csv
import os,sys
import time
import HTMLTestRunner
#手工添加案例到套件，
def createsuite():
    discover=unittest.defaultTestLoader.discover('../FunctionScritp',pattern='test*.py',top_level_dir=None)
    print discover
    return discover
if __name__=="__main__":
    curpath=sys.path[0]
    #取当前时间
now=time.strftime("%Y-%m-%d-%H %M %S",time.localtime(time.time()))
if not os.path.exists(curpath+'/Opration'):
    os.makedirs(curpath+'/Opration')
filename=curpath+'/Opration/'+now+'Opration.html'
#出html报告
with open(filename,'wb') as fp:
    runner=HTMLTestRunner.HTMLTestRunner(stream=fp,title=u'测试报告',description=u'用例执行情况',verbosity=2)
    suite=createsuite()
    runner.run(suite)