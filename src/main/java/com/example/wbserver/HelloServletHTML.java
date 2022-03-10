package com.example.wbserver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServletHTML", value = "/HelloServletHTML")
public class HelloServletHTML extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> GET HelloServletHTML servlet-ean sartzen....");
        // zerbitzariak automatikoki kodea eta deskribapena sartzen ditu
        // erantzunare gaiburuak
        response.setContentType("text/html");

        PrintWriter http_out = response.getWriter(); // erantzunaren edukia idazteko

        http_out.println("<html><body>");
        http_out.println("<form method=\"POST\" action=\"/wbServer/HellloServletHTMLarenURIa\">"); // form bere buruari apuntatzen du POST metodoarekin
        http_out.println("<input name=\"nan\" type=\"text\">");
        http_out.println("<input type=\"submit\">");
        http_out.println("</form>");
        http_out.println("</body></html>");

        System.out.println("---> GET HelloServletHTML servlet-ean irteten....");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> POST HelloServletHTML servlet-ean sartzen....");

        String nan = request.getParameter("nan");
        response.setContentType("text/plain");
        PrintWriter http_out = response.getWriter();
        http_out.println(nan);
        System.out.println("---> NAN zenbakiaren letra kalkulaten....");
        http_out.println(calcularNif(nan));
        System.out.println("---> NAN zenbakiaren letra kalkulatuta");

        System.out.println("---> POST HelloServletHTML servlet-etik irteten....");
    }

    public static final String NAN_LETRA = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static String calcularNif(String nanZenbaki) {
        int zbk = Integer.valueOf(nanZenbaki);
        return String.valueOf(nanZenbaki) + NAN_LETRA.charAt(zbk % 23);
    }
}
