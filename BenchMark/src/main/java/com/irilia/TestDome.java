package com.irilia;

import com.irilia.cases.SortCase;
import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestDome {
    public static void main(String[] args) throws Exception {
        //生成一个文档对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //在文档中生成一个表单对象
        HSSFSheet sheet = wb.createSheet("测试报表");
        //在表单里创建第一行
        HSSFRow row = sheet.createRow(0);
        //设施样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //生成一个列对象
        HSSFCell cell = null;
        //给出表格的头名称
        String[] title = {"测试用例","测试次数","测试耗时"};
        for (int j = 0; j < title.length; j++) {
            //在第一行里创建列
            cell = row.createCell(j);
            //将元素填入第row行cell列里
            cell.setCellValue(title[j]);
            //设置样式
            cell.setCellStyle(style);
        }
        List<String[]> list = new ArrayList<String[]>();

        CaseLoader loader = new CaseLoader();
        loader.load().run(list,row,sheet);
        //输出一个Excel文件
        FileOutputStream outputStream = new FileOutputStream("E:/testBook.xls");
        try {
            //写入到文件中
            wb.write(outputStream);
            //关闭流
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       /*int[] a = {1,9,8,3,2,1,5,4,3,7,6,9,4,5,7,7,8,5};
       new SortCase().mergeSort(a);
        System.out.println(Arrays.toString(a));*/


    }
}
