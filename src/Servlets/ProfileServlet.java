package Servlets;

import DB.DBManager;
import DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("CURRENT_USER");

        if (user != null){
            req.getRequestDispatcher("/profile.jsp").forward(req,resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String full_name = req.getParameter("full_name");
        User user = (User) req.getSession().getAttribute("CURRENT_USER");

        user.setFull_name(full_name);
        if (DBManager.updateProfile(user)){
            req.getSession().setAttribute("CURRENT_USER", user);
            resp.sendRedirect("/profile?profileUpdated");
        }   else {
            resp.sendRedirect("/profile?profileUpdateError");
        }

    }
}
