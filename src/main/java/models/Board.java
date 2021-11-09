package models;

public class Board {
    String title;

    public String getTitle() {
        return title;
    }

    public Board withTitle(String title) {
        this.title = title;
        return this;
    }
}
