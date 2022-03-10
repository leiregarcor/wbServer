package nirepaketea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// kendu behar dugu hutsetik egingi dugulako @WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    // login bat kudeatuko dugu -> apurka apurka hobetzen joango gara
    // gogoratu serlvlerern konfigurazioa egin behar dela web.xml fitxategian
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> GET LoginServleT servlet-ean sartzen....");

        String erabiltzailea = request.getParameter("username");
        String pasahitza = request.getParameter("password");
        System.out.println("\tErabiltzailea: " + erabiltzailea);
        System.out.println("\tPasahitza: " + pasahitza);

        if (erabiltzailea == null || pasahitza == null){
            response.sendRedirect("/wbServer/html/login_error.html");
        } else {
            if (erabiltzailea.equals("oskar") && pasahitza.equals("1234")) {
                // 302 erantzuna Location goiburuan ongietorri orriraren URIarekin
                response.sendRedirect("/wbServer/html/ongietorri.html");
            } else {
                // 302 erantzuna Location goiburuan errore orriraren URIarekin
                response.sendRedirect("/wbServer/html/login_error.html");
            }
        }

        System.out.println("---> GET LoginServleT servlet-etik irteten....");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post metodora zeozer heltzen bada get metodora pasatuko diogu
        doGet(request, response);
    }
}
