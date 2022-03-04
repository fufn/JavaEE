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

@WebServlet (value = "/addcharacter")
public class AddCharacterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("CURRENT_USER");

        if (user != null){
            req.getRequestDispatcher("/addCharacter.jsp").forward(req,resp);
        } else {
            resp.sendRedirect("/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        User user = (User) req.getSession().getAttribute("CURRENT_USER");

        if (user != null){

            String name = req.getParameter("name");
            String anime = req.getParameter("anime");
            String skills = req.getParameter("skills");
            String biography = req.getParameter("biography");
            String picture = req.getParameter("picture");

            Character character = new Character();
            character.setName(name);
            character.setAnime(anime);
            character.setBiography(biography);
            character.setUser(user);
            character.setSkills(skills);
            character.setPicture(picture);

            if (DBManager.addCharacter(character)){
                resp.sendRedirect("/addcharacter?success");
            } else {
                resp.sendRedirect("addcharacter?error");
            }

        } else {
            resp.sendRedirect("/login");
        }


    }

}
