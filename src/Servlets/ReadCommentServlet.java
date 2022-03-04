package Servlets;

import DB.Character;
import DB.Comment;
import DB.DBManager;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/readcomment")
public class ReadCommentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("character_id");
        Long c_id = -1L;

        try {
            c_id = Long.parseLong(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        Character character = DBManager.getCharacter(c_id);

        if (character != null){

            ArrayList<Comment> comments = DBManager.getComments(c_id);
            PrintWriter out = resp.getWriter();

            Gson gson = new Gson();
            String result = gson.toJson(comments);
            out.print(result);

        }

    }
}