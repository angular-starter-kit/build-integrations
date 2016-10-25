package kaer.morhen.rest;

public class Comment {
    private String user;
    private String text;

    public Comment() {
        // for Jackson
    }

    public Comment(String user, String text) {
        setUser(user);
        setText(text);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}