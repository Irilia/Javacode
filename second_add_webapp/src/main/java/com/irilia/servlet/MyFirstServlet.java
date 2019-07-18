package com.irilia.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*继承HttpServlet
* 报错：引入servlet jar包
*
* 正常访问：
* http://localhost:8080/web工程名称/servlet的url-pattern
*
* http://localhost:8080/hello
* */
public class MyFirstServlet extends HttpServlet {
    //覆盖一个doGet()：默认get方式提交

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //servlet和浏览器是交互的，向浏览器输出内容
        response.getWriter().print("hello,serclet,i'm coming...");
    }
}
