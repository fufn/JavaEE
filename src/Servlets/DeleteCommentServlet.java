package Servlets;

import DB.Character;
import DB.Comment;
import DB.DBManager;
import DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/deletecomment")
public class DeleteCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("CURRENT_USER");

        if (user != null){

            String id = req.getParameter("comment_id");
            Long c_id = -1L;

            try {
                c_id = Long.parseLong(id);
            } catch (Exception e){
                e.printStackTrace();
            }

            DBManager.deleteComment(c_id, user.getId());

        } else {
            resp.sendRedirect("/login");
        }


    }

}
