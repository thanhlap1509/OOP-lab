package AimsProject.src.hust.soict.globalict.aims.store;
import java.util.ArrayList;

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
                System.out.println("This DVD is already in store");
                return;
            }
        }
        itemsInStore.add(media);
        length++;
        System.out.println("DVD added to store successfully");
    }
    public void removeMedia(Media media) {
        for (int i = 0; i < length; i++) {
            if (itemsInStore.get(i).equals(media)) {
                itemsInStore.remove(i);
                length--;
                break;
            }
        }
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            if (itemsInStore.get(i) instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) itemsInStore.get(i)).print();
            }
        }
    }
}
