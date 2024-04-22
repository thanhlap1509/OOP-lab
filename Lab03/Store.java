package Lab03;
import java.util.ArrayList;

import Lab01.Array;
import Lab02.DigitalVideoDisc;
public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore;
    private int length;
    Store(){
        length = 0;
        itemsInStore = new ArrayList<DigitalVideoDisc>();
    }
    public void addDVD(DigitalVideoDisc dvd){
        for (int i = 0; i < length;i++){
            if (itemsInStore.get(i).equals(dvd)){
                System.out.println("This DVD is already in store");
                return;
            }
        }
        itemsInStore.add(dvd);
        length++;
        System.out.println("DVD added to store successfully");
    }
    public void removeDVD(DigitalVideoDisc dvd){
        for (int i = 0; i < length; i++){
            if (itemsInStore.get(i).equals(dvd)){
                itemsInStore.remove(i);
                length--;
                break;
            }
        }
    }
    public void print(){
        for (int i = 0; i < length; i++){
            itemsInStore.get(i).print();
        }
    }
}
