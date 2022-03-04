package Servlets;

import DB.Character;
import DB.DBManager;
import DB.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/readcharacter")
public class ReadCharacterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Long c_id = -1L;

        try {
            c_id = Long.parseLong(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        Character character = DBManager.getCharacter(c_id);
        req.setAttribute("character", character);
        req.getRequestDispatcher("/readCharacter.jsp").forward(req,resp);

    }
}