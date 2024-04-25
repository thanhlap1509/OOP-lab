package AimsProject.src.hust.soict.globalict.aims.disc;

import AimsProject.src.hust.soict.globalict.aims.Media.Media;

public class Disc extends Media {
    private int length;
    private String director;
    public Disc(String title){
        setTitle(title);
    }
    public Disc(String title, String category, float cost){
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }
    public Disc(String title, String category, String director, float cost) {
        this.director = director;
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }
    public Disc(String title, String category, String director, int length, float cost){
        setTitle(title);
        setCategory(category);
        setCost(cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}
