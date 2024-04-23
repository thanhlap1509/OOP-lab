package Lab02;

public class DigitalVideoDisc extends Disc{
    private String director;
    private int length;
    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public void toString(int i){
        System.out.println((i + 1)+ ". DVD - "+this.getTitle() + " - "+ this.getCategory() + " - "+ this.director + " - "+this.length + ": " + this.getCost() + " $");
    }
    public void print(){
        System.out.println("- DVD - "+this.getTitle() + " - "+ getCategory() + " - "+ this.director + " - "+this.length + ": " + this.getCost() + " $");
    }
    public boolean isMatch(String InputTitle){
        return getTitle().equals(InputTitle);
    }
}
