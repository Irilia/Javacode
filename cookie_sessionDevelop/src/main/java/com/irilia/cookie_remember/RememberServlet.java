package com.irilia.cookie_remember;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/*案列1：记录当前用户访问的系统时间
* */
public class RememberServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        response.setContentType("text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();
        //1.从cookie数组中获取指定的cookie，通过名称来获取，看cookie是否存在
        //cookie名称：“lastTIme”
        Cookie c = getCookieByName("lastTime",request.getCookies());

        //判断cookie对象是否位空
        if(c == null){
            //第一次访问
            writer.print("您当前是第一次访问");
        }else{
            //不为空，获取cookie内容，展示访问时间
            String value = c.getValue();

            //将内容转化为long类型
            long time = Long.parseLong(value);

            //创建日期对象
            Date date = new Date(time);

            //提示：展示上次访问时间
            writer.print("您上次访问时间是："+date.toLocaleString());
        }

        //创建cookie，展示当前时间
        c = new Cookie("lastTime",new Date().getTime()+" ");
        writer.print("当前系统时间是："+new Date().getTime()+" ");

        //设置cookie的有效期
        c.setMaxAge(3600);

        //服务器写回浏览器
        response.addCookie(c);
        writer.print("系统时间已写回");
    }

    /*自定义的；从浏览器中存在的cookie数组中获取指定名称的cookie*/
    private Cookie getCookieByName(String name,Cookie[] cookies){

        //判断cookie数组是否位空
        if(cookies != null){
            for(Cookie cookie: cookies){
                //判断
                if(name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
