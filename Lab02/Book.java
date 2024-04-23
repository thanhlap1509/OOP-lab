package Lab02;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Book(){
        this.id = 0;
        this.title = "";
        this.category = "";
        this.cost = 0f;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

}
