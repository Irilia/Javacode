package com.irilia.Hello_cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*cookie的基本使用*/
public class HelloCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //创建一个cookie对象
        Cookie c = new Cookie("akey","aValue");
        //由服务器响应给浏览器，要把当前对象写回浏览器
        response.addCookie(c);
        //设置cookie的有效期时间,以秒位单位
        c.setMaxAge(3600);
        //设置一个下次访问时的提示：
        response.getWriter().print("cookie已写回");
        //下一次浏览器请求访问的话可以去获取cookie数据
        Cookie[] cookies = request.getCookies();
        //遍历cookies
        if(cookies != null){
            for(Cookie cookie:cookies){
                //可以获取cookie的名称和值
                //String getName（）
                //String getValue（）
                System.out.println(cookie.getName()+":"+cookie.getValue());
            }
        }
    }
}
