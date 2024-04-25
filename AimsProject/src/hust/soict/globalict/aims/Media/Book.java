package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Media.Media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private int id;
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        this.id = id;
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }

    public Book(){
        setCost(0);
        setTitle("");
        setCategory("");
        this.id = 0;
    }
    public void addAuthor(String authorName){
        for (String name : authors){
            if (name.equals(authorName)) {
                System.out.println("this author is already in the list");
                return;
            }
        }
        authors.add(authorName);
        System.out.println("Author added successfully");
    }
    public void removeAuthor(String authorName){
        for (int i = 0; i < authors.size();i++){
            if (authors.get(i).equals(authorName)){
                authors.remove(i);
                System.out.println("Author removed successfully");
                return;
            }
        }
        System.out.println("There is no author name "  + authorName + " in the list");
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void toString(int i){
        System.out.print((i + 1)+ ". Book - " + this.getTitle() + " - " + this.getCategory() + " - ");
        if (authors.size() == 1){
            System.out.print(authors.get(0));
        }
        else {
            System.out.print(authors.get(0));
            for (int j = 1; j < authors.size();j++){
                System.out.print(", " + authors.get(j));
            }
        }
        System.out.println(": " + this.getCost() + " $");
    }

}
