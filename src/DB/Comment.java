package DB;

import java.sql.Timestamp;

public class Comment {

    private Long id;
    private User user;
    private Character character;
    private String comment;
    private Timestamp postDate;

    public Comment(){

    }

    public Comment(Long id, User user, Character character, String comment, Timestamp postDate) {
        this.id = id;
        this.user = user;
        this.character = character;
        this.comment = comment;
        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }
}
