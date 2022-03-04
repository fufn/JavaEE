package Servlets;

import DB.DBManager;
import DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/signup")
public class SignUpServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().removeAttribute("CURRENT_USER");
        req.getRequestDispatcher("/signUp.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String full_name = req.getParameter("full_name");
        User user = new User(email, password, full_name);
        if (DBManager.addUser(user)){
            req.getSession().setAttribute("CURRENT_USER", user);
            resp.sendRedirect("/profile");
        } else {
            resp.sendRedirect("/signup?error");
        }
    }
}
