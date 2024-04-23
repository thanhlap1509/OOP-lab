package Lab02;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private int id;
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        this.id = id;
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }

    public Book(){
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

}
