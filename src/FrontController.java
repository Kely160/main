package controller;

import java.io.*;
import java.util.*;
import java.net.URL;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import annotation.*;

public class FrontController extends HttpServlet {
    boolean checked = false;
    List<String> nomControllers = new ArrayList<>();

    public void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
        if (!checked) {
            scanControllerClasses("controller");
        }

        try {
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println("<html>");
            out.println("<head><title>Path</title></head>");
            out.println("<body>");
            out.println("<h1>FrontController</h1>");
            out.close();
            if (nomControllers.size() != 0) {
                for (String nomController : nomControllers) {
                    out.println("<p> Controller: " + nomController + "</p>");
                }
            }
            out.println("</body></html>");
        } catch (Exception e) {}
    }

    private void scanControllerClasses(String p) {
        try {
            ServletContext context = getServletContext();
            String packageName = context.getInitParameter(p);

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Enumeration<URL> resources = classLoader.getResources(packageName.replace('.', '/'));

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                if (resource.getProtocol().equals("file")) {
                    File file = new File(resource.toURI());
                    scanControllers(file, packageName);
                }
            }

            checked = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void scanControllers(File directory, String packageName) {
        if (!directory.exists()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                scanControllers(file, packageName + "." + file.getName());
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                try {
                    Class<?> clazz = Class.forName(className);
                    if (clazz.isAnnotationPresent(Controller.class)) {
                        nomControllers.add(className);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
        processRequest(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
        processRequest(req, res);
    }
}
