package com.example.wbserver;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Kaixo mundua!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("---> HelloWolrd servlet-ean sartzen....");
        // zerbitzariak automatikoki kodea eta deskribapena sartzen ditu
        // erantzunare gaiburuak
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter(); // erantzunaren edukia idazteko
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        System.out.println("---> HelloWolrd servlet-ean irtetzen....");
    }

    public void destroy() {
    }
}