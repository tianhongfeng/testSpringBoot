package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext session = se.getSession().getServletContext();

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
