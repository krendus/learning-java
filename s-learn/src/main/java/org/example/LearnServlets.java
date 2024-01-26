package org.example;
import java.io.*;
import javax.servlet.*;

public class LearnServlets extends GenericServlet {
    public void service (ServletRequest req, ServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<b>Hello</b>");
        pw.close();
    }
}
