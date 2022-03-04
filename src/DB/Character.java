package DB;

import java.sql.Timestamp;

public class Character {

    private Long id;
    private String name;
    private String anime;
    private String skills;
    private String biography;
    private String picture;
    private Timestamp postDate;
    private User user;
    private int likes;

    public Character(Long id, String name, String anime, String skills, String biography, String picture, Timestamp postDate, User user) {
        this.id = id;
        this.name = name;
        this.anime = anime;
        this.skills = skills;
        this.biography = biography;
        this.picture = picture;
        this.postDate = postDate;
        this.user = user;
    }

    public Character(){

    }

    public Character(Long id, String name, String anime, String skills, String biography, String picture, Timestamp postDate, User user, int likes) {
        this.id = id;
        this.name = name;
        this.anime = anime;
        this.skills = skills;
        this.biography = biography;
        this.picture = picture;
        this.postDate = postDate;
        this.user = user;
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
