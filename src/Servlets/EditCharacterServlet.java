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

@WebServlet (value = "/editcharacter")
public class EditCharacterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("CURRENT_USER");

        if (user != null){
            String id = req.getParameter("id");
            Long c_id = -1L;

            try {
                c_id = Long.parseLong(id);
            } catch (Exception e){
                e.printStackTrace();
            }
            Character character = DBManager.getCharacter(c_id);
            req.setAttribute("character", character);
            req.getRequestDispatcher("/editCharacter.jsp").forward(req,resp);
        } else {
            resp.sendRedirect("/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("CURRENT_USER");

        if (user != null){
            String id = req.getParameter("id");
            Long c_id = -1L;

            try {
                c_id = Long.parseLong(id);
            } catch (Exception e){
                e.printStackTrace();
            }

            String name = req.getParameter("name");
            String anime = req.getParameter("anime");
            String skills = req.getParameter("skills");
            String biography = req.getParameter("biography");
            String picture = req.getParameter("picture");
            Character character = new Character();
            character.setId(c_id);
            character.setName(name);
            character.setAnime(anime);
            character.setBiography(biography);
            character.setUser(user);
            character.setSkills(skills);
            character.setPicture(picture);

            if (DBManager.saveCharacter(character)){
                resp.sendRedirect("/editcharacter?id=" + c_id);
            } else {
                resp.sendRedirect("readcharacter?error");
            }

        } else {
            resp.sendRedirect("/login");
        }
    }
}
