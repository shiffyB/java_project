package servlets;

import classes.User;
import classes.Clinic;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ejb.NameClinicLocal;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

    private Clinic clinic;

    //@EJB
    //private NameClinicLocal nameClinic;
    
    //private static final long serialVersionUID = 1L;
    /**
     * Default constructor.
     */
    public Login() {
        clinic = Clinic.getInstance();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //שליפת שם וסיסמא מה-URL
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        User currentUser = null;
        if (name != null && password != null) {
            //שליפת המשתמש שזה השם והסיסמא שלו
            for (User user : clinic.getUsers()) {
                if (user.getName().equals(name) && user.getPassword().equals(password)) {
                    currentUser = user;
                }
            }
            //response.getWriter().write(nameClinic.getName("ddd"));

            //העברה לדף המתאים לפי סוג המשתמש רופא או מטופל לפי סוג ההרשאה
            if (currentUser == null) {
                out.append("you do not have permission to log in");
                request.getRequestDispatcher("/index.jsp").include(request, response);
            } else if (currentUser.getPermission() == 2) {
                request.getServletContext().setAttribute("doctor", currentUser);
                request.getRequestDispatcher("/WelcomeDoctor.jsp").include(request, response);
            } else if (currentUser.getPermission() == 1) {
                request.getServletContext().setAttribute("patient", currentUser);
                request.getRequestDispatcher("/WelcomeUser.jsp").include(request, response);
            } else {
                out.append("you do not have permission to log in");
                request.getRequestDispatcher("/index.jsp").include(request, response);
            }
        }
    }
}
