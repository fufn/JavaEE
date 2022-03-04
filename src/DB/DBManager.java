package DB;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    private static Connection connection;

    static {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bootcamp_db?serverTimezone=UTC", "root", "");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static User getUser(String email){

        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ?"
            );
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                user = new User(resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"));
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static boolean updateProfile(User user){

        int row = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users SET full_name = ? WHERE id = ?"
            );
            statement.setString(1, user.getFull_name());
            statement.setLong(2, user.getId());

            row = statement.executeUpdate();

            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row>0;
    }

    public static boolean updatePassword(User user){

        int row = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users SET password = ? WHERE id = ?"
            );
            statement.setString(1, user.getPassword());
            statement.setLong(2, user.getId());

            row = statement.executeUpdate();

            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row>0;
    }

    public static boolean addUser (User user){

        int row = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO users(email, password, full_name) " +
                        "VALUES (?, ?, ?)"
            );
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFull_name());

            row = statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            row = 0;
            e.printStackTrace();
        }

        return row > 0;
    }

    public static boolean addCharacter (Character character){

        int row = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO characters(name, anime, skills, biography, picture, postDate, user_id) " +
                            "VALUES (?, ?, ?, ?, ?, NOW(), ?)"
            );
            statement.setString(1, character.getName());
            statement.setString(2, character.getAnime());
            statement.setString(3, character.getSkills());
            statement.setString(4, character.getBiography());
            statement.setString(5, character.getPicture());
            statement.setLong(6, character.getUser().getId());

            row = statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            row = 0;
            e.printStackTrace();
        }

        return row > 0;
    }

    public static ArrayList<Character> getCharacters(){

        ArrayList<Character> characters = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT c.id, c.name, c.anime, c.skills, c.biography, c.picture, c.postDate, c.user_id, u.full_name, c.likes " +
                            "FROM characters c " +
                            "INNER JOIN users u ON u.id = c.user_id " +
                            "ORDER BY c.postDate DESC"
            );

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                 characters.add(
                         new Character(
                                 resultSet.getLong("id"),
                                 resultSet.getString("name"),
                                 resultSet.getString("anime"),
                                 resultSet.getString("skills"),
                                 resultSet.getString("biography"),
                                 resultSet.getString("picture"),
                                 resultSet.getTimestamp("postDate"),
                                 new User(
                                         resultSet.getLong("user_id"),
                                         null,
                                         null,
                                         resultSet.getString("full_name")
                                 ),
                                 resultSet.getInt("likes")
                         )
                 );
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return characters;
    }

    public static Character getCharacter(Long id){

        Character character = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT c.id, c.name, c.anime, c.skills, c.biography, c.picture, c.postDate, c.user_id, u.full_name, c.likes " +
                            "FROM characters c " +
                            "INNER JOIN users u ON u.id = c.user_id " +
                            "WHERE c.id = ?"
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                character = new Character(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("anime"),
                        resultSet.getString("skills"),
                        resultSet.getString("biography"),
                        resultSet.getString("picture"),
                        resultSet.getTimestamp("postDate"),
                        new User(
                                resultSet.getLong("user_id"),
                                null,
                                null,
                                resultSet.getString("full_name")
                        ),
                        resultSet.getInt("likes")
                );

                statement.close();
            }

            } catch(SQLException e){
                e.printStackTrace();
            }

        return character;
    }

    public static boolean saveCharacter (Character character){

        int row = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE characters SET name= ?, anime = ?, skills =? , biography =?, picture =? WHERE id = ?"
            );
            statement.setString(1, character.getName());
            statement.setString(2, character.getAnime());
            statement.setString(3, character.getSkills());
            statement.setString(4, character.getBiography());
            statement.setString(5, character.getPicture());
            statement.setLong(6, character.getId());

            row = statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            row = 0;
            e.printStackTrace();
        }

        return row > 0;
    }

    public static boolean deleteCharacter (Long id){

        int row = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM characters WHERE id = ?"
            );
            statement.setLong(1, id);

            row = statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            row = 0;
            e.printStackTrace();
        }

        return row > 0;
    }

    public static boolean addComment (Comment comment){

        int row = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO comments(user_id, character_id, comment, postDate) " +
                            "VALUES (?, ?, ?, NOW())"
            );

            statement.setLong(1, comment.getUser().getId());
            statement.setLong(2, comment.getCharacter().getId());
            statement.setString(3, comment.getComment());

            row = statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            row = 0;
            e.printStackTrace();
        }

        return row > 0;
    }

    public static ArrayList<Comment> getComments(Long character_id){

        ArrayList<Comment> comments = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT c.id, c.user_id, c.character_id, c.comment, c.postDate, u.full_name " +
                            "FROM comments c " +
                            "INNER JOIN users u ON u.id = c.user_id " +
                            "WHERE c.character_id = ? " +
                            "ORDER BY c.postDate DESC"
            );

            statement.setLong(1, character_id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                comments.add(
                        new Comment(
                            resultSet.getLong("id"),
                            new User(
                                    resultSet.getLong("user_id"),
                                    null, null,
                                    resultSet.getString("full_name")
                            ),
                            new Character(resultSet.getLong("character_id"),
                                    null, null, null, null, null, null, null
                            ),
                                resultSet.getString("comment"),
                                resultSet.getTimestamp("postDate")
                        )
                );

            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    public static boolean deleteComment (Long id, Long user_id){

        int row = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM comments WHERE id = ? AND user_id = ?"
            );
            statement.setLong(1, id);
            statement.setLong(2,user_id);

            row = statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            row = 0;
            e.printStackTrace();
        }

        return row > 0;
    }

    public static int toLike (Long character_id, Long user_id){

        boolean liked = false;
        int likeAmount = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM likes WHERE user_id = ? AND character_id = ?"
            );

            statement.setLong(1,user_id);
            statement.setLong(2, character_id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                liked = true;
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String query = "DELETE FROM likes WHERE user_id = ? AND character_id = ?";

            if (!liked){
                query = "INSERT INTO likes (user_id, character_id) VALUES(?, ?) ";
            }

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setLong(1,user_id);
            statement.setLong(2, character_id);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT COUNT(*) like_amount FROM likes WHERE character_id = ?");

            statement.setLong(1, character_id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                likeAmount = resultSet.getInt ("like_amount");
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE characters SET likes = ? WHERE id = ?");

            statement.setInt(1, likeAmount);
            statement.setLong(2, character_id);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return likeAmount;

    }
}
