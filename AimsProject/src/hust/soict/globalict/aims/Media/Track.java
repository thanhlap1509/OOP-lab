package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Playable.Playable;
import AimsProject.src.hust.soict.globalict.aims.exception.PlayerException;

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
    public void play() throws PlayerException {
        if (this.length > 0){
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }
        else {
            throw new PlayerException("ERROR: track length is non-positive!");
        }
    }
    public String toString(){
        return "Playing Track: " + this.getTitle() + "\n" + "Track length: " + this.getLength();
    }
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Track)) return false;
        String objTitle = ((Track) o).getTitle();
        int objLength = ((Track) o).getLength();
        return objTitle.equals(this.title) && objLength == this.length;
    }
}
