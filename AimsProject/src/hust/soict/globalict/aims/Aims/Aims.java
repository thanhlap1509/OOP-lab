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
        initSetup();
        showMenu();
    }
    public static void getUserInput(int l, int g){
        userOpt = -1;
        userOptStr = scanner.nextLine().strip();
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
                    userOptStr = scanner.nextLine().strip();
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
                    userOptStr = scanner.nextLine().strip();
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
                    userOptStr = scanner.nextLine().strip();
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
                        userOptStr = scanner.nextLine().strip();
                    }
                    if (userOptStr.equals("Book")) {
                        System.out.print("Enter book id: ");
                        int id = getInt();
                        System.out.print("Enter book title: ");
                        title = scanner.nextLine().strip();
                        System.out.print("Enter book category: ");
                        category = scanner.nextLine().strip();
                        System.out.print("Enter book cost: ");
                        cost = getFloat();
                        Book book = new Book(id, title, category, cost);
                        System.out.print("How many author do you want to add: ");
                        int author = getInt();
                        String authorName = "";
                        for (int i = 0; i < author; i++){
                            System.out.print("Enter author name: ");
                            authorName = scanner.nextLine().strip();
                             if (book.addAuthor(authorName) == 0){
                                 i--;
                             };
                        }
                        store.addMedia(book);
                    } else if (userOptStr.equals("CD")) {
                        System.out.print("Please enter CD id: ");
                        int id = getInt();
                        System.out.print("Enter CD title: ");
                        title = scanner.nextLine().strip();
                        System.out.print("Enter CD category: ");
                        category = scanner.nextLine().strip();
                        System.out.print("Enter CD cost: ");
                        cost = getFloat();
                        System.out.print("Please enter CD artist: ");
                        String artist = scanner.nextLine().strip();
                        System.out.print("Please enter CD director: ");
                        String director = scanner.nextLine().strip();
                        CompactDisc cd = new CompactDisc(id, title, category, director, 0, cost, artist);
                        //get number of track for cd and add each track
                        System.out.print("How many track do you want to add: ");
                        int numberOfTrack = getInt();
                        for (int i = 0; i < numberOfTrack; i++){
                            System.out.print("Enter track title: ");
                            String trackTitle = scanner.nextLine().strip();
                            System.out.print("Enter track length: ");
                            int length = getInt();
                            Track track = new Track(trackTitle, length);
                            if (cd.addTrack(track) == 0){
                                i--;
                            };
                        }
                        //finally, add cd to store
                        store.addMedia(cd);
                    } else {
                        System.out.print("Enter DVD title: ");
                        title = scanner.nextLine().strip();
                        System.out.print("Enter DVD category: ");
                        category = scanner.nextLine().strip();
                        System.out.print("Enter DVD cost: ");
                        cost = getFloat();
                        System.out.print("Please enter DVD director: ");
                        String director = scanner.nextLine().strip();
                        System.out.print("Please enter DVD length: ");
                        int length = getInt();
                        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                        store.addMedia(dvd);
                    }
                    updateStore();
                    return;
                case 2:
                    System.out.print("Enter title of media that you want to remove: ");
                    title = scanner.nextLine().strip();
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
                    choice = scanner.nextLine().strip();
                }
                if (choice.equals("id")){
                    System.out.print("Enter the id that you want to search: ");
                    int id = getInt();
                    cart.searchById(id);
                }
                else {
                    System.out.print("Enter the title that you want to search: ");
                    String title = scanner.nextLine().strip();
                    Media returnMedia = cart.searchByTitle(title);
                    if (returnMedia == null){
                        System.out.println("There is no media with that title");
                    }
                    else {
                        System.out.println("Media with title " + title + " : ");
                        if (returnMedia instanceof Book) {
                            ((Book) returnMedia).toString(0);
                        }
                        else if (returnMedia instanceof CompactDisc){
                            ((CompactDisc) returnMedia).toString(0);
                        }
                        else {
                            ((DigitalVideoDisc) returnMedia).toString(0);
                        }
                    }
                }
                cartMenu();
                return;
            case 2:
                choice = " ";
                while (!choice.equals("cost") && !choice.equals("title")){
                    System.out.print("Choose filtering option (cost/title): ");
                    choice = scanner.nextLine().strip();
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
                String title = scanner.nextLine().strip();
                cart.removeMedia(title);
                cartMenu();
                return;
            case 4:
                playMediaInCart();
                cartMenu();
                return;
            case 5:
                System.out.println("An order has been created");
                cart.clear();
                showMenu();
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
                scanner.nextLine().strip();
            }
        }
        scanner.nextLine().strip();
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
                scanner.nextLine().strip();
            }
        }
        scanner.nextLine().strip();
        return temp;
    }
    public static void playMedia(){
        System.out.print("Please enter the title of media that you want to play: ");
        userOptStr = scanner.nextLine().strip();
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
    public static void playMediaInCart(){
        System.out.print("Please enter the title of media that you want to play: ");
        userOptStr = scanner.nextLine().strip();
        Media returnMedia = cart.searchByTitle(userOptStr);
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
    public static void initSetup() {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);


        Book book = new Book("The Valley of Fear", "Detective", 20.00f);
        book.addAuthor("Arthur Conan Doyle");
        Book book1 = new Book("A Living Remedy: A Memoir", "Biography", 202.00f);
        book1.addAuthor("Nicole Chung");
        Book book2 = new Book("On the Origin of Time: Stephen Hawking's Final Theory", "Science", 120.00f);
        book2.addAuthor("Thomas Hertog");
        store.addMedia(book);
        store.addMedia(book1);
        store.addMedia(book2);


        CompactDisc cd1 = new CompactDisc("30", "Music","Adele", 1500.98f);
        Track track1CD1 = new Track("All Night Parking (interlude)", 161);
        Track track2CD1 = new Track("To Be Loved", 403);
        Track track3CD1 = new Track("Woman Like Me", 300);
        cd1.addTrack(track1CD1);
        cd1.addTrack(track2CD1);
        cd1.addTrack(track3CD1);

        CompactDisc cd2 = new CompactDisc("The Gods We Can Touch", "Music","Aurora", 2000.22f);
        Track track1CD2 = new Track("Everything Matters", 180+34);
        Track track2CD2 = new Track("Blood in the Wine", 180+30);
        Track track3CD2 = new Track("Artemis", 60*2+39);
        cd2.addTrack(track1CD2);
        cd2.addTrack(track2CD2);
        cd2.addTrack(track3CD2);

        CompactDisc cd3 = new CompactDisc("Purpose", "Music","Justin Bieber", 1000.98f);
        Track track1CD3 = new Track("The Feeling", 4*60+5);
        Track track2CD3 = new Track("No Sense", 4*60+35);
        cd3.addTrack(track1CD3);
        cd3.addTrack(track2CD3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }

}
