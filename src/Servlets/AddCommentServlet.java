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

@WebServlet (value = "/addcomment")
public class AddCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("CURRENT_USER");

        if (user != null){

            String comment = req.getParameter("comment");
            String id = req.getParameter("character_id");
            Long c_id = -1L;

            try {
                c_id = Long.parseLong(id);
            } catch (Exception e){
                e.printStackTrace();
            }

            Character character = DBManager.getCharacter(c_id);
            if (character != null){
                Comment comm = new Comment();
                comm.setComment(comment);
                comm.setUser(user);
                comm.setCharacter(character);

                if (DBManager.addComment(comm)){

                }

            }

        } else {
            resp.sendRedirect("/login");
        }


    }

}
