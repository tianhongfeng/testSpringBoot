package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Helloservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
//        String url = context.getInitParameter("url");
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("utf-8");
//        resp.getWriter().print("数据库连接地址：" + url);
        // 解决中文乱码
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
//        System.out.println("====================");
//        System.out.println(req.getContextPath());
//        req.getRequestDispatcher("/success.jsp").forward(req, resp);
//        resp.sendRedirect("success.jsp");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        if(session.getAttribute("name") != null){
            out.write(session.getAttribute("name") + "");
        }else{
            out.write("不存在");
        }
        resp.sendRedirect("success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
