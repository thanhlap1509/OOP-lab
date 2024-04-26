package AimsProject.src.hust.soict.globalict.aims.store;
import java.util.ArrayList;

import AimsProject.src.hust.soict.globalict.aims.Media.Book;
import AimsProject.src.hust.soict.globalict.aims.Media.CompactDisc;
import AimsProject.src.hust.soict.globalict.aims.Media.DigitalVideoDisc;
import AimsProject.src.hust.soict.globalict.aims.Media.Media;

public class Store {
    private ArrayList<Media> itemsInStore;
    private int length;

    public Store() {
        length = 0;
        itemsInStore = new ArrayList<Media>();
    }

    public void addMedia(Media media) {
        for (int i = 0; i < length; i++) {
            if (itemsInStore.get(i).equals(media)) {
                System.out.println("This media is already in store");
                return;
            }
        }
        itemsInStore.add(media);
        length++;
        System.out.println("Media added to store successfully");
    }
    public void removeMedia(Media media) {
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).equals(media)) {
                itemsInStore.remove(i);
                System.out.println("Media removed successfully");
                return;
            }
        }
        System.out.println("This media isn't in the store");
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            if (itemsInStore.get(i) instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) itemsInStore.get(i)).print();
            }
        }
    }
    public Media searchByTitle(String title){
        for (Media media : itemsInStore){
            if ((media.getTitle()).equals(title)){
                return media;
            }
        }
        return null;
    }
    public void displayMedia(){
        for (int i = 0; i < itemsInStore.size(); i++){
            Media media = itemsInStore.get(i);
            if (media instanceof Book){
                ((Book) media).toString(i);
            }
            else if (media instanceof CompactDisc){
                ((CompactDisc) media).toString(i);
            }
            else {
                ((DigitalVideoDisc)media).toString(i);
            }
        }
    }
}
