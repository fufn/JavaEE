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
import java.io.PrintWriter;

@WebServlet (value = "/tolike")
public class ToLikeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("CURRENT_USER");

        int likes = 0;

        if (user != null){

            String id = req.getParameter("character_id");
            Long c_id = -1L;

            try {
                c_id = Long.parseLong(id);
            } catch (Exception e){
                e.printStackTrace();
            }

            Character character = DBManager.getCharacter(c_id);
            if (character != null){

                likes = DBManager.toLike(character.getId(), user.getId());

            }
        } else {
            resp.sendRedirect("/login");
        }

        PrintWriter out = resp.getWriter();
        out.print(likes);

    }

}
