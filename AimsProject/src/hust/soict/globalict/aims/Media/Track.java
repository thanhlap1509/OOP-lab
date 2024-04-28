package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Playable.Playable;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        if (this.length > 0){
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }
        else System.out.println("Track " + this.getTitle() + " can not be played");
    }
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Track)) return false;
        String objTitle = ((Track) o).getTitle();
        int objLength = ((Track) o).getLength();
        return objTitle.equals(this.title) && objLength == this.length;
    }
}
