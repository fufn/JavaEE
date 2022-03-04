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
import java.util.ArrayList;

@WebServlet (value = "/allcharacters")
public class AllCharactersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Character> characters = DBManager.getCharacters();
        req.setAttribute("characters", characters);
        req.getRequestDispatcher("/allCharacters.jsp").forward(req,resp);

    }
}
