package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 解决中文乱码 在过滤器中实现了
//        resp.setContentType("text/html;charset=utf-8");
//        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        // 从请求中获取cookie
        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        if(cookies != null){
            for(Cookie c:cookies){
                if(c.getName().equals("lastlogintime")){
                    flag = true;
                    long lastlogintime = Long.parseLong(c.getValue());
                    Date date = new Date(lastlogintime);
                    out.write("你上一次访问的时间是：" + date.toLocaleString());
                }
            }
            if(!flag) out.write("这是你第一次访问本站");
        }

        // 服务器端响应一个cookie
        Cookie cookie = new Cookie("lastlogintime", System.currentTimeMillis() + "");
        // 设置cookie 存在时间
//        cookie.setMaxAge(0);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
