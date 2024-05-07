package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FrontController extends HttpServlet {

    public void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
        String path = req.getServletPath();
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head><title>Path</title></head>");
        out.println("<body>");
        out.println("<h1>FrontController</h1>");
        out.println("<h3>Path: " + path + "</h3>");
        out.println("</body></html>");
        out.close();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
        processRequest(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
        processRequest(req, res);
    }
}
