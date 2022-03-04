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

@WebServlet (value = "/deletecharacter")
public class DeleteCharacterServlet extends HttpServlet {


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

            if (DBManager.deleteCharacter(c_id)){
                resp.sendRedirect("/allcharacters");
            } else {
                resp.sendRedirect("/editcharacter?id=" + c_id);
            }

        } else {
            resp.sendRedirect("/login");
        }
    }
}
