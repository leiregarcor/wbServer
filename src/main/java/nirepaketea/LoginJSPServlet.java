package nirepaketea;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


public class LoginJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request --> HTTP eskaerari erreferentzia egiteko objektua
        // response --> HTTP erantzunari erreferentzia egiteko objektua
        System.out.println("---> GET LoginJSPServlet servlet-ean sartzen....");

        String erabiltzailea = request.getParameter("username");
        String pasahitza = request.getParameter("password");
        System.out.println("\tErabiltzailea: " + erabiltzailea);
        System.out.println("\tPasahitza: " + pasahitza);

        if (erabiltzailea != null && pasahitza != null) {
            // datuak sartu dira
            if (erabiltzailea.equals("oskar") && pasahitza.equals("1234")) {
                // login zuzena (datuak zuzenak):
                System.out.println("---> Login OK: Creating session");
                // saioa sortu (Set Cookie erantzunean sartu)
                HttpSession session = request.getSession(true); // saiorik dagoen egiaztatu (request.getSession(true) esan nahi du sortzeko saioa sortuta ez balego)

                session.setAttribute("username", erabiltzailea);
                System.out.println("---> Login OK: redirecting to MainServlet");
                ServletContext context = request.getServletContext();
                RequestDispatcher rd = context.getNamedDispatcher("MainServlet");
                rd.forward(request,response);

            } else {
                // datuak ez dira zuzenak
                System.out.println("---> Login error: redirecting to login form");
                boolean login_error = true;
                // eskaeran "login_error" atributua erantsi
                request.setAttribute("login_error", login_error);
                RequestDispatcher rd = request.getRequestDispatcher("jsp/login_form.jsp");
                rd.forward(request, response); // pasatu fluxua login_form.jsp -ra
            }
        // daturik bidali ez bada edo erabiltzaileak servlet-a zuzenenean deitu badu:
        }else if (request.getSession(false) != null){
            // erabiltzaileak dagoeneko saio bat irekita dauka (cookie):
            System.out.println("---> User already logged: redirecting to MainServlet");
            ServletContext context = request.getServletContext();
            RequestDispatcher rd = context.getNamedDispatcher("MainServlet");
            rd.forward(request,response);
        }else{
            // erabiltzaileak ez du saiorik irekita
            System.out.println("---> User not logged: redirecting to  login form");
            RequestDispatcher rd = request.getRequestDispatcher("jsp/login_form.jsp");
            rd.forward(request,response);
        }

        System.out.println("---> GET LoginJSPServlet servlet-etik irteten....");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post metodora zeozer heltzen bada get metodora pasatuko diogu
        doGet(request, response);
    }
}
