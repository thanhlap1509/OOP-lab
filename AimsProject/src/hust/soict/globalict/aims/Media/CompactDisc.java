package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Playable.Playable;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(int id,String title, String category, float cost) {
        super(id,title, category, cost);
    }

    public CompactDisc(int id,String title, String category, String director, float cost) {
        super(id,title, category, director, cost);
    }

    public CompactDisc(int id,String title, String category, String director, int length, float cost) {
        super(id,title, category, director, length, cost);
    }

    public CompactDisc(int id, String title, String category, String director, int length, float cost, String artist) {
        super(id,title, category, director, length, cost);
        this.artist = artist;
    }
    public int addTrack(Track track){
        for (Track curTrack: tracks){
            if (curTrack.equals(track)){
                System.out.println("This track is already in the CD");
                return 0;
            }
        }
        tracks.add(track);
        System.out.println("Track added successfully");
        return 1;
    }
    public int removeTrack(Track track){
        for (int i = 0; i < tracks.size(); i++){
            if (tracks.get(i).equals(track)){
                tracks.remove(i);
                System.out.println("Track removed successfully");
                return 1;
            }
        }
        System.out.println("Can't found track in the track list");
        return 0;
    }
    public int getLength(){
        int total = 0;
        for (Track track : tracks){
            total += track.getLength();
        }
        return total;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }


    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        for (Track track: tracks){
            track.play();
        }
    }
    public void toString(int i){
        System.out.println(this.getId() +  ". CD - " + this.getTitle()  + " - "+ this.getCategory() + " - "  + this.artist + " - " + this.getDirector() + " - "  + this.getLength() + ": " + this.getCost() + " $");
        for (Track track : tracks){
            track.play();
        }
    }
    public String toString(){
        StringBuilder returnString = new StringBuilder(this.getId() + ". CD - " + this.getTitle()  + " - "+ this.getCategory() + " - "  + this.artist + " - " + this.getDirector() + " - "  + this.getLength());
        for (Track track: tracks){
            returnString.append("\n").append(track.toString());
        }
        return returnString.toString();
    }
}
