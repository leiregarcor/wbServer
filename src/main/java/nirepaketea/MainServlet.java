package nirepaketea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// @WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request --> HTTP eskaerari erreferentzia egiteko objektua
        // response --> HTTP erantzunari erreferentzia egiteko objektua
        System.out.println("---> GET MainServlet servlet-ean sartzen....");

        if (request.getSession(false) == null){ // saiorik dagoen egiaztatu (request.getSession(false) esan nahi du ez sortzeko saiorik sortuta ez balego)

            System.out.println("---> User is not logged in: redirecting to login form");
            RequestDispatcher rd = request.getRequestDispatcher("jsp/login_form.jsp");
            rd.forward(request, response);
        }else {
            System.out.println("---> User is logged: redirecting to welcome.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("jsp/welcome.jsp");
            rd.forward(request, response);
        }


        System.out.println("---> GET MainServlet servlet-etik irteten....");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post metodora zeozer heltzen bada get metodora pasatuko diogu
        doGet(request, response);
    }
}
