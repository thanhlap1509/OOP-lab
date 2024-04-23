package Lab02;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public void addMedia(Media media){
        for (Media item : itemsOrdered){
            if (media.equals(item)){
                System.out.println("This product is already in cart");
                return;
            }
        }
        itemsOrdered.add(media);
        System.out.println("Item added successfully");
    }
    public void removeMedia(Media media){
        for (Media item: itemsOrdered){
            if (item.equals(media)){
                itemsOrdered.remove(item);
                System.out.println("Item removed successfully");
                return;
            }
        }
        System.out.println("There is no such item in cart");
    }

    public float totalCost(){
        float total = 0;
        for (Media disc : itemsOrdered){
            if (disc == null) continue;
            total += disc.getCost();
        }
        return total;
    }
    public void printDigitalVideoDist(){
        int len = itemsOrdered.size();
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items");
        for (int i = 0; i < len;i++){
            if (itemsOrdered.get(i) != null && (itemsOrdered.get(i) instanceof DigitalVideoDisc)){
                ((DigitalVideoDisc) (itemsOrdered.get(i))).toString(i);
            }
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("***************************************************");
    }
    public void searchByTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title that you want to search for: ");
        String title = scanner.nextLine();
        int founded = 0;
        for (int i = 0; i < itemsOrdered.size();i++) {
            Media media = itemsOrdered.get(i);
            if (media != null) {
                if (media.isMatch(title)) {
                    if (founded == 0) {
                        founded = 1;
                        System.out.println("We have found the resulting DVD with the title: " + '"' + title + '"');
                        if (media instanceof DigitalVideoDisc){
                            ((DigitalVideoDisc) media).toString(i);
                        }
                    }
                }
            }
        }
        if (founded == 0){
            System.out.println("There is no DVD with the title: " + '"' + title + '"');
        }
    }

}
