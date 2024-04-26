package AimsProject.src.hust.soict.globalict.aims.cart;

import AimsProject.src.hust.soict.globalict.aims.Media.Book;
import AimsProject.src.hust.soict.globalict.aims.Media.CompactDisc;
import AimsProject.src.hust.soict.globalict.aims.Media.DigitalVideoDisc;
import AimsProject.src.hust.soict.globalict.aims.Media.Media;

import java.util.ArrayList;
import java.util.Collections;
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
    public void removeMedia(String title){
      for (Media media : itemsOrdered){
          if (( media.getTitle() ).equals(title)){
              itemsOrdered.remove(media);
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
    public void printMedia(){
        int len = itemsOrdered.size();
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items");
        for (int i = 0; i < len;i++){
            if (itemsOrdered.get(i) instanceof DigitalVideoDisc){
                ((DigitalVideoDisc) itemsOrdered.get(i)).toString(i);
            }
            else if (itemsOrdered.get(i) instanceof CompactDisc){
                ((CompactDisc) itemsOrdered.get(i)).toString(i);
            }
            else if (itemsOrdered.get(i) instanceof Book){
                ((Book) itemsOrdered.get(i)).toString(i);
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
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                if (founded == 0) {
                    founded = 1;
                    System.out.println("Found " + media);
                }
            }
        }
        if (founded == 0){
            System.out.println("There is no DVD with the title " + '"' + title + '"');
        }
    }
    public void searchById(int id){
        for (int i = 0; i < itemsOrdered.size();i++){
            Media media = itemsOrdered.get(i);
            if (media instanceof Book){
                if (((Book)media).getId() == id){
                    ((Book) media).toString(i);
                }
            }
            else if (media instanceof CompactDisc){
                if (((CompactDisc)media).getId() == id){
                    ((CompactDisc)media).toString(i);
                }
            }
        }
    }
    public void searchByCategory(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the category that you want to search for: ");
        String category = scanner.nextLine();
        int found = 0;
        for (Media media : itemsOrdered){
            if ((media.getCategory()).equals(category)){
                System.out.println("Found " + media);
                found = 1;
            }
        }
        if (found == 0){
            System.out.println("There is no DVD with the category '" + category + "'");
        }
    }
    public void clear(){
        itemsOrdered.clear();
        System.out.println("Cart has been clear");
    }
    public void sortByTitle() {
        itemsOrdered.sort(Media.COMPARATOR_BY_TITLE_COST);
    }
    public void sortByCost(){
        itemsOrdered.sort(Media.COMPARATOR_BY_COST_TITLE);
    }
}
