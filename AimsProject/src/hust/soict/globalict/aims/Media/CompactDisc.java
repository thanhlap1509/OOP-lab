package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Playable.Playable;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private int id;
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public CompactDisc(int id, String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.id = id;
        this.artist = artist;
    }
    public void addTrack(Track track){
        for (Track curTrack: tracks){
            if (curTrack.equals(track)){
                System.out.println("This track is already in the CD");
                return;
            }
        }
        tracks.add(track);
        System.out.println("Track added successfully");
    }
    public void removeTrack(Track track){
        for (int i = 0; i < tracks.size(); i++){
            if (tracks.get(i).equals(track)){
                tracks.remove(i);
                System.out.println("Track removed successfully");
                return;
            }
        }
        System.out.println("Can't found track in the track list");
    }
    public int getLength(){
        int total = 0;
        for (Track track : tracks){
            total += track.getLength();
        }
        return total;
    }
    public int getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        for (Track track: tracks){
            track.play();
        }
    }
    public void toString(int i){
        System.out.println((i + 1)+ ". CD - " + this.getTitle()  + " - "+ this.getCategory() + " - "  + this.artist + " - " + this.getDirector() + " - "  + this.getLength() + ": " + this.getCost() + " $");
        for (Track track : tracks){
            track.play();
        }
    }
}
