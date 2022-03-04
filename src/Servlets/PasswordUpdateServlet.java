package Servlets;

import DB.DBManager;
import DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/passwordupdate")
public class PasswordUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("CURRENT_USER");

        if (user != null){

            String oldPassword = req.getParameter("old_password");
            String newPassword = req.getParameter("new_password");
            String reNewPassword = req.getParameter("re_new_password");

            if (oldPassword.equals(user.getPassword())){

                if(newPassword.equals(reNewPassword)){
                    user.setPassword(newPassword);
                    req.getSession().setAttribute("CURRENT_USER", user);
                    if (DBManager.updatePassword(user)){
                        resp.sendRedirect("/profile?successPassword");
                    } else {
                        resp.sendRedirect("/profile?updateError");
                    }
                } else {
                    resp.sendRedirect("/profile?notEqual");
                }

            } else {
                resp.sendRedirect("/profile?oldPasswordError");
            }

        }


    }
}
