package AimsProject.src.hust.soict.globalict.aims.store;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        if (result == 1){
            this.storeMenu();
        }
    }
    public void storeMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        if (result == 0){
            this.showMenu();
        }
        else if (result == 1){
            return;
        }
    }
}
