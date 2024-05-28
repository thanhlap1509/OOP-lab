package AimsProject.src.hust.soict.globalict.aims.Media;

import AimsProject.src.hust.soict.globalict.aims.Media.Media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    public Book(int id,String title, String category, float cost) {
        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }
    public Book(){
        setCost(0);
        setTitle("");
        setCategory("");
        setId(0);
    }
    public int addAuthor(String authorName){
        for (String name : authors){
            if (name.equals(authorName)) {
                System.out.println("this author is already in the list");
                return 0;
            }
        }
        authors.add(authorName);
        System.out.println("Author added successfully");
        return 1;
    }
    public int removeAuthor(String authorName){
        for (int i = 0; i < authors.size();i++){
            if (authors.get(i).equals(authorName)){
                authors.remove(i);
                System.out.println("Author removed successfully");
                return 1;
            }
        }
        System.out.println("There is no author name "  + authorName + " in the list");
        return 0;
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

    public String toString(){
        StringBuilder returnString = new StringBuilder(this.getId() + ". Book - " + this.getTitle() + " - " + this.getCategory() + " - ");
        if (authors.size() == 1){
            System.out.print(authors.get(0));
        }
        else {
            System.out.print(authors.get(0));
            for (int j = 1; j < authors.size();j++){
                returnString.append(", ").append(authors.get(j));
            }
        }
        return returnString.toString();
    }
}
