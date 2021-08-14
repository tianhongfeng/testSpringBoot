package filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterencodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterencodeFilter初始化了");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 解决中文乱码
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //
        System.out.println("CharacterencodeFilter执行前");
        chain.doFilter(request, response); // 让过滤器一直往下走
        System.out.println("CharacterencodeFilter执行后");
    }

    @Override
    public void destroy() {
        System.out.println("CharacterencodeFilter销毁了");
    }
}
