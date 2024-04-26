package AimsProject.src.hust.soict.globalict.aims.Aims;

import AimsProject.src.hust.soict.globalict.aims.Media.*;
import AimsProject.src.hust.soict.globalict.aims.Playable.Playable;
import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.store.Store;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    private static int userOpt;
    private static String userOptStr;
    public static void main(String[] args){
        showMenu();
    }
    public static void getUserInput(int l, int g){
        userOpt = -1;
        userOptStr = scanner.nextLine();
        try {
            userOpt = Integer.parseInt(userOptStr);
        } catch (NumberFormatException e){
            System.out.print("Please choose again: ");
            getUserInput(l, g);
        }
        if (!(userOpt >= l && userOpt <= g)) {
            System.out.print("Please choose again: ");
            getUserInput(l, g);
        }
    }
    public static void showMenu(){
        System.out.println();
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
        getUserInput(0, 3);
        switch(userOpt){
                case 1:
                    storeMenu();
                    return;
                case 2:
                    updateStore();
                    return;
                case 3:
                    cart.printMedia();
                    cartMenu();
                    return;
                case 0:
                    System.out.println("Goodbye!");
                    return;
        }
    }

    public static void storeMenu() {
        System.out.println();
        store.displayMedia();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
        getUserInput(0, 4);
            switch(userOpt){
                case 1:
                    System.out.print("Please enter a title: ");
                    userOptStr = scanner.nextLine();
                    Media media = store.searchByTitle(userOptStr);
                    if (media == null) {
                        System.out.println("There is no media with that title");
                        storeMenu();
                    }
                    else {
                        mediaDetailsMenu(media);
                    }
                    return;
                case 2:
                    System.out.print("Please enter the title of media that you want to add: ");
                    userOptStr = scanner.nextLine();
                    Media returnMedia = store.searchByTitle(userOptStr);
                    if (returnMedia == null){
                        System.out.println("There is no media with that title");
                    }
                    else {
                        cart.addMedia(returnMedia);
                    }
                    storeMenu();
                    return;
                case 3:
                    playMedia();
                    storeMenu();
                    return;
                case 4:
                    cart.printMedia();
                    cartMenu();
                    return;
                case 0:
                    showMenu();
                    return;
            }
        }

    public static void mediaDetailsMenu(Media media) {
        System.out.println();
        System.out.println("Found: " + media.getTitle() + " - " + media.getCategory() + " - " + media.getCost());
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        getUserInput(0, 2);
            switch(userOpt){
                case 1:
                    System.out.print("Please enter the title of media that you want to add: ");
                    userOptStr = scanner.nextLine();
                    Media returnMedia = store.searchByTitle(userOptStr);
                    if (returnMedia == null){
                        System.out.println("There is no media with that title");
                    }
                    else {
                        cart.addMedia(returnMedia);
                    }
                    mediaDetailsMenu(media);
                    return;
                case 2:
                    playMedia();
                    mediaDetailsMenu(media);
                    return;
                case 0:
                    storeMenu();
                    return;
            }
        }

    public static void updateStore(){
        System.out.println();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        getUserInput(0, 2);
            switch(userOpt) {
                case 1:
                    userOptStr = " ";
                    String title, category;
                    float cost;
                    while (!userOptStr.equals("Book") && !userOptStr.equals("DVD") && !userOptStr.equals("CD")) {
                        System.out.print("What type of media do you want to add(Book/CD/DVD): ");
                        userOptStr = scanner.nextLine();
                    }
                    if (userOptStr.equals("Book")) {
                        System.out.print("Enter book id: ");
                        int id = getInt();
                        System.out.print("Enter book title: ");
                        title = scanner.nextLine();
                        System.out.print("Enter book category: ");
                        category = scanner.nextLine();
                        System.out.print("Enter book cost: ");
                        cost = getFloat();
                        Book book = new Book(id, title, category, cost);
                        System.out.print("How many author do you want to add: ");
                        int author = getInt();
                        String authorName = "";
                        for (int i = 0; i < author; i++){
                            System.out.print("Enter author name: ");
                            authorName = scanner.nextLine();
                             if (book.addAuthor(authorName) == 0){
                                 i--;
                             };
                        }
                        store.addMedia(book);
                    } else if (userOptStr.equals("CD")) {
                        System.out.print("Please enter CD id: ");
                        int id = getInt();
                        System.out.print("Enter CD title: ");
                        title = scanner.nextLine();
                        System.out.print("Enter CD category: ");
                        category = scanner.nextLine();
                        System.out.print("Enter CD cost: ");
                        cost = getFloat();
                        System.out.print("Please enter CD artist: ");
                        String artist = scanner.nextLine();
                        System.out.print("Please enter CD director: ");
                        String director = scanner.nextLine();
                        CompactDisc cd = new CompactDisc(id, title, category, director, 0, cost, artist);
                        //get number of track for cd and add each track
                        System.out.print("How many track do you want to add: ");
                        int numberOfTrack = getInt();
                        for (int i = 0; i < numberOfTrack; i++){
                            System.out.print("Enter track title: ");
                            String trackTitle = scanner.nextLine();
                            System.out.print("Enter track length: ");
                            int length = getInt();
                            Track track = new Track(trackTitle, length);
                            cd.addTrack(track);
                        }
                        //finally, add cd to store
                        store.addMedia(cd);
                    } else {
                        System.out.print("Enter DVD title: ");
                        title = scanner.nextLine();
                        System.out.print("Enter DVD category: ");
                        category = scanner.nextLine();
                        System.out.print("Enter DVD cost: ");
                        cost = getFloat();
                        System.out.print("Please enter DVD director: ");
                        String director = scanner.nextLine();
                        System.out.print("Please enter DVD length: ");
                        int length = getInt();
                        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                        store.addMedia(dvd);
                    }
                    updateStore();
                    return;
                case 2:
                    System.out.print("Enter title of media that you want to remove: ");
                    title = scanner.nextLine();
                    Media mediaToDelete = store.searchByTitle(title);
                    if (mediaToDelete == null){
                        System.out.println("There is no media by that title");
                    }
                    else {
                        store.removeMedia(mediaToDelete);
                    }
                    updateStore();
                    return;
                case 0:
                    showMenu();
                    return;
            }
        }
    public static void cartMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
        getUserInput(0, 5);
        switch(userOpt){
            case 0:
                showMenu();
                return;
            case 1:
                String choice = " ";
                while (!choice.equals("id") && !choice.equals("title")){
                    System.out.print("Choose filtering option (id/title): ");
                    choice = scanner.nextLine();
                }
                if (choice.equals("id")){
                    System.out.print("Enter the id that you want to search: ");
                    int id = getInt();
                    cart.searchById(id);
                }
                else {
                    cart.searchByTitle();
                }
                cartMenu();
                return;
            case 2:
                choice = " ";
                while (!choice.equals("cost") && !choice.equals("title")){
                    System.out.print("Choose filtering option (cost/title): ");
                    choice = scanner.nextLine();
                }
                if (choice.equals("title")){
                    cart.sortByTitle();
                }
                else{
                    cart.sortByCost();
                }
                cartMenu();
                return;
            case 3:
                System.out.print("Enter title of the media that you want to remove: ");
                String title = scanner.nextLine();
                cart.removeMedia(title);
                cartMenu();
                return;
            case 4:
                playMedia();
                cartMenu();
                return;
            case 5:
                System.out.println("An order has been created");
                cart.clear();
                return;
        }
    }
    public static int getInt(){
        int temp = -1;
        while (temp == -1){
            try {
                temp = scanner.nextInt();
            } catch(NumberFormatException | InputMismatchException e){
                System.out.print("Please enter again: ");
                temp = -1;
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return temp;
    }
    public static float getFloat() {
        float temp = -1f;
        while (temp == -1f){
            try {
                temp = scanner.nextFloat();
            } catch(NumberFormatException | InputMismatchException e){
                System.out.print("Please enter again: ");
                temp = -1f;
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return temp;
    }
    public static void playMedia(){
        System.out.print("Please enter the title of media that you want to play: ");
        userOptStr = scanner.nextLine();
        Media returnMedia = store.searchByTitle(userOptStr);
        if (returnMedia == null){
            System.out.println("There is no media with that title");
        }
        else if ( returnMedia instanceof DigitalVideoDisc){
            ((DigitalVideoDisc) returnMedia).play();
        }
        else if (returnMedia instanceof CompactDisc){
            ((CompactDisc) returnMedia).play();
        }
        else {
            System.out.println("this type of media can't be play");
        }
    }
}
