package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Playable.Playable;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id,title, category, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        super(id,title, category, director, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id,title, category, director, length, cost);
    }

    public void toString(int i){
        System.out.println(this.getId() + ". DVD - "+this.getTitle() + " - "+ this.getCategory() + " - "+ this.getDirector() + " - "+this.getLength() + ": " + this.getCost() + " $");
    }
    public String toString(){
        return this.getId() + ". DVD - "+this.getTitle() + " - "+ this.getCategory() + " - "+ this.getDirector() + " - "+this.getLength();
    }
    public void print(){
        System.out.println("- DVD - "+this.getTitle() + " - "+ getCategory() + " - "+ this.getDirector() + " - "+this.getLength() + ": " + this.getCost() + " $");
    }

    @Override
    public void play() {
        if(this.getLength() > 0){
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
         else System.out.println("DVD " + this.getTitle() + " can not be played");
    }
}
