package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Media.Media;

public class Disc extends Media {
    private int length;
    private String director;
    public Disc(String title){
        setTitle(title);
    }
    public Disc(int id, String title, String category, float cost){
        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }
    public Disc(int id,String title, String category, String director, float cost) {
        setId(id);
        this.director = director;
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }
    public Disc(int id, String title, String category, String director, int length, float cost){
        setId(id);
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
